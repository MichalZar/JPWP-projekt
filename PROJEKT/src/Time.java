import java.awt.*;

public class Time {
    Image timer;
    public Time(){
        timer = Toolkit.getDefaultToolkit().createImage("res/timeprzyklad.png");
    }

    public void drawTime(Graphics g){
        g.drawImage(timer,50,0,null);
    }
}
