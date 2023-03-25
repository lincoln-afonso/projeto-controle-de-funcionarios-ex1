package com.linctech.dominio;

public class Funcionario {
    private String matricula;
    private String nome;
    private double salario;

    public Funcionario() {
    }
    
    public Funcionario(String matricula, String nome, Double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula.isEmpty())
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(String valorSalario) throws Exception {
        double salario;

        if (valorSalario.isEmpty())
            throw new Exception("Salário não informado!");
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
        return "Funcionario [matricula=" + matricula + ", nome=" + nome + ", salario=" + salario + "]";
    }

    

    
}