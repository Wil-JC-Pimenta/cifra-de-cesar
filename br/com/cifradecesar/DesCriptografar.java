package br.com.cifradecesar;

import java.util.Scanner;

public class DesCriptografar {
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String descriptografar(String textoCifrado, int chave) {
        textoCifrado = textoCifrado.toUpperCase();
        StringBuilder textoOriginal = new StringBuilder();

        for (int i = 0; i < textoCifrado.length(); i++) {
            char caractereCifrado = textoCifrado.charAt(i);
            int posCaractereCifradoAlfabeto = ALFABETO.indexOf(caractereCifrado);

            if (posCaractereCifradoAlfabeto == -1) {
                textoOriginal.append(caractereCifrado);
                continue;
            }

            int posCaractereOriginal = (posCaractereCifradoAlfabeto - chave + 26) % 26;
            char caractereOriginal = ALFABETO.charAt(posCaractereOriginal);
            textoOriginal.append(caractereOriginal);
        }

        return textoOriginal.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Entre com o texto cifrado: ");
        String textoCifrado = in.nextLine();
        System.out.print("Entre com a chave para descriptografar: ");
        int chave = in.nextInt();
        String textoOriginal = descriptografar(textoCifrado, chave);
        System.out.println("Texto original: " + textoOriginal);
    }
}
