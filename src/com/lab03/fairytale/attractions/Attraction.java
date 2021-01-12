package com.lab03.fairytale.attractions;

import com.lab03.fairytale.Action;

import java.util.Random;

public class Attraction implements CreateAttraction{
    private AttractionType Type;
    private ActionType Action;
    private int Visitors;

    @Override
    public void CreateMessage() {
        System.out.println("Создан аттракцион типа " + Type.label + " c " + Visitors + " желающими прокатиться.\nВсе " + Visitors + " коротышек " + Action.label);
    }

    public Attraction(AttractionType type){
        Random random = new Random();
        int i = random.nextInt(700) + 200;
        this.Visitors = i;
        this.Type = type;
        this.Action = ActionType.getRandomAction();

        CreateMessage();
    }

    public int getVisitors() {
        return Visitors;
    }
}
