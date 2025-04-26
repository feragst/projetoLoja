/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import models.Venda;

/**
 *
 * @author fernando.agostini
 */
public class VendaController {
     ArrayList<Venda> vetorVenda = new ArrayList();

    public void salvar(Venda v) {
        vetorVenda.add(v);
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
        for (int i = 0; i < vetorVenda.size(); i++) {
            Venda v = vetorVenda.get(i);
            v.imprimeAtributos();
        }
}
    
}
