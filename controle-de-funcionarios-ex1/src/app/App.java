package app;

import java.util.Scanner;

public class App {
    private static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
       // Set<Funcionario> funcionarios = new TreeSet<>();
        String salario;
        String nome;
        String matricula;
        String opcao = "";

        do {
            System.out.print("Informe o número da opção correspondente: ");
            opcao = App.leia.nextLine().toLowerCase();

            switch (opcao) {
                case "1":

                    break;
                
                case "2":

                    break;
                
                case "3":

                    break;
                
                case "4":
                    System.out.println("Programa encerrado!");
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;
            }
        } while (!opcao.equals("4"));
    
    }
}