package Project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Klasa odpowiedzialna za wyświetlanie pytań i odpowiedzi na ekranie oraz losowanie kolejnych pytań
 * Klasa dziedzicząca po klasie JLabel
 * @author Michał Zaranko
 */
public class QandA extends JLabel {
    /** Czcionka stosowna w etykietach tekstowych */
    Font newFont = new Font("BOLD", Font.BOLD, 40);
    /** Kolor tekstu stosowany w etykietach tekstowych */
    Color textColor = new Color(65,175,254);
    /** Główna szerokość etykiety */
    int answidth = 300;
    /** Główna wysokość etykiety */
    int ansheight = 100;
    /** Zmienna potrzebna do przechownia wielkości ramki odpowiedzi A */
    Rectangle Abounds;
    /** Zmienna potrzebna do przechownia wielkości ramki odpowiedzi B */
    Rectangle Bbounds;
    /** Zmienna potrzebna do przechownia wielkości ramki odpowiedzi C */
    Rectangle Cbounds;
    /** Zmienna potrzebna do przechownia wielkości ramki odpowiedzi D */
    Rectangle Dbounds;
    /** Etykieta wyświetlająca pytanie */
    JLabel questionLabel = new JLabel();
    /** Etykieta wyświetlająca odpowiedź A */
    JLabel ALabel = new JLabel();
    /** Etykieta wyświetlająca odpowiedź B */
    JLabel BLabel = new JLabel();
    /** Etykieta wyświetlająca odpowiedź C */
    JLabel CLabel = new JLabel();
    /** Etykieta wyświetlająca odpowiedź D */
    JLabel DLabel = new JLabel();
    /** Lista przechowująca pytania */
    String[] questions = {"Jaki typ danych w Javie ma najwiekszy rozmiar?",
            "Co w matematyce oznacza symbol '∇'?",
            "Która kolekcja w Javie pozwala przechowywać klucze i wartości",
            "Pochodna trzeciego rzędu funkji f(x) = x^3 - 6x^2 + 11x - 6 wynosi: ",
            "Modyfikator pozwalający na dostęp TYLKO w obrębie danej klasy"};
    /** Lista przechowująca odpowiedzi A */
    String[] Atable ={"A) Short","A) Gradient","A) Set","A) 0","A) package"};
    /** Lista przechowująca odpowiedzi B */
    String[] Btable ={"B) Long", "B) Delta", "B) ArrayList", "B) 6", "B) protected"};
    /** Lista przechowująca odpowiedzi C */
    String[] Ctable ={"C) Int", "B) Trójkąt", "C) Map", "C) 6x - 12", "C) public"};
    /** Lista przechowująca odpowiedzi D */
    String[] Dtable ={"D) Byte", "D) Stożek", "D) List", "D) 3x^2 - 12x", "D) private"};
    /** Lista przechowująca poprawne odpowiedzi*/
    int[] correct = {2,1,3,2,4};
    /** Zmienna przechowująca odpowiedź na wylosowane pytanie */
    int answer;
    /** Konstruktor - ustawienie parametrów obiektów */
    public QandA(){
        setLayout(null);

        Font questFont = new Font("BOLD", Font.BOLD, 30);

        questionLabel.setFont(questFont);
        questionLabel.setForeground(textColor);
        ALabel.setFont(newFont);
        ALabel.setForeground(textColor);
        BLabel.setFont(newFont);
        BLabel.setForeground(textColor);
        CLabel.setFont(newFont);
        CLabel.setForeground(textColor);
        DLabel.setFont(newFont);
        DLabel.setForeground(textColor);

        choose();

        questionLabel.setSize(1000,100);
        ALabel.setSize(answidth,ansheight);
        BLabel.setSize(answidth,ansheight);
        CLabel.setSize(answidth,ansheight);
        DLabel.setSize(answidth,ansheight);

        ALabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        BLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        CLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
        DLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));

        questionLabel.setLocation(200,100);
        ALabel.setLocation(250,250);
        BLabel.setLocation(750,250);
        CLabel.setLocation(250,500);
        DLabel.setLocation(750,500);

        add(questionLabel);
        add(ALabel);
        add(BLabel);
        add(CLabel);
        add(DLabel);

        Abounds = ALabel.getBounds();
        Bbounds = BLabel.getBounds();
        Cbounds = CLabel.getBounds();
        Dbounds = DLabel.getBounds();

    }

    /** Metoda odpowiedzialna za wylosowanie pytania i ustawienie odpowiedzi */
    public void choose(){
        Random random = new Random();
        int index = random.nextInt(5);
        answer = correct[index];

        questionLabel.setText(questions[index]);
        ALabel.setText(Atable[index]);
        BLabel.setText(Btable[index]);
        CLabel.setText(Ctable[index]);
        DLabel.setText(Dtable[index]);
    }

}