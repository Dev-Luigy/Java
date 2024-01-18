import javax.swing.*;
import java.awt.*;

public class SimpleFrame extends JFrame{
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton unsubscribe = new JButton("Unsubscribe");
    JFormattedTextField teste = new JFormattedTextField();
    public SimpleFrame(){
        super("Minha Janela");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(load).setPreferredSize(new Dimension(100, 25));
        panel.add(save);
        panel.add(unsubscribe);
        panel.add(teste).setPreferredSize(new Dimension (100, 25));
        add(panel);
        setVisible(true);
    }
}