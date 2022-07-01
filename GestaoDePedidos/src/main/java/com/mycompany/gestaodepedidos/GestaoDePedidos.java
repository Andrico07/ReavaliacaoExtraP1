package com.mycompany.gestaodepedidos;

import com.mycompany.model.Pedido;
import com.mycompany.model.ItemPedido;
import com.mycompany.model.Produto;
import com.mycompany.model.Desconto;
import com.mycompany.model.Imposto;
import com.mycompany.model.PedidoService;


public class GestaoDePedidos {

    public static void main(String[] args) {
        
        Pedido pedido001 = new Pedido("Fulano de tal");
        PedidoService pedidoService = new PedidoService();
        
        
        Produto papelA4 = new Produto("Papel A4", "Papelaria", 15, 100);        
        Produto caneta = new Produto("Caneta", "Papelaria", 7, 100);
        Produto borracha = new Produto("Borracha", "Papelaria", 2, 100);
        Produto lapis = new Produto("Lapis", "Papelaria", 1.2, 100);
        
        ItemPedido itemPapel = new ItemPedido(papelA4, 5);
        ItemPedido itemCaneta = new ItemPedido(caneta, 6);
        ItemPedido itemBorracha = new ItemPedido(borracha, 6);
        ItemPedido itemLapis = new ItemPedido(lapis, 6);
        
        pedido001.addItem(itemPapel);
        pedido001.addItem(itemCaneta);
        pedido001.addItem(itemBorracha);
        pedido001.addItem(itemLapis);
        
        
        pedidoService.processarPedido(pedido001);
        
        
        System.out.println("---------------------------------------------------");
        System.out.println("Item Quantidade Categoria Valor Unitario Valor Total");
        for(ItemPedido item : pedido001.getCarrinho())
            System.out.println(item.getProduto().getNome() + " " + item.getQuantidade() + " " + item.getProduto().getCategoria() + " " + item.getProduto().getValorUnitario() + " " + item.getValorTotal());
        
        System.out.println("---------------------------------------------------");
        System.out.println("Valor total do item: R$ " + pedido001.getValorTotal());
        
        System.out.println("---------------------------------------------------");
        System.out.println("Desconto % Valor");
        for(Desconto desconto : pedido001.getDescontosConcedidos())
            System.out.println(desconto.getTipo() + " " + desconto.getPorcentagem() + "% " + desconto.getValor());
        System.out.println("---------------------------------------------------");
        System.out.println("R$ " + pedido001.getValorDesconto());
        
        System.out.println("---------------------------------------------------");
        System.out.println("Imposto % Valor");
        for(Imposto imposto : pedido001.getImpostos())
            System.out.println(imposto.getTipo() + " " + imposto.getPorcentagem() + "% " + imposto.getValor());
        System.out.println("---------------------------------------------------");
        System.out.println("R$ " + pedido001.getValorImposto());
        
        System.out.println("R$ " + pedido001.getValorFinal());
        
            
        
        
    }
}
