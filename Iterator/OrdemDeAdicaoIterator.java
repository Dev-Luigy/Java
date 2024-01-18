
public class OrdemDeAdicaoIterator implements IIterator{
	private Aluno[] alunos;
	private int atual;
	public OrdemDeAdicaoIterator(Aluno[] alunos) {
		this.alunos = alunos;
		atual = 0;
	}
	
	public boolean temProximo() {
		if(alunos.length ==0) {
			return false;
		} else {
			
			if(alunos.length>atual) {
				return true;
			} 
			// se cheguei no fim
				else {
				return false;
			}
		}
	}
	public Aluno leProximo() {
		Aluno aluno = null;
		if(this.temProximo()) {
			aluno = this.alunos[atual];
			atual++;
		}
		return aluno;
	}
}
