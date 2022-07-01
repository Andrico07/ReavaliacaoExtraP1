package com.mycompany.model;


public class Desconto {
    
    private String tipo;
    private double porcentagem;
    private double valor;

    public Desconto(String tipo, double porcentagem, double valor) {
        this.tipo = tipo;
        this.porcentagem = porcentagem;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
