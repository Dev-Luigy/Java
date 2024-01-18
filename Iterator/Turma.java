import java.util.ArrayList;

public class Turma implements IAgregador{
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	
	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public IIterator criaIterator(String tipo) {
		Aluno a[] = new Aluno[this.alunos.size()];
		switch(tipo){
		case "OrdemDeAdicaoIterator": return new OrdemDeAdicaoIterator(this.alunos.toArray(a));
		case "OrdemDeIdadeIterator": return new OrdemDeIdadeIterator(this.alunos.toArray(a));
		case "CiclicoIterador": return new CiclicoIterador(this.alunos.toArray(a));
		default: return new OrdemDeAdicaoIterator(this.alunos.toArray(a));
		}
	}
}
