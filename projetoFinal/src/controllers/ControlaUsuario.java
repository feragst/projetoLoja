/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import models.DAO.UsuarioDAO;
import models.Usuario;
import java.sql.SQLException;

/**
 *
 * @author mateus
 */
public class ControlaUsuario {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean validaLogin(String usuario, String senha) {
        try {
            Usuario u = usuarioDAO.validaLogin(usuario, senha);
            if (u != null) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
}
