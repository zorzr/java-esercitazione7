// ESERCITAZIONE 7
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author zorzr
 */

public class Tastiera extends JPanel {
    JButton b[] = new JButton[20];
    String pulsanti = "7,8,9,+,C,4,5,6,-,CE,1,2,3,*,DEL,0,.,=,/,±";

    public Tastiera (ActionListener a) {
        setLayout(new GridLayout(4, 5));
        
        for (int i = 0; i < 20; i++) {
            b[i] = new JButton();
            b[i].setText(pulsanti.split(",")[i]);
            b[i].setPreferredSize(new Dimension(56, 31));
            b[i].addActionListener(a);
            add(b[i]);
        }
    }
}
