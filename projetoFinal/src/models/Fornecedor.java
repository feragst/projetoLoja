/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author fernando.agostini
 */
public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Fornecedor() {
    }
    

    public Fornecedor(int idFornecedor, String nome, String cnpj, String telefone, String endereco) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    public void imprimeAtributos(){
        System.out.println(idFornecedor);
        System.out.println(nome);
        System.out.println(cnpj);
        System.out.println(telefone);
        System.out.println(endereco);
   
    }
    
    
}
