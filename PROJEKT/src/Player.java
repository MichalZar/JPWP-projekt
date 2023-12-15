import java.awt.*;

public class Player extends Rectangle {

    Image image;

    private int dx,dy;

    int playerX = 100;
    int playerY = 250;

    public Player(int dx, int dy){
        image = Toolkit.getDefaultToolkit().createImage("res/postac.png");
        this.dx = dx;
        this.dy = dy;
    }

    public void draw(Graphics g){

        g.drawImage(image,playerX,playerY,null);

    }

    public void move(){
        playerX += dx;
        playerY += dy;
    }

    public void setDx(int dx){
        this.dx = dx;
    }

    public void setDy(int dy){
        this.dy = dy;
    }

}
