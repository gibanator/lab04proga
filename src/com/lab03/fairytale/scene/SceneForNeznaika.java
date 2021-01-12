package com.lab03.fairytale.scene;
import java.util.Random;

public class SceneForNeznaika {
    private int num_of_lamps;

    public SceneForNeznaika(){
        Random random = new Random();
        int n = random.nextInt(20) + 15;
        num_of_lamps = n;
        System.out.println("Наступил вечер. Зажглось " + num_of_lamps + " фонарей.\nЗажглись витрины магазинов и рекламы.");
    }
}
