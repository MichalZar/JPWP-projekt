import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel {
    Image menu;

    private MouseListener listener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }
    };

    public Menu(){
        addMouseListener(listener);
        menu = Toolkit.getDefaultToolkit().createImage("res/menu.png");
    }

    public void drawMenu(Graphics g){
        g.drawImage(menu,1000,720,null);
    }
}
