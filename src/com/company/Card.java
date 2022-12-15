package com.company;

public class Card {
    private ColorCard color;
    private Figure figure;

    public Card(ColorCard color, Figure figure) {
        this.color = color;
        this.figure = figure;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public ColorCard getColor() {
        return color;
    }

    public void setColor(ColorCard color) {
        this.color = color;
    }
}
