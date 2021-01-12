package com.lab03.fairytale.person;
import com.lab03.fairytale.*;
import com.lab03.fairytale.environment.*;
import com.lab03.fairytale.exceptions.TableIsFull;

import java.util.Objects;
import java.util.Random;

public class Eater extends Person{
    private final Food meal;
    private Table table;
    private boolean wants_to_eat;

    public Eater(String Name, String Sex){
        super(Name, Sex);
        this.meal = Food.getRandomFood();
    }
    public Eater(){
        super();
        final Random random = new Random();
        this.meal = Food.getRandomFood();
        int i = random.nextInt(4);
        wants_to_eat = i != 0;
    }

    public void setTable(Table t){
        try{
            if (t.checkIfAvailable() == false) {
                throw new TableIsFull();
            }
        }
        catch(TableIsFull a){
            System.out.println("Exception: "+a.toString());
        }
        this.table = t;
    }

    public Table getTable() {
        return table;
    }

    public String getNameOfFood() {
        if (this.wants_to_eat)
            return this.meal.label;
        else
            return "ничего";
    }

    public boolean getIfWants() {
        return this.wants_to_eat;
    }

    public Food getMeal(){
        return this.meal;
    }

    public void setDoesntWant_to_eat(){
        wants_to_eat = false;
    }
    public void Left(){
        System.out.println("Посетитель " + getInfo()[0] + ", сидящий за столом с номером " + table.getNumber() + ", ушел.");
    }

    @Override
    public String toString() {
        return String.format("Сгенерирован посетитель с именем " + getInfo()[0] + ", сидящий за столом с номером " + table.getNumber() + ". Он хочет " + getNameOfFood());
    }
    @Override
    public int hashCode() {
        return Objects.hash(meal, table, wants_to_eat);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eater e = (Eater) o;
        return (meal == e.meal) && (table.equals(e.table)) && (wants_to_eat == e.wants_to_eat);
    }
}
