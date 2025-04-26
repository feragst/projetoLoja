/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import models.Cliente;

/**
 *
 * @author fernando.agostini
 */
public class ClienteController {

    ArrayList<Cliente> vetorClientes = new ArrayList();

    public void salvar(Cliente c) {
        vetorClientes.add(c);
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
        for (int i = 0; i < vetorClientes.size(); i++) {
            Cliente c = vetorClientes.get(i);
            c.imprimeAtributos();
        }
}}
