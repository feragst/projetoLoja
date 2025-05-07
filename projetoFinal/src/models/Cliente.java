/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author fernando.agostini
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String cpf, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public void imprimeAtributos(){
        System.out.println(idCliente);
        System.out.println(nome);
        System.out.println(cpf);
        System.out.println(telefone);
   
    }
    @Override
    public String toString(){
        return idCliente + ";" + nome + ";" + cpf + ";" + telefone;
    }
    
    
    

    
    
}
