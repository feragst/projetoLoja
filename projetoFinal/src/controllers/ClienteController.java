/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Cliente;
import models.DAO.ClienteDAO;

/**
 *
 * @author fernando.agostini
 */
public class ClienteController {

    ClienteDAO clienteDAO = new ClienteDAO();

    public boolean salvar(Cliente c) {
        try {
            clienteDAO.salvar(c);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar cliente: " + ex.getMessage());
            return false;
        }
    }

    //    editar(){
//        
//    }
//    
//    excluir(){
//        
//    }
//    
//    recuperar(){
//        
//    }
    
      public ArrayList<Cliente> recuperarTodos(){
        ArrayList<Cliente> vetorClientes = null;
        try {
            vetorClientes = clienteDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar clientes: " + ex.getMessage());
        }
        return vetorClientes;
    }
}
