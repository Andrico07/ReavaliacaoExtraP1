package com.mycompany.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Pedido {
    
    private String cliente;
    private LocalDate data;
    private double valorTotal, valorDesconto, valorImposto, valorFinal;
    private List<ItemPedido> carrinho;
    private List<Desconto> descontosConcedidos;
    private List<Imposto> impostos;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.carrinho = new ArrayList();
        this.descontosConcedidos = new ArrayList();
        this.impostos = new ArrayList();
    }
    
    public String getCliente(){
        return cliente;
    }
    
    public LocalDate getData(){
        return this.data;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    public double getValorDesconto() {
        return valorDesconto;
    }
    
    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
    
    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }
    
    public double getValorFinal() {
        return valorFinal;
    }
    
    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public List<ItemPedido> getCarrinho() {
        return carrinho;
    }
    
    public List<Desconto> getDescontosConcedidos() {
        return descontosConcedidos;
    }
    
    public List<Imposto> getImpostos() {
        return impostos;
    }
    
    public void addItem(ItemPedido item) {
        carrinho.add(item);
        valorTotal += item.getProduto().getValorUnitario() * item.getQuantidade();
        
    }
    
    public void removeItem(ItemPedido item) {
        carrinho.remove(item);
        valorTotal -= item.getProduto().getValorUnitario() * item.getQuantidade();
    }
    
    public void addDesconto(Desconto desconto) {
        descontosConcedidos.add(desconto);
        
    }
    
    public void removeDesconto(Desconto desconto) {
        descontosConcedidos.remove(desconto);
    }
    
    public void addImposto(Imposto imposto) {
        impostos.add(imposto);
        
    }
    
    public void removeImposto(Imposto imposto) {
        impostos.remove(imposto);
    }
    
    
}