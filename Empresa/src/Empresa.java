import java.util.ArrayList;

public class Empresa {
    private ArrayList<Empregado> empregados = new ArrayList<Empregado>();
    
    public void adicionaEmpregado(Empregado p){
        empregados.add(p);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa:");
        for (Empregado p : empregados){
            System.out.println(p.toString());
        }
    }

    public double calculaFolha(){
        double total = 0d;
        for (Empregado p : empregados){
            total += p.pagamento();
        }
        return total;
    }

}
