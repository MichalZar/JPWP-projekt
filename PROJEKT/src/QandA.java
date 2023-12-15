import javax.swing.*;
import java.awt.*;

public class QandA extends JPanel {

    Image question;
    Image answer1;
    Image answer2;
    Image answer3;
    Image answer4;
    public QandA(){
        question = Toolkit.getDefaultToolkit().createImage("res/pytanieprzyklad.png");
        answer1 = Toolkit.getDefaultToolkit().createImage("res/przykladA.png");
        answer2 = Toolkit.getDefaultToolkit().createImage("res/przykladB.png");
        answer3 = Toolkit.getDefaultToolkit().createImage("res/przykladC.png");
        answer4 = Toolkit.getDefaultToolkit().createImage("res/przykladD.png");
    }

    public void drawQandA(Graphics g){
        g.drawImage(question,100,150,null);
        g.drawImage(answer1,250,400,null);
        g.drawImage(answer2,800,400,null);
        g.drawImage(answer3,250,600,null);
        g.drawImage(answer4,800,600,null);
    }
}
