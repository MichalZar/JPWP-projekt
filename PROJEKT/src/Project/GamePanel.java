package Project;

import Project.Menu;
import Project.Player;
import Project.QandA;
import Project.TimerLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Główny obszar graficzny gry
 * Klasa dziedzicząca po klasie JPanel
 * @author Michał Zaranko
 */
public class GamePanel extends JPanel implements ActionListener{
    /** Ikona obrazu tła gry */
    ImageIcon backgroundImage = new ImageIcon("images/mur2.png");
    /** Obraz tła gra */
    Image background = backgroundImage.getImage();
    /** Etykieta odpowiedzalna za wyświetlanie postaci gracza */
    Player player = new Player();
    /** Timer potrzebny do działania metody poruszania się postaci */
    Timer mainTimer = new Timer(10,this);
    /** Etykieta odpowiedzialna za wyświetlanie zegara odliczającego czas */
    TimerLabel timerLabel = new TimerLabel();
    /** Etykieta odpowiedzialna za wyświetlanie menu gry */
    Project.Menu menu = new Menu();
    /** Czcionka stosowna w etykietach tekstowych */
    Font newFont = new Font("BOLD", Font.BOLD, 50);
    /** Kolor tekstu stosowany w etykietach tekstowych */
    Color textColor = new Color(65,175,254);
    /** Etykieta odpowiedzialna za wyświetlanie poziomu gry */
    JLabel levelLabel = new JLabel();
    /** Etykieta odpowiedzialna za wyświetlanie pytań i odpowiedzi w grze */
    QandA qanda = new QandA();
    /** Zmienna określająca poziom gry */
    int level;
    /** Zmienna określająca czas gry */
    int time;
    /** Zmienna określająca ile razy można powtórzyć poziom */
    boolean repeat = true;

    /**
     * Konstruktor klasy pola graficznego gry.
     * Ustawienia początkowe oraz ładowanie zasobów
     * Ponadto dodanie obsługi zdarzenia rozpoczęcia nowej gry w polu graficznym gry
     * @param width Szerokość pola graficznego gry
     * @param height Wysokość pola graficznego gry
     */
    public GamePanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        setFocusable(true);
        addKeyListener(player);
        mainTimer.start();
        qanda.setSize(width,height);
        timerLabel.setLocation(80,20);
        levelLabel.setLocation(100,730);
        levelLabel.setFont(newFont);
        levelLabel.setForeground(textColor);
        levelLabel.setSize(400, 50);
        add(levelLabel);
        add(timerLabel);
        add(menu);
        add(qanda);
        restartGame();
        menu.newgameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restartGame();

            }
        });
    }


    /**
     * Nadpisz metodę odpowiedzialną za odrysowanie panelu - własne wypełnienie
     * pola graficznego gry, zgodnie z wybraną treścią.
     * @param g
     */
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(background,0,0,this);
        player.draw(g);

    }

    /**
     * Główna metoda odpowiedzialna za wykreywanie akcji na ekranie oraz odrysowywanie ekranu
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        checkAnswer();
        checkEnd();
        repaint();
    }

    /**
     * Restart gry - ustawienia parametrów początkowych gry
     */
    public void restartGame(){
        level = 1;
        time = 50;
        startGame();

    }

    /**
     * Start gry - ustawienia parametrów kolejnego poziomu
     */
    public void startGame(){
        levelLabel.setText("Poziom: " + level);
        timerLabel.setText("Czas: " + time +  " sekund");
        timerLabel.timeLeft = time;
        qanda.choose();
        player.playerX = 100;
        player.playerY = 100;
        player.dx = 0;
        player.dy = 0;
        player.playerAnswer = 0;
    }

    /**
     * Sprawdzenie końca poziomu - sprawdza czy zostały spełnione odpowiednie kończące całą grę lub dany poziom
     */
    public void checkEnd(){
        if(level == 6){
            String[] options = {"Nowa gra", "Wyjdz"};
            var selection = JOptionPane.showOptionDialog(null,
                    "Wygrałeś! Wybierz odpowiednią opcję",
                    "Koniec gry",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if(selection == 0){
                restartGame();
            }
            if(selection == 1){
                System.exit(0);
            }
        }else{
            if(player.playerAnswer == qanda.answer){
                JOptionPane.showMessageDialog(null, "Poprawna odpowiedź! Ilosć czasu na nasętpny poziom: " + (time = time - 10) + " sekund.");
                level++;
                startGame();
            }else if(player.playerAnswer != 0){
                String[] options = {"Nowa gra", "Powtorz", "Wyjdz"};
                var selectionWrong = JOptionPane.showOptionDialog(null,
                        "Przegrales, zla odpowiedz!",
                        "Koniec gry",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if(selectionWrong == 0){
                    restartGame();
                }
                if((selectionWrong == 1) && (repeat)){
                    startGame();
                    repeat = false;
                }
                if(selectionWrong == 2){
                    System.exit(0);
                }
            }else if(timerLabel.timeLeft == 0){
                String[] options = {"Nowa gra", "Powtorz", "Wyjdz"};
                var selectionTime = JOptionPane.showOptionDialog(null,
                        "Przegrales, koniec czasu!",
                        "Koniec gry",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if(selectionTime == 0){
                    restartGame();
                }
                if((selectionTime == 1) && (repeat)){
                    startGame();
                    repeat = false;
                }
                if(selectionTime == 2){
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Sprawdzenie odpowiedzi jaką udzielił gracz - ustawienie odpowiednich parametrów
     */
    public void checkAnswer(){
        if(qanda.Abounds.intersects(player.getBounds())){
            player.playerAnswer = 1;
        }else if(qanda.Bbounds.intersects(player.getBounds())){
            player.playerAnswer = 2;
        }else if(qanda.Cbounds.intersects(player.getBounds())){
            player.playerAnswer = 3;
        }else if(qanda.Dbounds.intersects(player.getBounds())){
            player.playerAnswer = 4;
        }
    }

}