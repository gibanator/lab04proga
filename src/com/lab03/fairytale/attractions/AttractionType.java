package com.lab03.fairytale.attractions;

import java.util.Random;

public enum AttractionType {
    SWING("качель"),
    SPIRAL("спиральный спуск"),
    HORSE("прыгающая лошадка"),
    BICYCLE("летающий велосипед"),
    WHEEL("чертово колесо");

    public final String label;

    public static AttractionType getRandomName() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    AttractionType(String label){
        this.label = label;
    }
}