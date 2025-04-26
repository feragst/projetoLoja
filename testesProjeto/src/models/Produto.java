/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author fernando.agostini
 */
public class Produto {

    public Produto(int idProduto, String nome, double preco, int qtdProduto, int idFornecedor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.qtdProduto = qtdProduto;
        this.idFornecedor = idFornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    public void imprimeAtributos(){
        System.out.println(idProduto);
        System.out.println(nome);
        System.out.println(preco);
        System.out.println(qtdProduto);
        System.out.println(idFornecedor);
   
    }
    private int idProduto;
    private String nome;
    private double preco;
    private int qtdProduto;
    
    private int idFornecedor;
    
}
