Main.java

  package biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        livros.add(new Livro("O Príncipe Cruel", "Holly Black", 2018));
        livros.add(new Livro("Me Chame Pelo Seu Nome", "André Aciman", 2007));
        
        usuarios.add(new Aluno("Kailany Sampaio", "123.456.789-00", "sampaio@email.com", "O Príncipe Cruel"));
        usuarios.add(new Funcionario("Alisson Rocha", "987.654.321-11", "taehyung@email.com", "Bibliotecário"));

        int opcao = -1;

        while (opcao != 7) {
            System.out.println("\n===== SISTEMA DA BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Cadastrar Usuário");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Realizar Empréstimo");
            System.out.println("6 - Devolver Livro");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Título do livro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor do livro: ");
                        String autor = scanner.nextLine();
                        System.out.print("Ano de publicação: ");
                        int ano = scanner.nextInt();
                        scanner.nextLine();

                        livros.add(new Livro(titulo, autor, ano));
                        System.out.println("Seu livvro foi cadastrado!");
                        break;

                    case 2:
                        System.out.println("\n--- Lista de Livros ---");
                        if (livros.isEmpty()) {
                            System.out.println("Nenhum livro cadastrado.");
                        } else {
                            for (int i = 0; i < livros.size(); i++) {
                                System.out.println("[" + i + "] " + livros.get(i));
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Tipo de usuário: 1 - Aluno | 2 - Funcionário");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("E-mail: ");
                        String email = scanner.nextLine();

                        if (tipo == 1) {
                            System.out.print("Curso: ");
                            String curso = scanner.nextLine();
                            System.out.print("Turma: ");
                            String turma = scanner.nextLine();
                            usuarios.add(new Aluno(nome, cpf, email, curso, turma));
                            System.out.println("Aluno cadastrado!");
                        } else if (tipo == 2) {
                            System.out.print("Cargo: ");
                            String cargo = scanner.nextLine();
                            usuarios.add(new Funcionario(nome, cpf, email, cargo));
                            System.out.println("Funcionário cadastrado!");
                        } else {
                            System.out.println("Inválido.");
                        }
                        break;

                    case 4:
                        System.out.println("\n--- Lista de Usuários ---");
                        if (usuarios.isEmpty()) {
                            System.out.println("Nenhum usuário cadastrado.");
                        } else {
                            for (Usuario u : usuarios) {
                                u.listarInformacoes();
                            }
                        }
                        break;

                    case 5:
                        System.out.println("\n--- Realizar Empréstimo ---");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println("[" + i + "] " + livros.get(i));
                        }
                        System.out.print("Digite o código do livro que deseja pegar emprestrado: ");
                        int idxEmprestimo = scanner.nextInt();

                        if (idxEmprestimo >= 0 && idxEmprestimo < livros.size()) {
                            Livro l = livros.get(idxEmprestimo);
                            if (!l.isDisponivel()) {
                                System.out.println("Erro: Este livro já está emprestado!");
                            } else {
                                l.emprestar();
                                System.out.println("Empréstimo realizado!");
                            }
                        } else {
                            System.out.println("Código do livro inválido.");
                        }
                        break;

                    case 6:
                        System.out.println("\n--- Devolver Livro ---");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println("[" + i + "] " + livros.get(i));
                        }
                        System.out.print("Digite o código do livro que deseja devolver: ");
                        int idxDevolucao = scanner.nextInt();

                        if (idxDevolucao >= 0 && idxDevolucao < livros.size()) {
                            Livro l = livros.get(idxDevolucao);
                            if (l.isDisponivel()) {
                                System.out.println("Aviso: Este livro já está na biblioteca.");
                              
                            } else {
                                l.devolver();
                                System.out.println("Seu livro foi devolvido!");
                         }
                            } else {
                               System.out.println("Código do livro inválido.");
                         }
                    
                             break;

                    case 7:
                        System.out.println("Saindo do sistema");
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Insira números nos campos numéricos.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
