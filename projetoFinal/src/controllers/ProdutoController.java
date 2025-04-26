/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import models.Produto;

/**
 *
 * @author fernando.agostini
 */
public class ProdutoController {
    
     ArrayList<Produto> vetorProduto = new ArrayList();

    public void salvar(Produto p) {
        vetorProduto.add(p);
    }
    //m,,

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
        for (int i = 0; i < vetorProduto.size(); i++) {
            Produto p = vetorProduto.get(i);
            p.imprimeAtributos();
        }
}
    
}
