package com.company;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Talia {
    public String hearts(String card, int index) {
        String[] colors = card.split("[SHDC]");
        String heart = colors[index];
        return heart;
    }

    public List<Card> getAll() {
        List<Card> cardList = new ArrayList<>();
        for (ColorCard color : ColorCard.values()) {
            for (Figure figure : Figure.values()) {
                Card card = new Card(color, figure);
                cardList.add(card);
            }
        }
        return cardList;
    }

    public List<Card> random() {
        Random random = new Random();
        List<Card> all = getAll();//cała talia
        List<Card> sequence = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            int los = random.nextInt(all.size() - 1);
            Card card = all.get(los);
            sequence.add(card);
            all.remove(los);
        }
        return sequence;
    }

    public String toCountPoint(List<Card> sequence) {
        List<Card> hearts = new ArrayList<>();
        List<Card> club = new ArrayList<>();
        List<Card> spades = new ArrayList<>();
        List<Card> diamond = new ArrayList<>();
        for (Card card : sequence) {
            if (card.getColor().equals(ColorCard.HEART)) {
                hearts.add(card);
            } else if (card.getColor().equals(ColorCard.CLUB)) {
                club.add(card);
            } else if (card.getColor().equals(ColorCard.SPADES)) {
                spades.add(card);
            } else if (card.getColor().equals(ColorCard.DIAMOND)) {
                diamond.add(card);
            }
        }
        String stringSequence = "S";
        for (Card card : spades) {
            stringSequence = stringSequence + card.getFigure().getFigure();
        }
        stringSequence += "H";
        for (Card card : hearts) {
            stringSequence = stringSequence + card.getFigure().getFigure();
        }
        stringSequence += "D";
        for (Card card : diamond) {
            stringSequence = stringSequence + card.getFigure().getFigure();
        }
        stringSequence += "C";
        for (Card card : club) {
            stringSequence = stringSequence + card.getFigure().getFigure();
        }
        return stringSequence;
    }
}
