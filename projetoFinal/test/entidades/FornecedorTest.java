/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades;

import models.Fornecedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mateus
 */
public class FornecedorTest {

    public FornecedorTest() {
    }

    private Fornecedor fornecedor;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Este método roda antes de CADA @Test. 
        // Aqui criamos um novo Fornecedor para cada caso de teste.
        fornecedor = new Fornecedor();
    }

    @After
    public void tearDown() {
        // Este método roda depois de CADA @Test.
        // Em testes simples, basta “zerar” ou liberar a instância.
        fornecedor = null;
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange (já temos 'cliente' criado no setUp):
        int idEsperado = 42;
        String nomeEsperado = "Juca Bala";
        String cnpjEsperado = "123.456.789-00";
        String telefoneEsperado = "222   ";
        String enderecoEsperado = "Rua A, 123";

        // Act: usamos setters
        fornecedor.setIdFornecedor(idEsperado);
        fornecedor.setNome(nomeEsperado);
        fornecedor.setCnpj(cnpjEsperado);
        fornecedor.setTelefone(telefoneEsperado);
        fornecedor.setEndereco(enderecoEsperado);


        // Assert: verificamos via getters
        assertEquals(idEsperado, fornecedor.getIdFornecedor());
        assertEquals(nomeEsperado, fornecedor.getNome());
        assertEquals(cnpjEsperado, fornecedor.getCnpj());
        assertEquals(telefoneEsperado, fornecedor.getTelefone());
         assertEquals(enderecoEsperado, fornecedor.getEndereco());

    }

    @Test
    public void testToString() {
        // Arrange
        fornecedor.setIdFornecedor(5);
        fornecedor.setNome("Cleiton");
        fornecedor.setCnpj("987.654.321-00");
        fornecedor.setTelefone("222");
        fornecedor.setEndereco("Av. B, 456");

        


        // Act
        String esperado = "5;Cleiton;987.654.321-00;222;Av. B, 456";
        String obtido = fornecedor.toString();

        // Assert
        assertEquals(esperado, obtido);
    }
}
