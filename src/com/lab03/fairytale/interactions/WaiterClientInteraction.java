package com.lab03.fairytale.interactions;
import com.lab03.fairytale.person.*;



public class WaiterClientInteraction implements Interactions, Adders{
    private Waiter w;
    private Eater e;

    @Override
    public void addEater(Eater E){
        this.e = E;
    }
    @Override
    public void addWaiter(Waiter W){
        this.w = W;
    }
    @Override
    public void Interaction(){
        String s;
        if (w.getInfo()[1].equals("female")){
            s = "Официантка ";
        }
        else
            s = "Официант ";
        System.out.println(s + w.getInfo()[0] + " приносит клиенту " + e.getInfo()[0] + " " + e.getNameOfFood() + ".");
        e.setDoesntWant_to_eat();
    }
}
