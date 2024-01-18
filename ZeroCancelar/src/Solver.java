import java.util.ArrayList;
import java.util.Scanner;

class ComputaSequencia {
    private ArrayList<Integer> nums = new ArrayList<Integer>();
    private int total;

    // actions
    public void cadastra(int valor) {
        if (valor != 0) {
            nums.add(valor);
            total += valor;
        } else {
            total -= nums.get(nums.size() - 1);
            nums.remove(nums.size() - 1);
        }
    }

    public int computa() {
        return total;
    }

    public String toString() {
        return "valores: = " + nums;
    }

}

public class Solver {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia a = new ComputaSequencia();
        while (true) {
            String line = scanner.nextLine();
            String[] in = line.split(" ");

            System.out.println("$" + line);

            switch (in[0]) {
                case "cadastra":
                    a.cadastra(Integer.parseInt(in[1]));
                    break;
                case "computa":
                    System.out.println(a.computa());
                    break;
                case "show":
                    System.out.println(a);
                    break;
                case "end":
                    System.exit(0);
                default:
                    System.out.println("fail: comando invalido");
            }
        }

    }
}
