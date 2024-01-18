
public class Exemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exemplo exemplo = new Exemplo();
		exemplo.inicia();
	}
	
	public void inicia() {
		Turma turma = new Turma();
		turma.adicionaAluno(new Aluno("Ana",13));
		turma.adicionaAluno(new Aluno("Rui",10));
		turma.adicionaAluno(new Aluno("Ari",12));
		
		IIterator iterador = turma.criaIterator("OrdemDeAdicaoIterator");
		
		while(iterador.temProximo()) {
			System.out.println("Proximo aluno usando OrdemDeAdicaoIterator é: "+ iterador.leProximo().getNome());
		}
		
		iterador = turma.criaIterator("OrdemDeIdadeIterator");
		
		while(iterador.temProximo()) {
			System.out.println("Proximo aluno usando OrdemDeIdadeIterator é: "+ iterador.leProximo().getNome());
		}
		
		iterador = turma.criaIterator("CiclicoIterador");
		
		while(iterador.temProximo()) {
			System.out.println("Proximo aluno usando CiclicoIterador é: "+ iterador.leProximo().getNome());
		}
	}

}
