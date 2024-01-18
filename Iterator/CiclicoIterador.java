
public class CiclicoIterador implements IIterator{
	private Aluno[] alunos;
	private int atual;
	public CiclicoIterador(Aluno[] alunos) {
		this.alunos = alunos;
		atual = 0;
	}
	
	public boolean temProximo() {
		return true;
	}
	public Aluno leProximo() {
		Aluno aluno = null;
		if(alunos.length<=atual) {
			atual=0;
		} 
		aluno = this.alunos[atual];
		atual++;
		return aluno;
	}
}