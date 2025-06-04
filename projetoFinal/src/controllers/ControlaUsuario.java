/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import java.sql.SQLException;
import java.util.ArrayList;
import models.Usuario;
import models.DAO.UsuarioDAO;

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
    

    public boolean salvar(Usuario u) {
        try {
            usuarioDAO.salvar(u);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar usuario: " + ex.getMessage());
            return false;
        }
    }

    //    editar()
    public boolean editar(Usuario u){
        try {
            usuarioDAO.editar(u);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar usuario: " + ex.getMessage());
            return false;
        }
    }
//        
//    }
//    
//    excluir()
        public boolean excluir(int id){
        try {
            usuarioDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir usuario: " + ex.getMessage());
            return false;
        }
    }
//        
//    }
//    
//    recuperar()
    public Usuario recuperar(int id){
        try {
            Usuario usuario = usuarioDAO.recuperar(id);
            return usuario;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuario: " + ex.getMessage());
            return null;
        }
    }
//        
//    }
    
      public ArrayList<Usuario> recuperarTodos(){
        ArrayList<Usuario> vetorUsuarios = null;
        try {
            vetorUsuarios = usuarioDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar usuario: " + ex.getMessage());
        }
        return vetorUsuarios;
    }
}
