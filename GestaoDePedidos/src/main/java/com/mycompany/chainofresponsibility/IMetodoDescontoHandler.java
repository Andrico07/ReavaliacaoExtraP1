package com.mycompany.chainofresponsibility;

import com.mycompany.model.Pedido;


public interface IMetodoDescontoHandler {
    
    public void aplicarDesconto(Pedido pedido);
    
    public void setNextHandler(IMetodoDescontoHandler handler);
    
}
