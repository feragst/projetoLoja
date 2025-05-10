/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import models.DAO.FornecedorDAO;
import models.Fornecedor;

/**
 *
 * @author fernando.agostini
 */
public class FornecedorController {
    
  FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public boolean salvar(Fornecedor f) {
        try {
            fornecedorDAO.salvar(f);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar fornecedor: " + ex.getMessage());
            return false;
        }
    }

    //    editar()
     public boolean editar(Fornecedor f){
        try {
            fornecedorDAO.editar(f);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao editar fornecedor: " + ex.getMessage());
            return false;
        }
    }
//        
//    }
//    
//    excluir()
     public boolean excluir(int id){
        try {
            fornecedorDAO.excluir(id);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir fornecedor: " + ex.getMessage());
            return false;
        }
    }
     
        public Fornecedor recuperar(int id){
        try {
            Fornecedor fornecedor = fornecedorDAO.recuperar(id);
            return fornecedor;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar fornecedor: " + ex.getMessage());
            return null;
        }
    }
//        
//    }
//    
//    recuperar(){
//        
//    }
    
     public ArrayList<Fornecedor> recuperarTodos(){
        ArrayList<Fornecedor> vetorFornecedores = null;
        try {
            vetorFornecedores = fornecedorDAO.recuperarTodos();
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar fornecedores: " + ex.getMessage());
        }
        return vetorFornecedores;
    }
    
}
