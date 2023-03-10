package com.company;

public enum ColorCard {
    SPADES("S"),
    CLUB("C"),
    HEART("H"),
    DIAMOND("D");

    ColorCard(String color) {
        this.color = color;
    }

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
