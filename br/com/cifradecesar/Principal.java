package br.com.cifradecesar;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textoOriginal = "";
        String textoCifrado = "";
        int chave = 0;
        boolean textoInserido = false;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir texto para criptografar");
            System.out.println("2. Tentar descriptografar com uma chave");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Entre com o texto para criptografar: ");
                    textoOriginal = scanner.nextLine();
                    chave = (int) (Math.random() * 25 + 1);
                    textoCifrado = Criptografar.criptografar(textoOriginal, chave);
                    System.out.println("Texto criptografado: " + textoCifrado);
                    System.out.println("Chave usada: " + chave);
                    textoInserido = true;
                    break;
                case 2:
                    if (!textoInserido) {
                        System.out.println("Por favor, insira o texto para criptografar primeiro.");
                        break;
                    }
                    while (true) {
                        try {
                            System.out.print("Entre com a chave para descriptografar (1-26): ");
                            chave = scanner.nextInt();
                            scanner.nextLine();
                            if (chave < 1 || chave > 26) {
                                throw new IllegalArgumentException("A chave deve estar entre 1 e 26.");
                            }
                            System.out.println("Texto criptografado: " + textoCifrado);
                            String textoDescriptografado = DesCriptografar.descriptografar(textoCifrado, chave);
                            System.out.println("Texto original com chave " + chave + ": " + textoDescriptografado);

                            System.out.print("Está correto? (s/n): ");
                            char resposta = scanner.next().charAt(0);
                            if (resposta == 's' || resposta == 'S') {
                                System.out.println("Descriptografia concluída com sucesso!");
                                break;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
