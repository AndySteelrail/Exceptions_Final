package org.UserRegistration.model;

import java.time.LocalDate;

public abstract class Validator {
    public static String getName(String input) throws Exception {
        if (!input.matches("^[a-zA-Zа-яА-ЯёЁ0-9]*$")) {
            throw new Exception(
                    "Неверный формат имени/фамилии. Используйте только буквенно-цифровые символы");
        }
        return input;
    }
    public static LocalDate getDate(String input) throws Exception {
        String[] inputData = input.split("\\D");

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(inputData[2]);
            sb.append("-");
            sb.append(inputData[1]);
            sb.append("-");
            sb.append(inputData[0]);

            return LocalDate.parse(sb);
        } catch (Exception e) {
            throw new Exception(
                    "Неверный формат даты рождения. Введите в формате dd.mm.yyyy!");
        }
    }

    public static long getPhoneNumber(String input) throws Exception {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new Exception(
                    "Неверный формат номера телефона. Вводите только цифры!");
        }
    }

    public static String getGender(String input) throws Exception  {
        if (!input.equals("f") && !input.equals("m")) {
            throw new Exception(
                    "Неверный формат пола. Введите символ латиницей f или m!");
        }
        return input;
    }
}
