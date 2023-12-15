import java.awt.*;

public class Background {

    Image tlo;
    Image poziom;
    public Background(){
        tlo = Toolkit.getDefaultToolkit().createImage("res/mur2.png");
        poziom = Toolkit.getDefaultToolkit().createImage("res/poziomprzyklad.png");
    }

    public void drawBackground(Graphics g){
        g.drawImage(tlo,0,0,null);
        g.drawImage(poziom,50,720,null);
    }
}
