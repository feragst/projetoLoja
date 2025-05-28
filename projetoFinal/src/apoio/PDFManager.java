package apoio;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 *
 * @author mateus
 */
public class PDFManager {

    // larguras das colunas (em caracteres)
    private static final int[] COL_WIDTHS = {4, 16, 11, 29, 10};

    /**
     * Gera um PDF retrato com base num vetor de objetos.
     *
     * @param objetos Lista de objetos
     * @param caminhoArquivo Caminho do arquivo onde será salvo o PDF
     * @throws java.io.IOException
     */
    public static void gerar(List<?> objetos, String caminhoArquivo) throws IOException {

        if (objetos == null || objetos.isEmpty())
            throw new IllegalArgumentException("Lista de objetos está vazia.");

        try (PDDocument doc = new PDDocument()) {

            // --- Configurações de página ---
            PDRectangle pageSize = PDRectangle.A4;
            int margin     = 50;
            float leading  = 14.5f;
            int fontSize   = 10;
            int pageHeight = (int) pageSize.getHeight();
            int maxLines   = (int) ((pageHeight - 2 * margin) / leading);
            PDType1Font font = new PDType1Font(FontName.COURIER);

            // --- Obtenção dos campos ---
            Field[] fields = objetos.get(0).getClass().getDeclaredFields();
            Arrays.stream(fields).forEach(f -> f.setAccessible(true));

            // --- Cabeçalho e linha-divisória padrão ---
            String header = formatRow(Arrays.stream(fields)
                                            .map(Field::getName)
                                            .toArray(String[]::new));
            String divisor = "_".repeat(header.length());

            // --- Primeira página / stream ---
            PDPage page = new PDPage(pageSize);
            doc.addPage(page);
            PDPageContentStream out = startStream(doc, page, font,
                                                  fontSize, margin,
                                                  pageHeight, leading);

            int line = 0;
            writeLine(out, header); line++;
            writeLine(out, divisor); line++;

            // --- Iteração pelos objetos ---
            for (Object obj : objetos) {

                // valores de cada coluna
                List<String> valores = new ArrayList<>();
                for (Field f : fields) {
                    Object v = f.get(obj);
                    valores.add(v == null ? "" : v.toString());
                }

                // quebra de palavras por coluna
                List<String[]> colPartes = new ArrayList<>();
                for (int c = 0; c < valores.size(); c++)
                    colPartes.add(wrap(valores.get(c), colWidth(c)));

                int linhasNecessarias = colPartes.stream()
                                                 .mapToInt(a -> a.length)
                                                 .max().orElse(1);

                for (int l = 0; l < linhasNecessarias; l++) {

                    // monta a linha
                    StringBuilder sb = new StringBuilder();
                    for (int c = 0; c < valores.size(); c++) {
                        String txt = l < colPartes.get(c).length ? colPartes.get(c)[l] : "";
                        sb.append(fix(txt, colWidth(c))).append(" | ");
                    }
                    writeLine(out, sb.toString());
                    line++;

                    // quebra de página, se necessário
                    if (line >= maxLines - 2) {
                        out.endText(); out.close();
                        page = new PDPage(pageSize);
                        doc.addPage(page);
                        out = startStream(doc, page, font,
                                          fontSize, margin,
                                          pageHeight, leading);
                        writeLine(out, header);
                        writeLine(out, divisor);
                        line = 2;
                    }
                }

                // --- linha divisória após o registro completo ---
                writeLine(out, divisor);
                line++;

                if (line >= maxLines - 2) {
                    out.endText(); out.close();
                    page = new PDPage(pageSize);
                    doc.addPage(page);
                    out = startStream(doc, page, font,
                                      fontSize, margin,
                                      pageHeight, leading);
                    writeLine(out, header);
                    writeLine(out, divisor);
                    line = 2;
                }
            }

            out.endText();
            out.close();
            doc.save(new File(caminhoArquivo));

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao acessar atributos dos objetos", e);
        }
    }

    // ---------- utilitários internos ----------

    private static int colWidth(int idx) {
        return idx < COL_WIDTHS.length ? COL_WIDTHS[idx] : 20;
    }

    private static String fix(String txt, int w) {
        return txt.length() > w ? txt.substring(0, w)
                                : String.format("%-" + w + "s", txt);
    }

    private static String formatRow(String[] vals) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++)
            sb.append(fix(vals[i], colWidth(i))).append(" | ");
        return sb.toString();
    }

    private static String[] wrap(String txt, int w) {
        List<String> linhas = new ArrayList<>();
        StringBuilder atual = new StringBuilder();
        for (String palavra : txt.split(" ")) {
            if (atual.length() + palavra.length() + 1 <= w) {
                if (atual.length() > 0) atual.append(" ");
                atual.append(palavra);
            } else {
                linhas.add(atual.toString());
                atual = new StringBuilder(palavra);
            }
        }
        if (!atual.isEmpty()) linhas.add(atual.toString());
        return linhas.toArray(String[]::new);
    }

    private static PDPageContentStream startStream(PDDocument doc, PDPage p,
                                                   PDFont f, int size,
                                                   int margin, int pageH,
                                                   float leading) throws IOException {
        PDPageContentStream s = new PDPageContentStream(doc, p);
        s.setFont(f, size);
        s.beginText();
        s.setLeading(leading);
        s.newLineAtOffset(margin, pageH - margin);
        return s;
    }

    private static void writeLine(PDPageContentStream s, String txt) throws IOException {
        s.showText(txt); s.newLine();
    }
}
