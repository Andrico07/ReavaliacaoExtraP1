package com.mycompany.chainofresponsibility;

import com.mycompany.model.Imposto;
import com.mycompany.model.Pedido;


public class ISSImposto extends AbstractImpostoHandler {
    

    @Override
    public void aplicarImposto(Pedido pedido) {
        Imposto impostoISS = new Imposto("ISS", 2, pedido.getValorTotal() * 0.02);
        pedido.addImposto(impostoISS);
        
        if(nextHandler != null)
            nextHandler.aplicarImposto(pedido);
    }
    
}
