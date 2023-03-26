package com.linctech.dominio;

import com.linctech.excecoes.MatriculaNaoInformadaException;
import com.linctech.excecoes.NomeNaoInformadoException;
import com.linctech.excecoes.SalarioNaoInformadoException;

public class Funcionario {
    private String matricula;
    private String nome;
    private double salario;

    public Funcionario() {
    }
    
    public Funcionario(String matricula, String nome, String valorSalario) throws Exception {
      this.setMatricula(matricula);
      this.setNome(nome);
      this.setSalario(valorSalario);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) throws MatriculaNaoInformadaException {
        if (matricula.isEmpty())
            throw new MatriculaNaoInformadaException();
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeNaoInformadoException {
        if (nome.isEmpty())
            throw new NomeNaoInformadoException();
        this.nome = nome.toUpperCase();
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(String valorSalario) throws SalarioNaoInformadoException {
        double salario;

        if (valorSalario.isEmpty())
            throw new SalarioNaoInformadoException("Salário não informado!");
        salario = Double.parseDouble(valorSalario);
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", salario=" + salario + "]\n";
    } 
}