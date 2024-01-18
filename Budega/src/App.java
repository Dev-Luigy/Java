import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

class Pessoa {
    private String nome;
    Pessoa (String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}

class Mercantil{
    private int qntCaixas;
    private ArrayList<Pessoa> atendente = new ArrayList<Pessoa>();
    private Queue <Pessoa> fila = new LinkedList<>();

    Mercantil(int qntCaixas){
        this.qntCaixas = qntCaixas;
        int i = 0;
        while (i++ < qntCaixas){
            atendente.add(new Pessoa("-----"));
        }
    }

    public void chegar(Pessoa p){
        fila.add(p);
    }

    public void chamarNoCaixa(int index){
        if (fila.size() == 0){
            System.out.println("fail: fila vazia");
            return;
        }
        if (index > fila.size()) return;
        atendente.set(index, fila.element());
        fila.remove();
        return;
    }

    public void finalizarAtendimento(int index){
        atendente.set(index, new Pessoa("-----"));
    }

    @Override
    public String toString() {
        String exit = "";
        int count = 0;
        for (Pessoa i : atendente){
            exit += "|"+ (count++) + ":" + i;
        }
        exit += "|\n";
        exit += "Espera: " + (fila == null ? "[]" : fila);
        return exit;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Mercantil mercantil = new Mercantil(0);

        while (true){
            String line = scanner.nextLine();
            String [] ui = line.split(" ");
            
            System.out.println("$" + line);

            switch(ui[0]){
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
