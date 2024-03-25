package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Prosta gra jako przykład aplikacji interaktywnej
 * Okno główne gry
 * @author Michał Zaranko
 */
public class GameFrame extends JFrame {
    /** Główna szerokość okna */
    final public int width = 1290;
    /** Główna wysokość okna */
    final public int height = 835;
    /** Obraz tytułu gry */
    ImageIcon titlePicture;
    /** Obraz napisu nowej gry */
    ImageIcon newgamePicture;
    /** Obraz napisu wyjścia z programu */
    ImageIcon exitPicture;
    /** Etykieta tytułu gry */
    JLabel title = new JLabel();
    /** Etykieta przycisku nowej gry */
    JLabel startButton = new JLabel();
    /** Etykieta przycisku wyjścia z gry */
    JLabel exitButton = new JLabel();
    /** Kolor tła menu */
    Color color = new Color(208,100,21);

    /**
     * Główny konstruktor klasy - ustawienie elementów menu startowego i rozpoczęcia akcji
     */
    public GameFrame() {
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Think to survive");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        titlePicture = new ImageIcon("images/title.png");
        newgamePicture = new ImageIcon("images/newgame.png");
        exitPicture = new ImageIcon("images/exit.png");
        title.setIcon(titlePicture);
        startButton.setIcon(newgamePicture);
        exitButton.setIcon(exitPicture);
        JPanel startPanel = new JPanel();
        startPanel.setBackground(color);
        startPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        startPanel.add(title, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        startPanel.add(startButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        startPanel.add(exitButton, gbc);

        add(startPanel);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                init(width,height);
            }
        });
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    /**
     * Utwórz interfejs graficzny użytkownika
     * @param width szerokość okna
     * @param height wysokość okna
     */
    public void init(int width, int height){
        setVisible(false);
        JFrame gameFrame = new JFrame();
        dispose();
        gameFrame.setSize(width,height);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Think to survive");
        gameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.setLayout(new GridLayout(1,1));
        GamePanel gamePanel = new GamePanel(width,height);
        gameFrame.add(gamePanel);
    }

    /**
     * Metoda uruchamia grę.
     */
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();
    }
}