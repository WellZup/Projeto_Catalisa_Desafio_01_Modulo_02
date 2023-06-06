package Medio;

import java.util.Random;
import java.util.Scanner;

public class Desafio1_Modulo2 {
            public static void main(String[] args) {
                System.out.println("-----------------------------------------------------------------------------");
                System.out.printf("Vamos jogar um jogo.\n" +
                        "Nele você deve descobrir qual é o número que escolhi.\n" +
                        "Escolha bem ou será penalizado." +
                        "Vamos começar! \n");
                System.out.println("-----------------------------------------------------------------------------");

            int pontosTotal = 0;
            boolean jogarNovamente = true;

               while (jogarNovamente) {

                int pontosJogoAtual = jogar();
                pontosTotal += pontosJogoAtual;
                Scanner scanner = new Scanner(System.in);
                System.out.print("Quer ir mais uma vez? (SIM / NÃO): ");

                String resposta = scanner.nextLine().trim().toUpperCase();

                if (!resposta.equals("SIM")) {
                    jogarNovamente = false;
                }
            }

            System.out.println("Pontuação total: " + pontosTotal);
            System.out.println("Obrigado por jogar!");
        }


            public static int jogar() {
            Random random = new Random();
            int quantidadeNumeros = 10;
            int pontos = 0;

            int[] numerosGerados = new int[quantidadeNumeros];

            System.out.println("Gerando números aleatórios de 1 a 100:");
            for (int i = 0; i < quantidadeNumeros; i++) {
                int numeroGerado = random.nextInt(100) + 1;

                numerosGerados[i] = numeroGerado;

            }

            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < quantidadeNumeros; i++) {
                System.out.println("Digite o número " + (i + 1) + ": ");
                int numeroDigitado = scanner.nextInt();

                if (numeroDigitado == numerosGerados[i]) {
                    System.out.println("Parabéns, você acertou e ganhou 10 pontos!");
                    pontos += 10;
                } else if (numeroDigitado == numerosGerados[i] - 1 || numeroDigitado == numerosGerados[i] + 1) {
                    System.out.println("Você está próximo! Ganhou 5 ponto.");
                    pontos += 5;
                } else {
                    System.out.println("Você errou. O número gerado pela A.I era: " + numerosGerados[i]);
                }
            }

            System.out.println("Pontuação do jogo atual: " + pontos);
            System.out.println();

            return pontos;
        }
}

