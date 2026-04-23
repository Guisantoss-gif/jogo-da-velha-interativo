import java.util.Random;
import java.util.Scanner;

class JogoDaVelha {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    private void iniciar() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int linha, coluna;
        
        int partida = 1;

        while (!this.tabuleiro.acabouOJogo()) {
            System.out.println("Partida " + partida);

            System.out.println("Jogador 1 (" + this.jogador1.getSimbolo() + ")");
            do {
                System.out.print("Linha (0-2): ");
                linha = sc.nextInt();
                System.out.print("Coluna (0-2): ");
                coluna = sc.nextInt();
            } while (!this.tabuleiro.jogar(this.jogador1.getSimbolo(), linha, coluna));

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            System.out.println("Jogador 2 (" + this.jogador2.getSimbolo() + ")");
            do {
                linha = random.nextInt(0, 3);
                coluna = random.nextInt(0, 3);
            } while (!this.tabuleiro.jogar(this.jogador2.getSimbolo(), linha, coluna));

            partida++;
        }

        if (this.tabuleiro.haUmVencedor()) {
            if (this.tabuleiro.getUltimoSimbolo() == this.jogador1.getSimbolo()) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Criado por Guilherme Oliveira Santos");
    };

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Jogador jogador1, jogador2;

        System.out.print("Escolha seu símbolo X ou O: ");
        char simbolo = sc.next().toUpperCase().charAt(0);

        char simbolo2 = (simbolo == 'X') ? 'O' : 'X';

        jogador1 = new Jogador(simbolo);
        jogador2 = new Jogador(simbolo2);

        Tabuleiro tabuleiro = new Tabuleiro();
        JogoDaVelha jogo = new JogoDaVelha(jogador1, jogador2, tabuleiro);
        jogo.iniciar();

    }
}
