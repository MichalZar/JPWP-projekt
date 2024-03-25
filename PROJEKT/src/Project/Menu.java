package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa odpowiedzialna za wyświetlanie menu graficznego
 * Klasa dziedzicząca po klasie JLabel
 * @author Michał Zaranko
 */
public class Menu extends JLabel {
    /** Obraz przycisku menu */
    ImageIcon menuImage;
    /** Obraz przycisku nowej gry */
    ImageIcon newgameImage;
    /** Obraz przycisku wyjścia z gry */
    ImageIcon exitImage;
    /** Obraz przycisku zamknięcia menu */
    ImageIcon gameImage;
    /** Główna szerokość etykiety */
    private final int Width = 200;
    /** Główna wysokość etykiety */
    private final int Height = 70;
    /** Etykieta wyświetlająca przycisk nowej gry */
    JLabel newgameButton = new JLabel();
    /** Etykieta wyświetlająca przycisk wyjścia z gry */
    JLabel exitButton = new JLabel();
    /** Etykieta wyświetlająca przycisk zamykający menu */
    JLabel gameButton = new JLabel();

    /** Konstruktor - ustawienie parametrów obiektów
     * Dodanie obsługi zdarzeń przyciksów w menu
     */
    public Menu(){
        menuImage = new ImageIcon("images/menu.png");

        newgameImage = new ImageIcon("images/newgame.png");
        exitImage = new ImageIcon("images/exit.png");
        gameImage = new ImageIcon("images/game.png");

        newgameButton.setIcon(newgameImage);
        exitButton.setIcon(exitImage);
        gameButton.setIcon(gameImage);

        setIcon(menuImage);

        setBounds(1000,720,Width,Height);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setIcon(null);
                setBounds(630,720,Width+370,Height);
                setLayout(new GridBagLayout());
                add(newgameButton);
                add(exitButton);
                add(gameButton);
                exitButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.exit(0);
                    }
                });
                gameButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        removeAll();
                        setIcon(menuImage);
                        setBounds(1000,720,Width,Height);
                    }
                });
            }
        });

    }

}
