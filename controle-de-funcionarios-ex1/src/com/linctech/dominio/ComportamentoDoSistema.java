package com.linctech.dominio;

import java.util.Set;

public interface ComportamentoDoSistema {
    public abstract void cadastrarFuncionario(Set<Funcionario> funcionarios);

    public abstract void consultarFuncionario(Set<Funcionario> funcionarios);
    
    public abstract void excluirFuncionario(Set<Funcionario> funcionarios);

    public abstract void listarFuncionarios(Set<Funcionario> funcionarios);
}