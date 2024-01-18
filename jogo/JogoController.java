public class JogoController {
    JogoDAO dao = new JogoDAO();
    //Se comunicar com o DAO passando as informações inseridas na view
    public void adicionarJogo(String titulo, String descricao){
        dao.adicionarJogo(titulo, descricao);
    }
}
