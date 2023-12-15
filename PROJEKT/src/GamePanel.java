import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    final static int playerSpeed = 4;

    Player player = new Player(0,0);

    Background bck = new Background();

    Menu menu = new Menu();

    QandA qanda = new QandA();

    Timer timer = new Timer(10,this);

    Time time = new Time();


    public GamePanel(int width, int height){
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);

        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_W -> {
                        if (player.playerY > 80) {
                            player.setDy(-playerSpeed);
                        }else{
                            player.setDy(0);
                        }
                    }
                    case KeyEvent.VK_S -> {
                        if (player.playerY < (height - 200)) {
                            player.setDy(playerSpeed);
                        }else{
                            player.setDy(0);
                        }
                    }
                    case KeyEvent.VK_A -> {
                        if (player.playerX > 80) {
                            player.setDx(-playerSpeed);
                        }else{
                            player.setDx(0);
                        }
                    }
                    case KeyEvent.VK_D -> {
                        if (player.playerX < (width - 180)) {
                            player.setDx(playerSpeed);
                        }else{
                            player.setDx(0);
                        }
                    }

                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();

                switch (code) {
                    case KeyEvent.VK_W, KeyEvent.VK_S -> {
                        player.setDy(0);
                    }
                    case KeyEvent.VK_A, KeyEvent.VK_D -> {
                        player.setDx(0);
                    }

                }
            }
        });

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        repaint();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        bck.drawBackground(g2);

        player.draw(g2);

        menu.drawMenu(g2);

        qanda.drawQandA(g2);

        time.drawTime(g2);

        g2.dispose();

    }

}
