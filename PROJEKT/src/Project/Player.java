package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Klasa odpowiedzialna za wyświetlanie i sterowanie postacią
 * @author Michał Zaranko
 */
public class Player extends KeyAdapter {
    /** Zmienna przechwoująca informacje o zmianie pozycji gracza w poziomie */
    public int dx;
    /** Zmienna przechwoująca informacje o zmianie pozycji gracza w pionie */
    public int dy;
    /** Zmienna przechwoująca informacje o pozycji gracza w poziomie */
    public int playerX;
    /** Zmienna przechwoująca informacje o pozycji gracza w pionie */
    public int playerY;
    /** Zmienna przechwoująca informacje o szybkości poruszania się gracza */
    int playerSpeed = 5;
    /** Zmienna przechwoująca informacje o odpowiedzi udzielonej przez gracza */
    int playerAnswer;
    /** Ikona obrazu postaci gracza */
    ImageIcon playerImage = new ImageIcon("images/postac.png");
    /** Obrazu postaci gracza */
    Image player = playerImage.getImage();

    /** Konstruktor*/
    public Player(){}

    /** Metoda odpowiedzialna za zmianę pozycji gracza oraz ograniczenie wyjścia gracza poza dozwolony obszar */
    public void update(){
        playerX += dx;
        playerY += dy;

        if(playerX<=73) playerX=73;
        if(playerX>=1128) playerX=1128;
        if(playerY<=80) playerY=80;
        if(playerY>=641) playerY=641;

    }

    /**
     * Nadpisz metodę odpowiedzialną za odrysowanie panelu - własne wypełnienie pola postacią gracza
     * @param g
     */
    public void draw(Graphics g){
        g.drawImage(player, playerX, playerY, null);
    }

    /**
     * Nadpisz metodę odpowiedzialną za naciśniecię odpowiedniego przycisku na klawiaturze
     * @param e
     */
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_W:
                dy = -playerSpeed;
                break;
            case KeyEvent.VK_S:
                dy = playerSpeed;
                break;
            case KeyEvent.VK_A:
                dx = -playerSpeed;
                break;
            case KeyEvent.VK_D:
                dx = playerSpeed;
                break;
        }
    }

    /**
     * Nadpisz metodę odpowiedzialną za zwolnienie odpowiedniego przycisku na klawiaturze
     * @param e
     */
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode){
            case KeyEvent.VK_W, KeyEvent.VK_S:
                dy = 0;
                break;
            case KeyEvent.VK_A, KeyEvent.VK_D:
                dx = 0;
                break;
        }
    }

    /**
     * Metoda odpowiedzialna za zwrócenie obiektu klasy rectangle reprezentującego rozmiar gracza
     * @return Rectangle
     */
    public Rectangle getBounds(){
        return new Rectangle(playerX,playerY,player.getWidth(null),player.getHeight(null));
    }

}
