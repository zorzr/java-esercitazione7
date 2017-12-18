// ESERCITAZIONE 7
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author zorzr
 */

public class Action implements ActionListener {
    MainPanel p;
    boolean display = false;
    double x = 0.;
    String op = "";

    public Action(MainPanel panel) {
        p = panel;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton b = (JButton) e.getSource();
            String t = b.getText();
            String label = p.Text().getText();
            
            if (label.equals("Ciao!")) {
                p.Text().setText("0");
                label = "0";
            }
            
            switch (t) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    if (label.equals("0") || display) {
                        label = "";
                        display = false;
                    }
                    if (label.length() > 20)   break;
                    p.Text().setText(label.concat(t));
                    break;
                case ".":
                    if (label.contains(t))   break;
                    p.Text().setText(label.concat(t));
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "=":
                    operate(label);
                    op = t;
                    break;
                case "±":
                    p.Text().setText(sign(label));
                    break;
                case "C":
                    x = 0.;
                    op = "";
                    display = false;
                    p.Text().setText("0");
                    break;
                case "CE":
                    p.Text().setText("0");
                    break;
                case "DEL":
                    p.Text().setText(delete(label));
                    break;
                default:
                    break;
            }
        }
    }
    
    private void operate (String label) {
        if (display)  op = "";
        
        switch(op) {
            case "+":
                x += Double.parseDouble(label);
                break;
            case "-":
                x -= Double.parseDouble(label);
                break;
            case "*":
                x *= Double.parseDouble(label);
                break;
            case "/":
                x /= Double.parseDouble(label);
                break;
            default:
                x = Double.parseDouble(label);
        }
        
        display = true;
        p.Text().setText(Double.toString(x));
    }
    
    private String delete (String label) {
        if (label.length() == 1)   return "0";
        int l = label.length();
        return label.substring(0, l-1);
    }
    
    private String sign (String label) {
        if (Double.parseDouble(label) < 0) {
            label = label.substring(1, label.length());
        } else if (Double.parseDouble(label) > 0) {
            label = "-" + label;
        }
        return label;
    }
    
}
