package Medio;

import java.util.Random;
import java.util.Scanner;

public class Desafio1_Modulo2 {
            public static void main(String[] args) {
                System.out.println("Vamos jogar um jogo.\n" +
                        "Nele você deve descobrir qual é o número que escolhi.\n" +
                        "Escolha bem ou será penalizado.\n" +
                        "Deixarei o jogo de forma mediana, escolherei números de 1 à 100.\n" +
                        "Vamos começar! \n");

            int pontosTotal = 0;
            boolean jogarNovamente = true;

            //Lógica para rodar o método de jogar novamente
            while (jogarNovamente) {

                int pontosJogoAtual = jogar(); //Método encapsulado para melhor manutenção

                pontosTotal += pontosJogoAtual;//Variável que armazena um valor numérico dos pontos totais acumulados
                //pontosTotal = pontosTotal + pontosJogoAtual; //Mesmo código mas de forma diferente

                Scanner scanner = new Scanner(System.in);
                System.out.print("Quer ir mais uma vez? (SIM / NÃO): ");

                String resposta = scanner.nextLine().trim().toUpperCase();
                //O método trim() remove os espaços em branco no início e no final de uma string.
                //O método toUpperCase() converte todos os caracteres de uma string para letras maiúsculas.

                if (!resposta.equals("SIM")) { //Verifica se a variável resposta não é igual a "SIM".
                    jogarNovamente = false;
                }
            }

            System.out.println("Pontuação total: " + pontosTotal);
            System.out.println("Obrigado por jogar!");
        }

            //Lógica criada para gerar o jogo, facilitando a manutenção do mesmo
            public static int jogar() {
            Random random = new Random(); //Cria de forma randômica a quantidade de números decididos logo abaixo.
            int quantidadeNumeros = 10;
            int pontos = 0;

            int[] numerosGerados = new int[quantidadeNumeros];

            System.out.println("Gerando números aleatórios de 1 a 100:");
            for (int i = 0; i < quantidadeNumeros; i++) {
                int numeroGerado = random.nextInt(100) + 1;
                // Ao adicionar + 1 ao resultado gerado, está ajustando o
                // intervalo para ser de 1 (inclusivo) a 100 (inclusivo).

                numerosGerados[i] = numeroGerado;
                //System.out.println("Número gerado " + (i + 1) + ": " + numeroGerado);
                // Verificar se o programa está rodando aleatoriamente
            }

            //Lógica para pegar os números do usuário
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < quantidadeNumeros; i++) {
                System.out.println("Digite o número " + (i + 1) + ": ");
                int numeroDigitado = scanner.nextInt();

                if (numeroDigitado == numerosGerados[i]) {
                    System.out.println("Parabéns, você acertou e ganhou 10 pontos!");
                    pontos += 10;
                } else if (numeroDigitado == numerosGerados[i] - 1 || numeroDigitado == numerosGerados[i] + 1) {
                    //Condição que verifica se o número digitado é uma unidade (maior ou menor) do número gerado.
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

