package com.lab03.fairytale.exceptions;

public class TableIsFull extends Exception{
    public String toString()
    {
        return "Ошибка. Больше нет места за этим столом.";
    }
}
