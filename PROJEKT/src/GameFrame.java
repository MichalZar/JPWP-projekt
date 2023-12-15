import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    final public int width = 1290;
    final public int height = 835;

    public GameFrame() {
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Think to survive");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
        setVisible(true);
    }

    public void init(){
        setLayout(new GridLayout(1,1));
        GamePanel panel = new GamePanel(width,height);
        add(panel);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }

}
