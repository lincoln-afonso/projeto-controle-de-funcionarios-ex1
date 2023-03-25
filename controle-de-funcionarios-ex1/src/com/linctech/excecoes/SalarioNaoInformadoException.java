package com.linctech.excecoes;

public class SalarioNaoInformadoException extends Exception{
    private static final long serialVersionUID = 1L;

    public SalarioNaoInformadoException() {
        super("Salario não informado!");
    }

    public SalarioNaoInformadoException(String str) {
        super(str);
    }
}