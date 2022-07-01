package com.mycompany.chainofresponsibility;


public abstract class AbstractDescontoHandler implements IMetodoDescontoHandler {
    
    protected IMetodoDescontoHandler nextHandler;
    
    @Override
    public void setNextHandler(IMetodoDescontoHandler nextHandler){
        if(this.nextHandler == null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }    
    
}
