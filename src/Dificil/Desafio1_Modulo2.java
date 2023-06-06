package Dificil;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Desafio1_Modulo2 {
    public static final String ANSI_YELLOW = "\u001B[33m", ANSI_GREEN = "\u001B[32m", ANSI_RED = "\u001B[31m",
            ANSI_BLUE ="\u001B[34m", ANSI_BLACK = "\u001B[30m";


    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("Vamos jogar um jogo.\n" +
                "Nele você deve descobrir qual é o número que escolhi.\n" +
                "Escolha bem ou será penalizado." +
                "Vamos começar! \n");
        System.out.println("-----------------------------------------------------------------------------");
        int pontosTotal = 0;
        boolean jogarNovamente = true;
        Scanner scanner = new Scanner(System.in);

        while (jogarNovamente) {
            System.out.println("Digite o nível de dificuldade (Fácil, Médio, Difícil): ");
            String nivelDificuldade = scanner.nextLine().trim().toUpperCase();

            int pontosJogoAtual = jogar(nivelDificuldade);
            pontosTotal += pontosJogoAtual;

            System.out.print(ANSI_GREEN + "Quer jogar novamente? (SIM / NÃO): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            jogarNovamente = resposta.equals("SIM");

            System.out.println();
        }

        System.out.println(ANSI_BLUE + "Pontuação total: " + pontosTotal);
        System.out.println(ANSI_BLACK + "Obrigado por jogar!");
    }
    public static int jogar(String nivelDificuldade) {
        int quantidadeNumeros;
        int pontos = 0;

        switch (nivelDificuldade) {
            case "FÁCIL":
                quantidadeNumeros = 5;
                break;
            case "MÉDIO":
                quantidadeNumeros = 10;
                break;
            case "DIFÍCIL":
                quantidadeNumeros = 15;
                break;
            case "JOY":
                quantidadeNumeros = 100;
            default:
                System.out.println("Nível de dificuldade inválido. Definindo para NÍVEL JOY. (POR QUE SIM!)");
                quantidadeNumeros = 100;
        }

        int[] numerosGerados = gerarNumerosAleatorios(quantidadeNumeros);

        System.out.println("Gerando quantidade de números aleatórios: " + quantidadeNumeros);
        //exibirNumerosGerados(numerosGerados);

        Scanner scanner = new Scanner(System.in);
        int[] numerosDigitados = new int[quantidadeNumeros];

        for (int i = 0; i < quantidadeNumeros; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            int numeroDigitado = scanner.nextInt();
            numerosDigitados[i] = numeroDigitado;

            if (numeroDigitado == numerosGerados[i]) {
                System.out.println("Parabéns, você acertou e ganhou 10 pontos!");
                pontos += 10;
            } else if (numeroDigitado == numerosGerados[i] - 1 || numeroDigitado == numerosGerados[i] + 1) {
                System.out.println("Você está próximo! Ganhou 5 ponto.");
                pontos += 5;
            } else {
                System.out.println("Você errou. O número escolhido pela AI era: " + numerosGerados[i]);
            }
        }

        System.out.println(ANSI_YELLOW + "Pontuação do jogo atual: " + pontos);

        System.out.println(ANSI_GREEN + "Números que você acertou: " + Arrays.toString(numerosDigitados));
        System.out.println(ANSI_RED + "Números que você errou: " + obterNumerosErrados(numerosDigitados, numerosGerados));

        return pontos;
    }

    public static int[] gerarNumerosAleatorios(int quantidadeNumeros) {
        Random random = new Random();
        int[] numeros = new int[quantidadeNumeros];

        for (int i = 0; i < quantidadeNumeros; i++) {
            numeros[i] = random.nextInt(quantidadeNumeros) + 1;
        }

        return numeros;
    }

    public static String obterNumerosErrados(int[] numerosDigitados, int[] numerosGerados) {
        StringBuilder numerosErrados = new StringBuilder();

        for (int i = 0; i < numerosDigitados.length; i++) {
            if (numerosDigitados[i] != numerosGerados[i]) {
                numerosErrados.append(numerosDigitados[i]).append(" ");
            }
        }

        return numerosErrados.toString().trim();
    }

    public static void exibirNumerosGerados(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Número gerado " + (i + 1) + ": " + numeros[i]);
        }
    }
}


