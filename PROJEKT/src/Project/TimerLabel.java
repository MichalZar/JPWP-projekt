package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa odpowiedzialna za wyświetlanie zegara odliczającego czas
 * Klasa dziedzicząca po klasie JLabel
 * @author Michał Zaranko
 */
public class TimerLabel extends JLabel {
    /** Zmienna klasy Timer odpowiedzialna za odliczanie czasu */
    final private Timer timer;
    /** Zmienna przechwoująca informacje o pozostałym czasie */
    public int timeLeft;
    /** Czcionka stosowna w etykiecie tekstowej */
    Font newFont = new Font("BOLD", Font.BOLD, 40);
    /** Kolor tekstu stosowany w etykiecie tekstowej */
    Color textColor = new Color(65,175,254);

    /** Konstruktor - ustawienie parametrów obiektów oraz odliczanie i wyświetlanie pozostałego czasu */
    public TimerLabel(){
        setSize(400, 50);

        setFont(newFont);

        setForeground(textColor);

        setText("Czas: " + timeLeft +  " sekund");

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                if (timeLeft >= 0) {
                    setText("Czas: " + timeLeft + " sekund");
                } else {
                    timer.stop();
                    setText("Czas minął");
                    timer.start();
                }
            }
        });

        timer.start();
    }
}
