/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import models.Fornecedor;

/**
 *
 * @author fernando.agostini
 */
public class FornecedorController {
    
    ArrayList<Fornecedor> vetorFornecedor = new ArrayList();

    public void salvar(Fornecedor f) {
        vetorFornecedor.add(f);
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
    
     public void recuperarTodos(){
        for (int i = 0; i < vetorFornecedor.size(); i++) {
            Fornecedor f = vetorFornecedor.get(i);
            f.imprimeAtributos();
        }
    
}}
