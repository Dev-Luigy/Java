import java.util.ArrayList;

public class BaseDadosJogo implements IBaseDados{
    //Adiciona em uma base de dados qualquer
    private ArrayList<Jogo> repositorioJogos;
    public void adicionarBaseDeDados(String titulo, String descricao){
        repositorioJogos.add(new Jogo(titulo, descricao));
    }
}
