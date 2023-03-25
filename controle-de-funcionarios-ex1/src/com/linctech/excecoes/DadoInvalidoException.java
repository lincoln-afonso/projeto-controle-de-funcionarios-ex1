package com.linctech.excecoes;

public class DadoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public DadoInvalidoException() {
        super("O dado solicitado não foi informado!");
    }

    public DadoInvalidoException(String str) {
        super(str);
    }
}