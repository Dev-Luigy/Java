import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Pessoa {
    private String nome;

    Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nome;
    }
}

// caixas = arraylist;
// fila = linkedlist;

class Mercantil {
    private ArrayList<Pessoa> caixas = new ArrayList<Pessoa>();
    private LinkedList<Pessoa> fila = new LinkedList<Pessoa>();
    private int qntCaixas;

    private Pessoa busy = new Pessoa("-----");

    Mercantil(int qntCaixas) {
        this.qntCaixas = qntCaixas;
        int i = 0;
        while (i++ < qntCaixas) {
            caixas.add(busy);
        }
    }

    public void chegar(Pessoa p) {
        fila.add(p);
    }

    public void chamarNoCaixa(int index) {
        if (fila.size() != 0) {
            if (caixas.get(index) == busy) {
                caixas.set(index, fila.getFirst());
                fila.removeFirst();
                return;
            }
        }
        System.out.println("fail: fila vazia");
    }

    public void finalizarAtendimento(int index) {
        caixas.set(index, busy);
    }

    @Override
    public String toString() {
        int i = 0;
        String exit = "";
        while (i < qntCaixas) {
            exit += "|" + i + ":" + caixas.get(i++);
        }
        exit += "|\nEspera: " + fila;
        return exit;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Mercantil mercantil = new Mercantil(0);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            System.out.println("$" + line);

            switch (ui[0]) {
                case "init":
                    mercantil = new Mercantil(Integer.parseInt(ui[1]));
                    break;
                case "call":
                    mercantil.chamarNoCaixa(Integer.parseInt(ui[1]));
                    break;
                case "finish":
                    mercantil.finalizarAtendimento(Integer.parseInt(ui[1]));
                    break;
                case "arrive":
                    mercantil.chegar(new Pessoa(ui[1]));
                    break;
                case "show":
                    System.out.println(mercantil);
                    break;
                case "end":
                    System.exit(0);
                default:
                    System.out.println("Comando inexistente.");
            }
        }
    }
}