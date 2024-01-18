import java.util.ArrayList;

public class Brinquedoteca {
	private ArrayList<Brinquedo> brinquedos;
	private Funcionario gerente;
	
	public Brinquedoteca(Funcionario gerente) {
		brinquedos = new ArrayList<Brinquedo>();
		this.gerente = new Funcionario(gerente.nome);
	}
	
	public int leNumeroPilhas() {
		int pilhas = 0;
		for (Brinquedo b: brinquedos) {
			b.leTamanho();
		}
		return pilhas;
	}
	
	public void adicionaBrinquedo(Brinquedo b){
		this.brinquedos.add(b);
	}
}