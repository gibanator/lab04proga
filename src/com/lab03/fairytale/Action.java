package com.lab03.fairytale;
import com.lab03.fairytale.environment.*;
import com.lab03.fairytale.interactions.WaiterClientInteraction;
import com.lab03.fairytale.person.*;
import com.lab03.fairytale.attractions.*;
import com.lab03.fairytale.scene.SceneForNeznaika;

import java.util.Arrays;
import java.util.Random;

public class Action {
    private static Waiter[] waiters;
    private static Eater[] eaters;
    private static Eater[] eaters_that_want_food;
    private static Table[] tables;

    public static void addWaiter(Waiter w){
        Waiter[] newarray = Arrays.copyOf(waiters, waiters.length+1);
        newarray[newarray.length - 1] = w;
        waiters = newarray;
    }
    public static void addEater(Eater e) {
        if (e.getIfWants() == false) {
            Eater[] newarray = Arrays.copyOf(eaters, eaters.length + 1);
            newarray[newarray.length - 1] = e;
            eaters = newarray;
        }
        else{
            Eater[] newarray = Arrays.copyOf(eaters_that_want_food, eaters_that_want_food.length + 1);
            newarray[newarray.length - 1] = e;
            eaters_that_want_food = newarray;
        }
    }

    public static void addTable(Table t){
        Table[] newarray = Arrays.copyOf(tables, tables.length+1);
        newarray[newarray.length - 1] = t;
        tables = newarray;
    }
    public static void generate(int t, int attr){
        tables = new Table[0];
        eaters = new Eater[0];
        waiters = new Waiter[0];
        eaters_that_want_food = new Eater[0];
        Random random = new Random();
        int i;
        int k;
        int o = 0;

        SceneForNeznaika scene = new SceneForNeznaika();
        System.out.println("\n");

        Neznaika nnn = new Neznaika();
        nnn.NeznaikaGoes();
        System.out.println("\n\n");

        for (i = 0; i < attr; i++) {
            Attraction a1 = new Attraction(AttractionType.getRandomName());
            o += a1.getVisitors();
        }
        System.out.println("Всего желающих покататься на аттракционах - " + o);
        CreateAttraction BigWheel = new CreateAttraction(){
            @Override
            public void CreateMessage() {
                System.out.println("Также создано ОГРОМНОЕ чертово колесо");
            }
        };
        BigWheel.CreateMessage();
        System.out.println("\n\n");

        int distorted = random.nextInt(4) + 1;
        int dancers = random.nextInt(4) + 1;
        System.out.println("Сгенерировано " + distorted + " смотрящихся в кривые зеркала.");
        for (i = 0; i < distorted; i++){
            Wanderer w = new Wanderer();
            System.out.println(w.toString());
        }
        System.out.println("\n");

        System.out.println("Сгенерировано " + dancers + " танцующих.");
        for (i = 0; i < dancers; i++) {
            Dancer d = new Dancer();
            System.out.println(d.toString());
        }
        System.out.println("\nА пока они развлекаются, другие едят: \n");

        for (i = 0; i < t; i++) {
            int n = random.nextInt(3) + 2;
            Waiter w = new Waiter();
            addWaiter(w);
            System.out.println(w.toString());
            Table table = new Table(i, n);
            addTable(table);
            System.out.println(table.toString());
            for (k = 0; k < n; k++){
                Eater e = new Eater();
                e.setTable(table);
                addEater(e);
                table.addEaters(1);
                System.out.println(e.toString());
            }
            System.out.println("\n");
        }

        while (eaters.length != 0){
            for (i = 0; i < waiters.length; i++) {
                int x = random.nextInt(4);
                if (x == 1) {
                    int b = random.nextInt(tables.length);
                    if (tables[b].checkIfAvailable()) {
                        Eater e = new Eater();
                        tables[b].addEaters(1);
                        e.setTable(tables[b]);
                        addEater(e);
                        System.out.println(e.toString());
                        break;
                    }
                }
                if (eaters.length == 0)
                    break;
                if (eaters_that_want_food.length != 0) {
                    int a = random.nextInt(eaters_that_want_food.length);
                    WaiterClientInteraction interaction = new WaiterClientInteraction();
                    interaction.addWaiter(waiters[i]);
                    interaction.addEater(eaters_that_want_food[a]);

                    interaction.Interaction();

                    addEater(eaters_that_want_food[a]);
                    for (; a < eaters_that_want_food.length - 1; a++) {
                        eaters_that_want_food[a] = eaters_that_want_food[a + 1];
                    }
                    Eater[] newarray = Arrays.copyOf(eaters_that_want_food, eaters_that_want_food.length - 1);
                    eaters_that_want_food = newarray;
                }
                int a;
                int n = random.nextInt(2);
                if (n == 1) {
                    a = random.nextInt(eaters.length);
                    eaters[a].getTable().minusEaters(1);
                    eaters[a].Left();
                    for (; a < eaters.length - 1; a++) {
                        eaters[a] = eaters[a + 1];
                    }

                    Eater[] newarray1 = Arrays.copyOf(eaters, eaters.length - 1);
                    eaters = newarray1;
                }

            }
        }
        System.out.println("\nВсе посетители ушли.");
    }
}
