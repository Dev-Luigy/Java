public class JogoDAO {
    private BaseDadosJogo base;
    //Cham a base de dados desejada para criar adicionar nela o filme
    public void adicionarJogo(String titulo, String descricao){
        base.adicionarBaseDeDados(titulo, descricao);
    }
}
