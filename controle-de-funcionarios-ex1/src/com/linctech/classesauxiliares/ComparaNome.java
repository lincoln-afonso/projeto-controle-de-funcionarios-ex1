package com.linctech.classesauxiliares;

import java.util.Comparator;

import com.linctech.dominio.Funcionario;

public class ComparaNome implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario f1, Funcionario f2) {
        return f1.getNome().compareToIgnoreCase(f2.getNome());
    }

}