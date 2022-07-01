package com.mycompany.chainofresponsibility;


public abstract class AbstractImpostoHandler implements IImpostoHandler {
    
    protected IImpostoHandler nextHandler;
    
    @Override
    public void setNextHandler(IImpostoHandler nextHandler){
        if(this.nextHandler == null)
            this.nextHandler = nextHandler;
        else
            this.nextHandler.setNextHandler(nextHandler);
    }    
    
}
