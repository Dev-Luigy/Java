import java.util.Scanner;
import java.util.Locale;

class Jogo {

    private int numJogadores;
    private int[] armadilha;
    private int[] posicao;
    private boolean[] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox = 0;
    private boolean fimDoJogo = false;

    public Jogo(int numJogadores, int numCasas) {
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;

        armadilha = new int[numCasas + 12];
        posicao = new int[2];
        podeJogar = new boolean[2];

        podeJogar[0] = true;
        podeJogar[1] = true;
    }

    public void addArmadilha(int t) {
        armadilha[t] = 1;
    }

    public void addMove(int d1, int d2) {
        if (fimDoJogo) {
            System.out.println("O jogo acabou");
            return;
        }

        if (podeJogar[prox]) {
            posicao[prox] += d1 + d2;
            podeJogar[prox] = armadilha[posicao[prox]] == 1 ? false : true;
            System.out.println("O jogador " + (prox + 1) + " vai para a casa " + posicao[prox]);
            if (posicao[prox] > numCasas) {
                System.out.println("O jogador " + (prox + 1) + " venceu o jogo");
                fimDoJogo = true;
                return;
            }
            if (!podeJogar[prox])
                System.out.println("O jogador " + (prox + 1) + " caiu em um armadilha");
            prox = (prox + 1) % 2;
            return;
        } else {
            System.out.println("O jogador " + (prox + 1) + " passa a vez");
            podeJogar[prox] = true;
        }
        prox = (prox + 1) % 2;
        addMove(d1, d2);
    }

    public String toString() {
        int i = 0;
        do {
            System.out.println("PosJogador[" + (i + 1) + "] = " + posicao[i]);
        } while (++i < numJogadores);
        return "";
    }

}

class App {
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