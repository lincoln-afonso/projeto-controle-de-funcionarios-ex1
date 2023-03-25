package com.linctech.excecoes;

public class NomeNaoInformadoException extends Exception {
    private static final long serialVersionUID = 1L;

    public NomeNaoInformadoException() {
        super("Nome não informado!");
    }

    public NomeNaoInformadoException(String str) {
        super(str);
    }
}