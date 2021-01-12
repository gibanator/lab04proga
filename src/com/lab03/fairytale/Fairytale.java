package com.lab03.fairytale;

import com.lab03.fairytale.exceptions.ZeroTables;

import java.util.Scanner;

public class Fairytale {
    public static void main(String[] args) throws ZeroTables {
        System.out.println("Введите через пробел желаемое количество столов, и через пробел желаемое количество аттракционов, кроме 0.");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String arguments[] = line.split("\\s");
        int tables = Integer.parseInt(arguments[0]);
        int attractions = Integer.parseInt(arguments[1]);
        if (tables == 0 || attractions == 0)
            throw new ZeroTables();
        Action.generate(tables, attractions);
    }
}
