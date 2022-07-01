package com.mycompany.chainofresponsibility;

import com.mycompany.model.Desconto;
import com.mycompany.model.ItemPedido;
import com.mycompany.model.Pedido;


public class IncentivoDesconto extends AbstractDescontoHandler {
    
    private double valor = 0;
    private Desconto descontoIncentivo;

    @Override
    public void aplicarDesconto(Pedido pedido) {
        for(ItemPedido item : pedido.getCarrinho()) {
            if(item.getProduto().getNome().equals("Lapis"))
                valor += item.getValorTotal() * 0.01;
        }
        if(valor != 0){
            descontoIncentivo = new Desconto("Desconto incentivo educação(Lápis)", 0.5, valor);
            pedido.addDesconto(descontoIncentivo);
        }
        
        if(nextHandler != null)
            nextHandler.aplicarDesconto(pedido);
    }
    
}
