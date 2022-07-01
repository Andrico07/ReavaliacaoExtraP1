package com.mycompany.chainofresponsibility;

import com.mycompany.model.Desconto;
import com.mycompany.model.Pedido;
import java.time.LocalDate;

public class IntervaloDataDesconto extends AbstractDescontoHandler{
    
    private LocalDate data1, data2;
    
    public IntervaloDataDesconto() {
        data1 = LocalDate.parse("2022-12-20");
        data2 = LocalDate.parse("2022-12-26");
        
    }

    @Override
    public void aplicarDesconto(Pedido pedido) {
        if(pedido.getData().isAfter(data1) && pedido.getData().isBefore(data2)){
            Desconto descontoData = new Desconto("Promoção de Natal", 3, pedido.getValorTotal() * 0.03);
            pedido.addDesconto(descontoData);
            
        }
        
        if(nextHandler != null)
            nextHandler.aplicarDesconto(pedido);
        
    }
    
}
