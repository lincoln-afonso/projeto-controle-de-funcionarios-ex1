package com.linctech.excecoes;

public class MatriculaNaoInformadaException extends Exception {

    private static final long serialVersionUID = 1L;

    public MatriculaNaoInformadaException() {
        super("Matricula não informada!");
    }

    public MatriculaNaoInformadaException(String str) {
        super(str);
    }
}