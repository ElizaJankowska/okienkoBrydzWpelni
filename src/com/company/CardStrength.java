package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CardStrength extends JFrame implements ActionListener {
    JTextField argument;
    JLabel wynik;
    JButton zamiana;
    JButton losowanie;
    JLabel heart;
    JLabel club;
    JLabel diamond;
    JLabel spade;
    JTextField labelHeart;
    //jedno okienko-> dwa przyciski (losowanie i normalne wpisywanie sekwencji)
    //drugie okienko-> wynik

    //nowy program ze uzytkownik moze wprowadzic sekwencje albo i nie ale kazdy kolor ma inne pole tekstowe i mozna losowac
    //kolejny update to zamiast "trefl", "karo" wrzucic obrazki jako etykiety

    //kolejny update to rozłozenie tych pól ze piki u góry, przyciski po środku i wokół przycisków serca i karo a na dole trefle (trzy panele dzielace okienko

    public static String tenCard(String array) {
        array = array.replaceAll("10", "T");
        return array;
    }

    public static int bonus(String array) {
        int bonus;
        switch (array.length()) {
            case 0:
                bonus = 3;
                break;
            case 1:
                bonus = 2;
                break;
            case 2:
                bonus = 1;
                break;
            default:
                bonus = 0;
                break;
        }
        return bonus;
    }

    public static int countingPoints(String card) {

        card = card.toUpperCase(Locale.ROOT);
        String[] colors = card.split("[SHDC]");
        int score = 0;
        for (int i = 0; i < card.length(); i++) {
            switch (card.charAt(i)) {
                case 'A':
                    score = score + 4;
                    break;
                case 'K':
                    score = score + 3;
                    break;
                case 'Q':
                    score = score + 2;
                    break;
                case 'J':
                    score = score + 1;
                    break;
            }
        }

        String spades = colors[1];
        String heart = colors[2];
        String diamond = colors[3];
        String club = colors[4];
        spades = tenCard(spades);
        heart = tenCard(heart);
        diamond = tenCard(diamond);
        club = tenCard(club);

        score = score + bonus(spades);
        score = score + bonus(heart);
        score = score + bonus(diamond);
        score = score + bonus(club);
        //saj1076h4dakq95cj10
        return score;
    }

    public CardStrength() throws IOException {
        super("Liczenie sily reki ver 1.0");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setBackground(Color.pink);
        argument = new JTextField(20);
        add(new Label("Twoje karty to: "));
        add(argument);

        zamiana = new JButton("Punkty");
        zamiana.addActionListener(this);
        add(zamiana);

        losowanie = new JButton("Losuj");
        losowanie.addActionListener(this);
        add(losowanie);
        //Image dimg = icon.getScaledInstance(jlabel.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        /*ImageIcon iconHeart = new ImageIcon("heart.jpg");
        Image imageH = iconHeart.getImage();
        Image newimageH = imageH.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconHeart = new ImageIcon(newimageH);
        heart = new JLabel(iconHeart);
        heart.setIcon(iconHeart);
        add(heart);

        ImageIcon iconClub = new ImageIcon("club.jpg");
        Image imageC = iconClub.getImage();
        Image newimageC = imageC.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconClub = new ImageIcon(newimageC);
        club = new JLabel(iconClub);
        club.setIcon(iconClub);
        add(club);*/

        labelHeart = new JTextField();
        add(labelHeart);
        wynik = new JLabel(":)");
        add(wynik);
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel northLabel = new JLabel(new ImageIcon("heart.jpg"));
        JLabel southLabel = new JLabel(new ImageIcon("club.jpg"));
        JLabel eastLabel = new JLabel(new ImageIcon("spade.jpg"));
        JLabel westLabel = new JLabel(new ImageIcon("diamond.jpg"));
        northLabel.setPreferredSize(new Dimension(200, 200));
        southLabel.setPreferredSize(new Dimension(200, 200));
        eastLabel.setPreferredSize(new Dimension(200, 200));
        westLabel.setPreferredSize(new Dimension(200, 200));
        add(northLabel, BorderLayout.NORTH);
        add(southLabel, BorderLayout.SOUTH);
        add(eastLabel, BorderLayout.EAST);
        add(westLabel, BorderLayout.WEST);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);
        Menu menu = new Menu("Plik");
        MenuItem mi = new MenuItem("Zamknij", new MenuShortcut('1'));
        menu.add(mi);
        menu.addActionListener(this);
        menuBar.add(menu);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (label.equals("Punkty")) {
            try {
                String argumentString = argument.getText();//tutaj zmienic argumenty
                int result = countingPoints(argumentString);          //wejscie to wynik funkcji
                String resultString = Integer.toString(result);
                JOptionPane.showMessageDialog(null, resultString);
                //wynik.setText(resultString);
            } catch (NumberFormatException ev) {
                System.out.println("Blad argumentow! Wpisz poprawne wartosci!");
            }
        } else if (label.equals("Zamknij")) {
            System.exit(0);
        } else if (label.equals("Losuj")) {//czyta nazwe przycisku
            Talia talia = new Talia();
            List<Card> random = talia.random();
            String card;
            card = talia.toCountPoint(random);
            argument.setText(card);
            String hearts = talia.hearts(card, 2);
            labelHeart.setText(hearts);
            //labelHeart.repaint();
        }
    }


    public static void main(String[] args) throws IOException {
        new CardStrength();
    }
}

