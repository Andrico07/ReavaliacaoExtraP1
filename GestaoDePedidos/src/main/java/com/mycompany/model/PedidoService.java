package com.mycompany.model;

import com.mycompany.chainofresponsibility.IMetodoDescontoHandler;
import com.mycompany.chainofresponsibility.CategoriaProdutoDesconto;
import com.mycompany.chainofresponsibility.IncentivoDesconto;
import com.mycompany.chainofresponsibility.IntervaloDataDesconto;
import com.mycompany.chainofresponsibility.IImpostoHandler;
import com.mycompany.chainofresponsibility.ISSImposto;
import com.mycompany.chainofresponsibility.ICMSImposto;


public class PedidoService {
    
    private IMetodoDescontoHandler metodoDesconto;
    private IImpostoHandler impostos;
    private double valorDesconto, valorImposto;
    
    
    public PedidoService() {
        
        metodoDesconto = new CategoriaProdutoDesconto();
        metodoDesconto.setNextHandler(new IncentivoDesconto());
        metodoDesconto.setNextHandler(new IntervaloDataDesconto());
        
        impostos = new ISSImposto();
        impostos.setNextHandler(new ICMSImposto());
        
    }
    
    
    public void processarPedido(Pedido pedido) {
        
        metodoDesconto.aplicarDesconto(pedido);
        for(Desconto desconto: pedido.getDescontosConcedidos()){
            valorDesconto += desconto.getValor();
        }
        pedido.setValorDesconto(valorDesconto);
        
        impostos.aplicarImposto(pedido);
        for(Imposto imposto : pedido.getImpostos()){
            valorImposto += imposto.getValor();
        }
        pedido.setValorImposto(valorImposto);
        
        pedido.setValorFinal(pedido.getValorTotal() + valorImposto - valorDesconto);
        
    }
    
}
