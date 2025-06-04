/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.DAO;

import apoio.ConexaoBD;
import models.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author mateus
 */
public class UsuarioDAO {

    private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados
     public void salvar(Usuario u) throws SQLException {

        String sql = ""
                + "INSERT INTO usuarios (usuario, senha) VALUES ("
                + "'" + u.getUsuario() + "',"
                + "'" + u.getSenha() + "')";

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);

    }

    public ArrayList<Usuario> recuperarTodos() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList();

        String sql = ""
                + "SELECT * FROM usuarios ";

        resultadoQ = ConexaoBD.executeQuery(sql);

        while (resultadoQ.next()) {
            Usuario usuario = new Usuario();

            usuario.setId(resultadoQ.getInt("id"));
            usuario.setUsuario(resultadoQ.getString("usuario"));
            usuario.setSenha(resultadoQ.getString("senha"));
            

            usuarios.add(usuario);
        }
        

        return usuarios;
    }
       public Usuario recuperar(int id) throws SQLException {
        Usuario usuario = null;
        String sql = ""
                + "SELECT * FROM usuarios WHERE id = " + id;

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            usuario = new Usuario();

            usuario.setId(resultadoQ.getInt("id"));
            usuario.setUsuario(resultadoQ.getString("usuario"));
            usuario.setSenha(resultadoQ.getString("senha"));
  
        }

        return usuario;
    }
    
    public void editar(Usuario u) throws SQLException {
        String sql = ""
                + "UPDATE usuarios "
                + "SET "
                + "usuario = '" + u.getUsuario() + "',"
                + "senha = '" + u.getSenha() + "' "
          
                + "WHERE id = " + u.getId();

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }
    public void excluir(int id) throws SQLException {
        String sql = ""
                + "DELETE FROM usuarios WHERE id = " + id;

        System.out.println("sql: " + sql);

        ConexaoBD.executeUpdate(sql);
    }

    public Usuario validaLogin(String usuario, String senha) throws SQLException {
        Usuario u = null;
        String sql = ""
                + "SELECT * FROM usuarios "
                + "WHERE usuario = '" + usuario + "' "
                + "AND senha = md5('" + senha + "')";

        resultadoQ = ConexaoBD.executeQuery(sql);

        if (resultadoQ.next()) {
            u = new Usuario();
            u.setId(resultadoQ.getInt("id"));
            u.setUsuario(resultadoQ.getString("usuario"));
            u.setSenha(resultadoQ.getString("senha"));
        }

        return u;
    }
}
