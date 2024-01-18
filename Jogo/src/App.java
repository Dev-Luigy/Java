import java.util.Scanner;
import java.util.Locale;

class Jogo {

    private int numJogadores;
    private int numCasas;
    private int[] armadilha;
    private int[] posicao;
    private boolean[] podeJogar;
    private int prox;
    private boolean fimDoJogo = false;

    public Jogo(int numJogadores, int numCasas) {
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;

        armadilha = new int[numCasas + 5];
        posicao = new int[numJogadores];
        podeJogar = new boolean[numJogadores];

        for (int i = 0; i < numJogadores; i++) {
            podeJogar[i] = true;
        }
    }

    public void addArmadilha(int t) {
        armadilha[t] = 1;
    }

    public void addMove(int d1, int d2) {
        int i = 0;
        if (fimDoJogo) {
            System.out.println("O jogo acabou");
            return;
        }
        do {
            if (podeJogar[prox++ % numJogadores]) {
                posicao[(prox - 1) % numJogadores] += d1 + d2;
                System.out.println("O jogador " + (((prox - 1) % numJogadores) + 1) + " vai para a casa "
                        + posicao[(prox - 1) % numJogadores]);
            } else {
                System.out.println("O jogador " + (((prox - 1) % numJogadores) + 1) + " passa a vez");
                podeJogar[(prox - 1) % numJogadores] = true;
                continue;
            }

            if (armadilha[posicao[(prox - 1) % numJogadores]] == 1) {
                podeJogar[prox - 1] = false;
                System.out.println("O jogador " + (((prox - 1) % numJogadores) + 1) + " caiu em um armadilha");
                break;
            } else {
                if (posicao[(prox - 1) % numJogadores] > numCasas) {
                    System.out.println("O jogador " + (((prox - 1) % numJogadores) + 1) + " venceu o jogo");
                    fimDoJogo = true;
                }
                break;
            }
        } while (++i < numJogadores);
    }

    public String toString() {
        int i = 0;
        do {
            System.out.println("PosJogador[" + (i + 1) + "] = " + posicao[i]);
        } while (++i < numJogadores);
        return "";
    }

}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Jogo jogo = new Jogo(0, 0);

        while (true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("init")) {
                jogo = new Jogo(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("addArmadilha")) {
                jogo.addArmadilha(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("addMove")) {
                int d1 = Integer.parseInt(ui[1]);
                int d2 = Integer.parseInt(ui[2]);
                jogo.addMove(d1, d2);
            } else if (ui[0].equals("show")) {
                System.out.println(jogo);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}