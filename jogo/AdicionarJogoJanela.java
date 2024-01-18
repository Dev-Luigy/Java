import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AdicionarJogoJanela extends JFrame implements ActionListener {

	JButton adicionar;
	JTextField titulo;
	JTextArea corpo;
	JogoController controller = new JogoController();
	
	public AdicionarJogoJanela() {
		titulo = new JTextField("Digite o t�tulo...");
		this.add(titulo,BorderLayout.NORTH);
		
		corpo = new JTextArea("Descri��o do jogo...");
		this.add(corpo,BorderLayout.CENTER);
		
		adicionar = new JButton("Adicionar Jogo");
		adicionar.addActionListener(this);
		this.add(adicionar,BorderLayout.SOUTH);
				
	}
	public static void main(String[] args){
		AdicionarJogoJanela adicionarJogoJanela = new AdicionarJogoJanela();
		adicionarJogoJanela.mostrar();
	}
	private void mostrar() {
		this.setSize(400,400);
		this.setLocation(100, 100);
		this.setVisible(true);
	}
	//Chama o método do controlado, pois a interface não pode dar um new na classe jogo
	@Override
	public void actionPerformed(ActionEvent publicarPost) {
		controller.adicionarJogo(titulo.getText(), corpo.getText());
	}
}
