package Minimo;

import java.util.Random;
import java.util.Scanner;

public class Desafio1_Modulo2 {
    public static void main(String[] args) {



        Random random = new Random();
        int quantidadeNumeros = 5; // Altere o valor para gerar mais ou menos números
        int pontos = 0;

        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("Vamos jogar um jogo.\n" +
                "Nele você deve descobrir qual é o número que escolhi.\n" +
                "Escolha bem ou será penalizado." +
                "Deixarei o jogo fácil, escolherei números de 1 à 10.\n" +
                "Vamos começar! \n");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < quantidadeNumeros; i++) {
            int numeroGerado = random.nextInt(10) + 1;
            // Ao adicionar + 1 ao resultado gerado, está ajustando o
            // intervalo para ser de 1 (inclusivo) a 10 (inclusivo).
            // Isso ocorre porque ao adicionar 1, o menor número possível se torna 1, e o maior número possível se torna 10.
            //System.out.println("Número gerado: " + numeroGerado);
            //Confirmando se o codigo está ok

            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite um número: ");
            int numeroDigitado = entrada.nextInt();

            if (numeroDigitado == numeroGerado) {
                System.out.println("Parabéns, você acertou e ganhou 10 pontos!");
                pontos += 10;
            } else if (numeroDigitado == numeroGerado - 1 || numeroDigitado == numeroGerado + 1) {

                System.out.println("Você está próximo! Ganhou 5 ponto.");
                pontos += 5;
            } else {
                System.out.println("Você errou. Vejo que não tem tanta sorte. ");
            }
            System.out.println("Número que escolhi: " + numeroGerado);
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("-----------------*** Pontuação final: " + pontos +" ***------------------");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("-------------------- Obrigado por jogar! --------------------");


    }
}
