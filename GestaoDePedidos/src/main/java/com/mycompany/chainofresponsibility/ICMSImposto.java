package com.mycompany.chainofresponsibility;

import com.mycompany.model.Imposto;
import com.mycompany.model.Pedido;


public class ICMSImposto extends AbstractImpostoHandler {
    

    @Override
    public void aplicarImposto(Pedido pedido) {
        Imposto impostoICMS = new Imposto("ICMS", 7, pedido.getValorTotal() * 0.07);
        pedido.addImposto(impostoICMS);
        
        if(nextHandler != null)
            nextHandler.aplicarImposto(pedido);
    }
    
}
