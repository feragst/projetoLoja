/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package entidades;

import models.Cliente;
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
public class ClienteTest {

    public ClienteTest() {
    }

    private Cliente cliente;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // Este método roda antes de CADA @Test. 
        // Aqui criamos um novo Cliente para cada caso de teste.
        cliente = new Cliente();
    }

    @After
    public void tearDown() {
        // Este método roda depois de CADA @Test.
        // Em testes simples, basta “zerar” ou liberar a instância.
        cliente = null;
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange (já temos 'cliente' criado no setUp):
        int idEsperado = 42;
        String nomeEsperado = "Juca Bala";
        String cpfEsperado = "123.456.789-00";
        String enderecoEsperado = "Rua A, 123";
        String telefoneEsperado = "01/01/1990";

        // Act: usamos setters
        cliente.setIdCliente(idEsperado);
        cliente.setNome(nomeEsperado);
        cliente.setCpf(cpfEsperado);
        cliente.setTelefone(telefoneEsperado);


        // Assert: verificamos via getters
        assertEquals(idEsperado, cliente.getIdCliente());
        assertEquals(nomeEsperado, cliente.getNome());
        assertEquals(cpfEsperado, cliente.getCpf());
        assertEquals(telefoneEsperado, cliente.getTelefone());

    }

    @Test
    public void testToString() {
        // Arrange
        cliente.setIdCliente(5);
        cliente.setNome("Cleiton");
        cliente.setCpf("987.654.321-00");
        cliente.setTelefone("Av. B, 456");


        // Act
        String esperado = "5;Cleiton;987.654.321-00;Av. B, 456";
        String obtido = cliente.toString();

        // Assert
        assertEquals(esperado, obtido);
    }
}
