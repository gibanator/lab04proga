package com.lab03.fairytale.person;
import java.util.Random;

public class Neznaika extends Person{

    public Neznaika(){
        super("Незнайка", "male");
    }

    public void NeznaikaGoes(){
        class Street{
            private int width_of_street;
            private int height_of_houses;

            public Street(){
                width_of_street = 5;
                height_of_houses = 3;
            }

            public void addMeasures(int a, int b){
                width_of_street+=a;
                height_of_houses+=b;
                System.out.println("Улица расширилась на " + a + " метров и высота домов - на " + b + " метров.");
            }

            public int getHeight() {
                return height_of_houses;
            }

            public int getWidth() {
                return width_of_street;
            }
        }
        Street s = new Street();
        System.out.println("Незнайка идет по улице шириной 5 метров и высотой домов 3 метра.");
        Random random = new Random();
        int num_of_steps = random.nextInt(12) + 5;


        for (int i = 0; i < num_of_steps; i++){
            System.out.println("Незнайка чуть-чуть прошел.\nМагазины стали наряднее, а рекламы - ярче.");
            int plus_height = random.nextInt(3);
            int plus_width = random.nextInt(2);
            s.addMeasures(plus_width, plus_height);
        }
        System.out.println("На конец пути Незнайки ширина улицы составила " +  s.getWidth() + " метров, а высота домов - " + s.getHeight() + " метров.");
    }
}
