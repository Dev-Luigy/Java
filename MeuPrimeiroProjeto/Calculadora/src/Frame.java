import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    
    JButton SolveButton = new JButton("Resolver");
    Color BackgroundColor = new Color(255, 255, 255);
    
    public Frame(){
        //vars to Frame.
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //vars to Panel.
        JPanel Panel = new JPanel();
        Panel.setBackground(BackgroundColor);
        Panel.add(SolveButton);
        SolveButton.setLocation(50, 100);
        
        
        add(Panel);
        setVisible(true);
    }
}
