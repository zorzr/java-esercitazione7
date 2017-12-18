// ESERCITAZIONE 7
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author zorzr
 */

public class MainPanel extends JPanel {
    JTextField text;
    
    public MainPanel() {
        text = new JTextField(17);
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setFont(new Font(text.getFont().getName(), Font.PLAIN, 20));
        text.setText("Ciao!");
        
        //text.setBackground(Color.black);
        //text.setForeground(Color.white);
        
        text.setEditable(false);
        add(text);
    }

    public JTextField Text() {
        return text;
    }
    
}