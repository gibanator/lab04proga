package com.lab03.fairytale.exceptions;

public class ZeroTables extends Exception{
    public String toString()
    {
        return "Ошибка. Не может быть 0 столов или аттракционов.";
    }
}
