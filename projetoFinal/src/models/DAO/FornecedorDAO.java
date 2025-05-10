/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.DAO;

import apoio.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Fornecedor;
import controllers.FornecedorController;

/**
 *
 * @author fernando.agostini
 */
public class FornecedorDAO {
  

    ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

    public void salvar(Fornecedor f) throws SQLException {

        String sql = ""
                + "INSERT INTO fornecedor (nome, cnpj, telefone, endereco) VALUES ("
                + "'" + f.getNome() + "',"
                + "'" + f.getCnpj() + "',"
                + "'" + f.getTelefone() + "',"
                + "'" + f.getEndereco() + "')";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);

    }

    public ArrayList<Fornecedor> recuperarTodos() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList();

        String sql = ""
                + "SELECT * FROM fornecedor ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setIdFornecedor(resultadoQ.getInt("idFornecedor"));
            fornecedor.setNome(resultadoQ.getString("nome"));
            fornecedor.setCnpj(resultadoQ.getString("cnpj"));
            fornecedor.setTelefone(resultadoQ.getString("telefone"));
            fornecedor.setEndereco(resultadoQ.getString("endereco"));
            

            fornecedores.add(fornecedor);
        }

        return fornecedores;
    }
     public Fornecedor recuperar(int id) throws SQLException {
        Fornecedor fornecedor = null;
        String sql = ""
                + "SELECT * FROM fornecedor WHERE idfornecedor = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            fornecedor = new Fornecedor();

            fornecedor.setIdFornecedor(resultadoQ.getInt("idFornecedor"));
            fornecedor.setNome(resultadoQ.getString("nome"));
            fornecedor.setCnpj(resultadoQ.getString("cnpj"));
            fornecedor.setTelefone(resultadoQ.getString("telefone"));
            fornecedor.setEndereco(resultadoQ.getString("endereco"));
        }

        return fornecedor;
    }
    
     public void editar(Fornecedor f) throws SQLException {
        String sql = ""
                + "UPDATE fornecedor "
                + "SET "
                + "nome = '" + f.getNome()+ "',"
                + "cnpj = '" + f.getCnpj() + "', "
                + "telefone = '" + f.getTelefone() + "' ,"
                + "endereco = '" + f.getEndereco() + "' "
                + "WHERE idfornecedor = " + f.getIdFornecedor();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
     public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM fornecedor WHERE idfornecedor = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
}
