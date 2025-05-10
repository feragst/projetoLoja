/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author fernando.agostini
 */
public class ClienteDAO {
  

    ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public void salvar(Cliente c) throws SQLException {

        String sql = ""
                + "INSERT INTO cliente (nome, cpf, telefone) VALUES ("
                + "'" + c.getNome() + "',"
                + "'" + c.getCpf() + "',"
                + "'" + c.getTelefone() + "')";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);

    }

    public ArrayList<Cliente> recuperarTodos() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList();

        String sql = ""
                + "SELECT * FROM cliente ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Cliente cliente = new Cliente();

            cliente.setIdCliente(resultadoQ.getInt("idCliente"));
            cliente.setNome(resultadoQ.getString("nome"));
            cliente.setCpf(resultadoQ.getString("cpf"));
            cliente.setTelefone(resultadoQ.getString("telefone"));
            

            clientes.add(cliente);
        }
        

        return clientes;
    }
       public Cliente recuperar(int id) throws SQLException {
        Cliente cliente = null;
        String sql = ""
                + "SELECT * FROM cliente WHERE idcliente = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            cliente = new Cliente();

            cliente.setIdCliente(resultadoQ.getInt("idCliente"));
            cliente.setNome(resultadoQ.getString("nome"));
            cliente.setCpf(resultadoQ.getString("cpf"));
            cliente.setTelefone(resultadoQ.getString("telefone"));
        }

        return cliente;
    }
    
    public void editar(Cliente c) throws SQLException {
        String sql = ""
                + "UPDATE cliente "
                + "SET "
                + "nome = '" + c.getNome() + "',"
                + "cpf = '" + c.getCpf() + "', "
                + "telefone = '" + c.getTelefone() + "' "
                + "WHERE idcliente = " + c.getIdCliente();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM cliente WHERE idcliente = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
