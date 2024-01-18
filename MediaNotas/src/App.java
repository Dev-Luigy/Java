import java.util.Scanner;
import java.util.ArrayList;

class MediaNota {
    private ArrayList<Double> notas = new ArrayList<Double>();
    private double notas_maior = 0.00;
    private double notas_menor = 10.00;
    private boolean podeParametrizar = true;

    public void addNota(double nota) {
        notas.add(nota > 10.0 ? 10.0 : nota);
        notas_maior = notas_maior > nota ? notas_maior : nota;
        notas_menor = notas_menor < nota ? notas_menor : nota;
    }

    public void removeNota(int index) {
        if (index > notas.size() - 1) {
            System.out.println("falha: indice invalido");
            return;
        }
        notas.remove(index);
    }

    public double maiorNota() {
        if (notas.isEmpty()) {
            System.out.println("falha: quantidade de notas insuficiente");
        } else {
            return notas_maior;
        }
        return 0; // nunca deve chegar nesse caso.
    }

    public double menorNota() {
        if (notas.isEmpty()) {
            System.out.println("falha: quantidade de notas insuficiente");
        } else {
            return notas_menor;
        }
        return 0; // nunca deve chegar nesse caso.
    }

    public double media() {
        double media = 0.0;
        for (Double i : notas) {
            media += i;
        }
        return media / notas.size();
    }

    public void parametriza() {
        int y = 0;
        if (!podeParametrizar)
            return;
        for (Double i : notas) {
            i /= notas_maior;
            i *= 10;
            if (i >= 10)
                podeParametrizar = false;
            notas.set(y++, i > 10 ? 10 : i);
        }
    }

    public String toString() {
        if (!notas.isEmpty()) {
            int y = 0;
            System.out.print("[");
            for (Double i : notas) {
                System.out.printf("%.2f", i);
                if (++y != notas.size())
                    System.out.print(", ");
            }
            System.out.print("]");
            return "";
        } else
            return "[" + "]";
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        // vars;
        Scanner scanner = new Scanner(System.in);
        MediaNota a = new MediaNota();

        while (true) {
            // system in.
            String line = scanner.nextLine();
            String[] in = line.split(" ");

            System.out.print("$" + in[0]);

            // data Analysis
            switch (in[0]) {
                case "end":
                    System.out.println("");
                    scanner.close();
                    System.exit(0);
                case "addNota":
                    System.out.println(" " + in[1]);
                    a.addNota(Double.parseDouble(in[1]));
                    break;
                case "removeNota":
                    System.out.println("");
                    a.removeNota(Integer.parseInt(in[1]));
                    break;
                case "maiorNota":
                    System.out.println("");
                    System.out.println(a.maiorNota());
                    break;
                case "menorNota":
                    System.out.println("");
                    System.out.println(a.menorNota());
                    break;
                case "media":
                    System.out.println("");
                    System.out.printf("%.2f\n", a.media());
                    break;
                case "parametriza":
                    System.out.println("");
                    a.parametriza();
                    break;
                case "show":
                    System.out.println("");
                    System.out.println(a);
                    break;
                default:
                    System.out.println("");
                    System.out.println("fail: comando invalido");
            }

        }
    }
}
