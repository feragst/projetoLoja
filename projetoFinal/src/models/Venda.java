/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author fernando.agostini
 */
public class Venda {

    public Venda(int idVenda, String data, double valorTotal, int idCliente) {
        this.idVenda = idVenda;
        this.data = data;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void imprimeAtributos(){
        System.out.println(idVenda);
        System.out.println(data);
        System.out.println(valorTotal);
        System.out.println(idCliente);
   
    }
    private int idVenda;
    private String data;
    private double valorTotal;

    private int idCliente;

}
