/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.DAO;

import apoio.ConexaoBD;
import models.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateus
 */
public class UsuarioDAO {

    private ResultSet resultadoQ = null; // interface que representa o resultado de uma consulta SQL executada em um banco de dados

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
