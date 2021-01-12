package com.lab03.fairytale.attractions;

import java.util.Random;

public enum ActionType {
    KRUT("крутятся"),
    KACH("качаются"),
    SHAT("шатаются"),
    JUMP("прыгают");

    public final String label;

    public static ActionType getRandomAction() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    ActionType(String label){
        this.label = label;
    }
}
