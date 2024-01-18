import java.util.Scanner;


class Lutador{
    private String nome = "";
    private String nacionalidade = "";
    private int Idade = 0;
    private double altura = 0;
    private double peso = 0;
    private String categoria = "";
    private int vitorias, derrotas, empates = derrotas = vitorias = 0;

    public Lutador(String nome, String nacionalidade, int Idade, double altura, double peso, int vitorias, int derrotas, int empates){
        this.nome = nome;
        this.Idade = Idade;
        this.altura = altura;
        this.peso = peso;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.nacionalidade = nacionalidade;
    }


    //actions
    public void apresentar(){
        System.out.println("Lutador: " + getNome() + "\n" +
                           "Origem: "  + getNacionalidade() + "\n" +
                           "Idade: "   + getIdade() + " anos\n" +
                           "Altura: "  + getAltura()+ "m\n" +
                           "Pesando "  + getPeso()  + "kg\n" +
                           "Ganhou: "  + getVitorias() + "\n" +
                           "Perdeu: "  + getDerrotas() + "\n" +
                           "Empartou: "+ getEmpates());
    }

    public void status(){
        System.out.println("Lutador: " + getNome()      + "\n" + 
                           "Peso: "    + getCategoria() + "\n" +
                           "Ganhou: "  + getVitorias()  + "\n" +
                           "Perdeu: "  + getDerrotas()  + "\n" +
                           "Empartou: "+ getEmpates());
    }

    public void ganharLuta(){
        vitorias++;
    }

    public void perderLuta(){
        derrotas++;
    }

    public void empatarLuta(){
        empates++;
    }


    //getters
    public double getAltura() {
        return altura;
    }
    public String getCategoria() {
        return categoria;
    }
    public int getDerrotas() {
        return derrotas;
    }
    public int getEmpates() {
        return empates;
    }
    public int getIdade() {
        return Idade;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public String getNome() {
        return nome;
    }
    public double getPeso() {
        return peso;
    }
    public int getVitorias() {
        return vitorias;
    }
    
    //setters



}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String [] ui = line.split(" ");

        while(true){
            if (ui[0].equals("end")) break;
            else {
                System.out.println(ui[0]);
                break;
            }
        }
    }
}
