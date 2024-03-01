package org.UserRegistration.view;

import java.util.Scanner;

public abstract class InputView {
    public static String UserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Введите данные через пробел:
                Фамилию, Имя, Отчество,
                Дату рождения (в формате dd.mm.yyyy),
                Номер телефона (целое беззнаковое число без форматирования),
                Пол (символ латиницей f или m)""");
        return sc.nextLine();
    }
}
