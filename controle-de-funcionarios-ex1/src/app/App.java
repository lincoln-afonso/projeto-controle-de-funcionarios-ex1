package app;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import com.linctech.classesauxiliares.ComparaNome;
import com.linctech.classesauxiliares.Menu;
import com.linctech.dominio.ComportamentoDoSistema;
import com.linctech.dominio.Funcionario;
import com.linctech.excecoes.MatriculaNaoInformadaException;
import com.linctech.excecoes.NomeNaoInformadoException;
import com.linctech.excecoes.SalarioNaoInformadoException;

public class App implements ComportamentoDoSistema {
    private static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Set<Funcionario> funcionarios = new LinkedHashSet<>();
        String opcao = "";
        App app = new App();

        do {
            Menu.exibirOpcoes();
            System.out.print("Informe o número da opção correspondente: ");
            opcao = App.leia.nextLine().toLowerCase();

            switch (opcao) {
            case "1":
                app.cadastrarFuncionario(funcionarios);
                break;

            case "2":
                app.consultarFuncionario(funcionarios);
                break;

            case "3":
                app.excluirFuncionario(funcionarios);
                break;

            case "4":
                app.listarFuncionarios(funcionarios);
                break;
            case "5":
                System.out.println("Programa encerrado!");
                break;

            default:
                System.out.println("Opção inválida!\n");
                break;
            }
        } while (!opcao.equals("5"));
        App.leia.close();
    }

    @Override
    public void cadastrarFuncionario(Set<Funcionario> funcionarios) {
        String nome;
        String matricula;
        String salario;
        boolean eValido;
        Funcionario funcionario = new Funcionario();

        do {
            eValido = false;
            try {
                System.out.print("Matricula: ");
                matricula = App.leia.nextLine();
                funcionario.setMatricula(matricula);

                eValido = true;
            } catch (MatriculaNaoInformadaException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Nome: ");
                nome = App.leia.nextLine();

                funcionario.setNome(nome);
                eValido = true;
            } catch (NomeNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Salário: ");
                salario = App.leia.nextLine();

                funcionario.setSalario(salario);
                eValido = true;
            } catch (NumberFormatException e) {
                System.out.println("O salário deve ser um valor númerico!");
            } catch (SalarioNaoInformadoException e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);
        if (funcionarios.add(funcionario) == false) 
            System.out.println("O funcionario informado já se encontra cadastrado!");
        
    }

    public static void exibirFuncionario(Funcionario funcionario) {
        System.out.println("DADOS DO FUNCIONÁRIO");
        System.out.println("MATRÍCULA: " + funcionario.getMatricula());
        System.out.println("SALÁRIO \t NOME");
        System.out.println(funcionario.getSalario() + "\t\t" + funcionario.getNome() + "\n");
    }

    @Override
    public void consultarFuncionario(Set<Funcionario> funcionarios) {
        Funcionario funcionario = new Funcionario();
        String matricula;
        List<Funcionario> funcionariosList = new LinkedList<>();

        funcionariosList.addAll(funcionarios);

        if (funcionarios.size() > 0) {
            System.out.print("Informe a matrícula: ");
            try {
                matricula = App.leia.nextLine();
                funcionario.setMatricula(matricula);
                
                if (funcionariosList.contains(funcionario)) {
                    int posicao;

                    posicao = funcionariosList.indexOf(funcionario);
                    funcionario = funcionariosList.get(posicao);
                    App.exibirFuncionario(funcionario);
                }
                else
                    System.out.println("Funcionário não encontrado!\n");
            } catch(Exception e) {
                System.out.println("Matrícula não informada!");
            }
        }
        else
            System.out.println("Não há nenhum funcionário cadastrado no momento!\n");

    }

    @Override
    public void excluirFuncionario(Set<Funcionario> funcionarios) {
        Funcionario funcionario = new Funcionario();
        String matricula;;

        if (funcionarios.size() > 0) {
            try {
                System.out.print("Matrúcla do funcionário: ");
                matricula = App.leia.nextLine();
                funcionario.setMatricula(matricula);

                if(funcionarios.remove(funcionario)) {
                    System.out.println("Funcionário removido com êxito!");
                }
            } catch (MatriculaNaoInformadaException e) {
                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println("Não há funcionários cadastrados ainda!");
    }

    @Override
    public void listarFuncionarios(Set<Funcionario> funcionarios) {
        Set<Funcionario> funcionariosTreeSet = new TreeSet<>(new ComparaNome());
        Funcionario f;
        funcionariosTreeSet.addAll(funcionarios);
        
        if (funcionarios.size() > 0) {
            System.out.println("Lista de Funcionários");
            System.out.println("Nome \t\t Matricula \t Salário");
            Iterator<Funcionario> funcionario = funcionariosTreeSet.iterator();
            while (funcionario.hasNext()) {
                f = funcionario.next();
                System.out.print(f.getNome());
                System.out.print("\t\t " + f.getMatricula());
                System.out.println("\t\t " + f.getSalario());
            }
            System.out.println("\n");
        }
        else
            System.out.println("Não há funcionários cadastrados ainda!");
    }
}