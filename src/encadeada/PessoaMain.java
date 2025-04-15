package encadeada;

import java.util.Scanner;

public class PessoaMain {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa primeiro = null; // Primeiro elemento da cadeia
        Pessoa ultimo = null;   // Último elemento adicionado na cadeia
        String opcao;

        // O loop permite cadastrar quantas pessoas o usuário desejar
        do {
            System.out.println("Digite o nome da pessoa:");
            String nome = scanner.nextLine();
            System.out.println("Digite a idade:");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o email:");
            String email = scanner.nextLine();

            // Cria uma nova pessoa utilizando encadeamento
            Pessoa novaPessoa = new Pessoa()
                                    .setNome(nome)
                                    .setIdade(idade)
                                    .setEmail(email);

            // Se for a primeira pessoa, define o início da cadeia
            if (primeiro == null) {
                primeiro = novaPessoa;
                ultimo = novaPessoa;
            } else {
                // Encadeia a nova pessoa à última pessoa adicionada
                ultimo.setProximo(novaPessoa);
                ultimo = novaPessoa;
            }

            System.out.println("Deseja adicionar outra pessoa? (s/n)");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("s"));

        // Exibe o encadeamento de pessoas
        System.out.println("\nEncadeamento de pessoas:");
        //Construir Encadeamento de Pessoa

        scanner.close();
    }
}
