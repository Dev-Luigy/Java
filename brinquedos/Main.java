/*Classe feita somente para testar o código */


public class Main {
    public static void main(String[] args) {
        Brinquedoteca brinquedoteca = new Brinquedoteca(new Funcionario("Alberto"));
        Brinquedo favorita = new Boneca();

        System.out.println(favorita.leTamanho());
        System.out.println(favorita.leTipo());

        favorita = new Carro();
        System.out.println(favorita.leTamanho());
        System.out.println(favorita.leTipo());

        favorita = new Drone();
        System.out.println(favorita.leTamanho());
        System.out.println(favorita.leTipo());

        brinquedoteca.adicionaBrinquedo(favorita);
    }
}
