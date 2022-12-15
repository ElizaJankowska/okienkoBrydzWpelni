package com.company;

public enum Figure {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JOPEK("J"),
    QUEEN("Q"),
    KING("K"),
    AS("A");

    private String figure;

    Figure(String figure) {
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
