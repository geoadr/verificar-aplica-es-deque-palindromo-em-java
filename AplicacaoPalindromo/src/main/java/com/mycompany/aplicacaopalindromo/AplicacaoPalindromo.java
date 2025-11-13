/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.aplicacaopalindromo;
/**
 *
 * @author GeoDantas
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AplicacaoPalindromo {
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            mostrarMenu();
            System.out.print(AZUL + "escolha uma opcao: " + RESET);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    verificarPalindromoMenu(entrada);
                    break;

                case 2:
                    System.out.println(AMARELO + "fimmm" + RESET);
                    break;

                default:
                    System.out.println(VERMELHO + "opção invalida, faça mais uma vez" + RESET);
                    break;
            }

        } while (opcao != 2);

        entrada.close();
    }
    public static void mostrarMenu() {
        System.out.println("\n" + AZUL + "menu" + RESET);
        System.out.println("1 verificar se uma palavra é palindromo");
        System.out.println("2 sair");
    }
    public static void verificarPalindromoMenu(Scanner entrada) {
        System.out.print("digite aqui alguma palavra/frase: ");
        String texto = entrada.nextLine();
        String textoLimpo = limparTexto(texto);
      boolean palindromo = verificarPalindromo(textoLimpo);

        if (palindromo) {
            System.out.println(VERDE + "check \"" + texto + "\" é um palindromo!!!" + RESET);
        } else {
            System.out.println(VERMELHO + " nao check \"" + texto + "\" nao é um palindromo." + RESET);
        }
    }
    public static String limparTexto(String texto) {
        return texto.toLowerCase().replace(" ", "");
    }

    public static boolean verificarPalindromo(String texto) {

        Deque<Character> deque = new LinkedList<>();

        for (char letra : texto.toCharArray()) {
            deque.addLast(letra);
        }

        while (deque.size() > 1) {

            char primeira = deque.removeFirst();
            char ultima = deque.removeLast();

            if (primeira != ultima) {
                return false;
            }
        }
        return true;
    }

}
