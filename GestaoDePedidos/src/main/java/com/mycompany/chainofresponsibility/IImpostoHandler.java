package com.mycompany.chainofresponsibility;

import com.mycompany.model.Pedido;


public interface IImpostoHandler {
    
    public void aplicarImposto(Pedido pedido);
    
    public void setNextHandler(IImpostoHandler handler);
    
}
