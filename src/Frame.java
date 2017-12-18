// ESERCITAZIONE 7
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author zorzr
 */

public class Frame extends JFrame {
    MainPanel panel;
    Tastiera tast;

    public Frame() {
        setTitle("ZorzoCalc");
        setSize(300, 200);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setLocation(screenWidth / 4, screenHeight / 4);
        
        panel = new MainPanel();
        Action a = new Action(panel);
        tast = new Tastiera(a);
        panel.add(tast);
        
        Container contentPane = getContentPane();
        contentPane.add(panel);
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(panel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
