import java.util.Vector;
import java.util.Collections;
import java.util.Scanner;

class Fila {
    private Vector<Integer> fila = new Vector<Integer>();
    private boolean hasMan = false;

    Fila(Vector<Integer> fila) {
        this.fila = fila;
    }

    public boolean in(int numproc) {
        return fila.contains(numproc);
    }

    public int index_of(int numproc) {
        return fila.indexOf(numproc);
    }

    private void checkMan() {
        for (int i : fila) {
            hasMan = i >= 0 ? true : false;
            if (hasMan)
                return;
        }
    }

    public int find_if() {
        checkMan();
        return hasMan ? 0 : -1;
    }

    public int min_element() {
        return fila.indexOf(Collections.min(fila));
    }

    public int find_min_if() {
        checkMan();
        if (hasMan) {
            int menor = 10000;
            for (int i : fila) {
                if (i >= 0)
                    menor = menor > i ? i : menor;
            }
            return fila.indexOf(menor);
        }
        return -1;
    }

    public int count(int numproc) {
        int count = 0;
        for (int i : fila) {
            if (i == numproc)
                count++;
        }
        return count;
    }

    public int sum() {
        int total = 0;
        for (int i : fila) {
            total += Math.abs(i);
        }
        return total;
    }

    public double average() {
        double total = 0;
        for (double i : fila) {
            total += Math.abs(i);
        }
        return total / fila.size();
    }

    public String more_men() {
        int total = 0;
        for (int i : fila) {
            if (i >= 0)
                total++;
            if (total > fila.size() / 2)
                return "men";
        }
        if (total == fila.size() / 2)
            return "draw";
        return "women";
    }

    public String half_compare() {
        int[] total = new int[2];
        int counter = 1;
        for (int i : fila) {
            i = Math.abs(i);
            if (counter++ > (fila.size() / 2)) {
                total[1] += i;
            } else
                total[0] += i;
        }
        if (total[0] == total[1])
            return "draw";
        else if (total[0] > total[1])
            return "first";
        return "second";
    }

    public String sex_battle() {
        int total = 0;
        for (int i : fila) {
            total += i;
        }
        if (total == 0)
            return "draw";
        else if (total > 0)
            return "men";
        return "women";
    }

    public Vector<Integer> get_men() {
        Vector<Integer> osmis = new Vector<Integer>();
        for (int i : fila) {
            if (i > 0)
                osmis.add(i);
        }
        return osmis;
    }

    public Vector<Integer> get_calm_women() {
        Vector<Integer> mulher = new Vector<Integer>();
        for (int i : fila) {
            if (i < 0 && Math.abs(i) < 10) {
                mulher.add(i);
            }
        }
        return mulher;
    }

    public void sort() {
        Collections.sort(fila);
        System.out.println(fila);
    }

    public void sort_stress() {
        Vector<Integer> aux = new Vector<Integer>();
        Vector<Integer> copy = fila;
        for (int i : fila) {
            aux.add(Math.abs(i));
        }
        int index = 0;
        int actual = Collections.min(aux);
        int last = Collections.max(aux);
        while (actual != last) {
            for (int i : copy) {
                if (actual == Math.abs(i)) {
                    aux.set(index++, i);
                    aux.remove(index_of(Math.abs(i)));
                    actual = Math.abs(Collections.min(aux));
                    System.out.println(actual + " " + i + " " + aux);
                    break;
                }
            }
        }
        fila = aux;
        System.out.println(fila);
    }

    public Vector<Integer> reverse() {
        Vector<Integer> aux = new Vector<Integer>();
        int i = fila.size();
        while (i >= 0)
            aux.add(fila.get(i - 1));
        return aux;
    }

    public void reverse_inplace() {
        Collections.reverse(fila);
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            System.out.println("$" + line);

            if (ui[0].equals("end"))
                System.exit(0);

            if (ui[1].equals("[]")) {
                System.out.println("-1");
                continue;
            }

            // transforms the new vector.;
            ui[1] = ui[1].replace("[", "");
            ui[1] = ui[1].replace("]", "");
            String[] nums = ui[1].split(",");

            Vector<Integer> aux = new Vector<Integer>();
            for (String i : nums)
                aux.add(Integer.parseInt(i));
            Fila fila = new Fila(aux);

            switch (ui[0]) {
                case "in":
                    System.out.println(fila.in(Integer.parseInt(ui[2])));
                    break;
                case "index_of":
                    if (ui[2].equals(""))
                        ui[2] = ui[3];
                    System.out.println(fila.index_of(Integer.parseInt(ui[2])));
                    break;
                case "count":
                    System.out.println(fila.count(Integer.parseInt(ui[2])));
                    break;
                case "find_if":
                    System.out.println(fila.find_if());
                    break;
                case "min_element":
                    System.out.println(fila.min_element());
                    break;
                case "find_min_if":
                    System.out.println(fila.find_min_if());
                    break;
                case "sum":
                    System.out.println(fila.sum());
                    break;
                case "average":
                    System.out.format("%.2f\n", fila.average());
                    break;
                case "half_compare":
                    System.out.println(fila.half_compare());
                    break;
                case "more_men":
                    System.out.println(fila.more_men());
                    break;
                case "sex_battle":
                    System.out.println(fila.sex_battle());
                    break;
                case "sort":
                    fila.sort();
                    break;
                case "get_men":
                    System.out.println(fila.get_men());
                    break;
                case "get_calm_women":
                    System.out.println(fila.get_calm_women());
                    break;
                case "sort_stress":
                    fila.sort_stress();
                    break;
                default:
                    System.out.println("Comando inválido");
            }
        }
    }
}
