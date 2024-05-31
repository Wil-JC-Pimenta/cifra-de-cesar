package br.com.cifradecesar;

import java.util.Scanner;

public class Criptografar {
    private static final String ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String criptografar(String textoOriginal, int chave) {
        textoOriginal = textoOriginal.toUpperCase();
        StringBuilder textoCifrado = new StringBuilder();

        for (int i = 0; i < textoOriginal.length(); i++) {
            char caractereOriginal = textoOriginal.charAt(i);
            int posCaractereOriginalAlfabeto = ALFABETO.indexOf(caractereOriginal);

            if (posCaractereOriginalAlfabeto == -1) {
                textoCifrado.append(caractereOriginal);
                continue;
            }

            int posCaractereCifrado = (posCaractereOriginalAlfabeto + chave) % 26;
            char caractereCifrado = ALFABETO.charAt(posCaractereCifrado);
            textoCifrado.append(caractereCifrado);
        }

        return textoCifrado.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Entre com o texto para criptografar: ");
        String textoOriginal = in.nextLine();
        int chave = (int) (Math.random() * 25 + 1);
        String textoCifrado = criptografar(textoOriginal, chave);
        System.out.println("Texto criptografado: " + textoCifrado);
        System.out.println("Chave usada: " + chave);
    }
}
