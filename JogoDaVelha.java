import java.util.Random;
import java.util.Scanner;

class JogoDaVelha
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        Jogador jogador1, jogador2;

        System.out.print("Escolha seu símbolo X ou O: ");
        char simbolo = sc.next().toUpperCase().charAt(0);

        char simbolo2 = (simbolo == 'X') ? 'O' : 'X';

        jogador1 = new Jogador(simbolo);   
        jogador2 = new Jogador(simbolo2);  
        
        Tabuleiro tabuleiro = new Tabuleiro();

        int linha, coluna;
        Random random = new Random();

        int partida = 1;

        while(!tabuleiro.acabouOJogo())
        {
            System.out.println("Partida " + partida);

            
            System.out.println("Jogador 1 (" + jogador1.getSimbolo() + ")");
            do {
                System.out.print("Linha (0-2): ");
                linha = sc.nextInt();
                System.out.print("Coluna (0-2): ");
                coluna = sc.nextInt();
            }    
            while (!tabuleiro.jogar(jogador1.getSimbolo(),linha,coluna));

            if (tabuleiro.acabouOJogo())
            {
                break;
            }

           
            System.out.println("Jogador 2 (" + jogador2.getSimbolo() + ")");
            do {
                linha = random.nextInt(0,3);
                coluna = random.nextInt(0,3);
            }    
            while(!tabuleiro.jogar(jogador2.getSimbolo(),linha,coluna));

            partida++;
        }

       
        if (tabuleiro.haUmVencedor()) {
            if (tabuleiro.getUltimoSimbolo() == jogador1.getSimbolo()) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Criado por Guilherme Oliveira Santos");
    }
}