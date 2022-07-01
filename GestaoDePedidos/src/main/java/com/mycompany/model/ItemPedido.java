package com.mycompany.model;


public class ItemPedido {
    
    private Produto produto;
    private int quantidade;
    private double valorTotal;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = produto.getValorUnitario() * quantidade;
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
}
