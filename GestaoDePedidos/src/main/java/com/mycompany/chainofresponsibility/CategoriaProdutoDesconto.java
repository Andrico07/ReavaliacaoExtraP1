package com.mycompany.chainofresponsibility;

import com.mycompany.model.Desconto;
import com.mycompany.model.ItemPedido;
import com.mycompany.model.Pedido;


public class CategoriaProdutoDesconto extends AbstractDescontoHandler {
    
    private double valor = 0;
    private Desconto descontoCategoria;

    @Override
    public void aplicarDesconto(Pedido pedido) {
        for(ItemPedido item : pedido.getCarrinho()) {
            if(item.getProduto().getCategoria().equals("Papelaria"))
                valor += item.getValorTotal() * 0.01;
        }
        if(valor != 0){
            descontoCategoria = new Desconto("Desconto por tipo de produto(Papelaria)", 1, valor);
            pedido.addDesconto(descontoCategoria);
        }
        
        if(nextHandler != null)
            nextHandler.aplicarDesconto(pedido);
    }
    
}
