
public class OrdemDeIdadeIterator implements IIterator{
	private Aluno[] alunos;
	private int atual;
	public OrdemDeIdadeIterator(Aluno[] alunos) {
		this.alunos = alunos;
		this.ordenar();
		atual = 0;
	}
	
	
	private void ordenar() {
		for(int i = 0; i< alunos.length; i++){
            for(int j = i+1; j<alunos.length; j++){
                //if(alunos[i].compareTo(alunos[j])>0){
            	if(alunos[i].getIdade()>alunos[j].getIdade()){
                    //troca
                    Aluno temporario = alunos[i];
                    alunos[i] = alunos[j];
                    alunos[j] = temporario;
                }
            }
        }
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
