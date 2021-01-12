package com.lab03.fairytale.environment;

import java.util.Objects;

public class Table extends EnvironmentEntity implements TableEaters{
    private final int NumOfChairs;
    private final int number;
    private int numberOfEaters;

    public Table(int Number, int chairs){
        super("Стол");
        this.number = Number;
        this.NumOfChairs = chairs;
        numberOfEaters = 0;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public void addEaters(int i){
        numberOfEaters += i;
    }
    @Override
    public void minusEaters(int i){
        numberOfEaters -= i;
    }

    public boolean checkIfAvailable(){
        if (numberOfEaters == NumOfChairs)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        return String.format("Сгенерирован стол с " + NumOfChairs + " стульями под номером " + number + ".");
    }
    @Override
    public int hashCode() {
        return Objects.hash(NumOfChairs, number);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table t = (Table) o;
        return (number == t.number) && (NumOfChairs == t.NumOfChairs);
    }
}
