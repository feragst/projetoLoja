/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades.DAO;

import apoio.ConexaoBD;
import entidades.ClienteTest;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Cliente;
import models.DAO.ClienteDAO;
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
/**
 * Testa a classe ClienteDAO usando os dados de db-test: 
 * 1) Cria tabela cliente em @BeforeClass 
 * 2) No @Before, limpa o conteúdo da tabela antes de cada teste 
 * 3) Executa os testes
 * 4) Em @AfterClass, dropa a tabela e fecha a conexão
 */
public class ClienteDAOTest {

    // SQL para criar e dropar a tabela de teste
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS cliente ( "
            + "  idcliente SERIAL PRIMARY KEY, "
            + "  nome VARCHAR(255) NOT NULL, "
            + "  cpf CHAR(11) NOT NULL, "
            + "  telefone VARCHAR(255) NOT NULL "
           +");";

    private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS cliente;";

    private ClienteDAO dao;

    public ClienteDAOTest() {
        // Construtor default: não precisa inicializar nada aqui
    }

    /**
     * Executa UMA VEZ antes de todos os métodos @Test desta classe. Cria a
     * tabela cliente.
     */
    @BeforeClass
    public static void setUpClass() {
        try {
            System.setProperty("db.config", "db-test.properties");
            ConexaoBD.executeUpdate(SQL_CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @BeforeClass: falha ao criar tabela 'cliente'.\n" + e.getMessage(), e);
        }
    }

    /**
     * Executa UMA VEZ após todos os métodos @Test desta classe. Dropa a tabela
     * cliente e finaliza o singleton de conexão.
     */
    @AfterClass
    public static void tearDownClass() {
        try {
            ConexaoBD.executeUpdate(SQL_DROP_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @AfterClass: falha ao dropar tabela 'cliente'.\n" + e.getMessage(), e);
        }
    }

    /**
     * Executa ANTES de cada método @Test. Instancia o DAO e limpa a
     * tabela para isolar cada teste.
     */
    @Before
    public void setUp() {
        // Garante que começa com uma conexão “zerada”
        ConexaoBD.getInstance().shutdown();

        // Instancia o DAO
        dao = new ClienteDAO();

        // Limpa todos os registros da tabela antes de cada teste e reseta a sequência do serial
        try {
            ConexaoBD.executeUpdate("TRUNCATE TABLE cliente RESTART IDENTITY;");
        } catch (SQLException e) {
            throw new RuntimeException("Erro em @Before setUp(): falha ao truncar ou reiniciar serial da tabela 'cliente'.\n" + e.getMessage(), e);
        }
    }

    /**
     * Executa APÓS cada método @Test. Fecha a conexão para
     * garantir que o próximo teste comece do zero.
     */
    @After
    public void tearDown() {
        ConexaoBD.getInstance().shutdown();
    }

    /**
     * Testa a inserção de um cliente: 
     * 1) Insere um cliente via dao.salvar 
     * 2) Recupera todos os clientes e valida a existencia de somente 1
     * 3) Recupera via dao.recuperar(1) e valida a alteração
     */
    @Test
    public void testInserirERetornarCliente() throws SQLException {
        // 1) Cria objeto e insere no banco
        Cliente c = new Cliente();
        c.setNome("João da Silva");
        c.setCpf("12345678901");
        c.setTelefone("Rua das Flores, 100");
        dao.salvar(c);

        // 2) Recupera todos os clientes, deve haver 1
        ArrayList<Cliente> lista = dao.recuperarTodos();
        assertNotNull("Lista não deve ser nula", lista);
        assertEquals("Deve haver exatamente 1 cliente na tabela", 1, lista.size());

        // 3) Recupera o cliente inserido e valida os dados
        Cliente recuperado = dao.recuperar(1);
        assertNotNull("recuperar(id) não deve retornar null", recuperado);
        assertEquals(1, recuperado.getIdCliente());
        assertEquals(c.getNome(), recuperado.getNome());
        assertEquals(c.getCpf(), recuperado.getCpf());
        assertEquals(c.getTelefone(), recuperado.getTelefone());

    }

    /**
     * Testa a edição de um cliente com ID = 1: 
     * 1) Insere um cliente inicial 
     * 2) Altera nome e endereço via dao.editar(...) 
     * 3) Recupera via dao.recuperar(1) e valida a alteração
     */
    @Test
    public void testEditarCliente() throws SQLException {
        // 1) Primeiro insere um registro
        Cliente c = new Cliente();
        c.setNome("Maria Pereira");
        c.setCpf("98765432100");
        c.setTelefone("Av. Central, 50");
 
        dao.salvar(c);

        // 2) Prepara novo objeto com ID = 1 e informações modificadas e edita
        Cliente modificado = new Cliente();
        modificado.setIdCliente(1);                          // fixa ID = 1
        modificado.setNome("Maria P. Oliveira");      // novo nome
        modificado.setCpf("98765432100");             // mantém CPF original
        modificado.setTelefone("Rua Nova, 123");      // novo endereço

        dao.editar(modificado);

        // 3) Recupera do banco e valida que os campos foram atualizados
        Cliente recuperado = dao.recuperar(1);
        assertNotNull("Cliente com ID 1 deveria existir após edição", recuperado);
        assertEquals(1, recuperado.getIdCliente());
        assertEquals("Maria P. Oliveira", recuperado.getNome());
        assertEquals("98765432100", recuperado.getCpf());
        assertEquals("Rua Nova, 123", recuperado.getTelefone());

    }

    /**
     * Testa a exclusão de um cliente com ID = 1: 
     * 1) Insere um cliente inicial 
     * 2) Chama dao.excluir(1) 
     * 3) Verifica que dao.recuperar(1) retorna null 
     * 4) Verifica que dao.recuperarTodos() retorna lista vazia
     */
    @Test
    public void testExcluirCliente() throws SQLException {
        // 1) Insere um registro
        Cliente c = new Cliente();
        c.setNome("Carlos Souza");
        c.setCpf("11223344556");
        c.setTelefone("Praça Central, 10");

        dao.salvar(c);

        // Confirma que existe antes da exclusão
        Cliente antes = dao.recuperar(1);
        assertNotNull("Cliente com ID 1 deveria existir antes da exclusão", antes);

        // 2) Exclui o cliente de ID = 1
        dao.excluir(1);

        // 3) Verifica que recuperar(1) agora retorne null
        Cliente depois = dao.recuperar(1);
        assertNull("recuperar(1) deve retornar null após exclusão", depois);

        // 4) Verifica que recuperarTodos() retorne lista vazia
        ArrayList<Cliente> todos = dao.recuperarTodos();
        assertNotNull("Lista retornada por recuperarTodos não deve ser null", todos);
        assertTrue("Lista deve estar vazia após exclusão do cliente", todos.isEmpty());
    }
}
