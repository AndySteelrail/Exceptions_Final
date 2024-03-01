package org.UserRegistration.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Contact {
    private String surname;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private long phoneNumber;
    private String gender;

    public Contact(String input) {
        try {
            String[] inputData = splitInput(input);

            surname = Validator.getName(inputData[0]);
            firstName = Validator.getName(inputData[1]);
            lastName = Validator.getName(inputData[2]);
            dateOfBirth = Validator.getDate(inputData[3]);
            phoneNumber = Validator.getPhoneNumber(inputData[4]);
            gender = Validator.getGender(inputData[5]);

            createContact();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String[] splitInput (String input) throws Exception {
        String[] inputData = input.split(" ");
        if (inputData.length != 6) {
            throw new Exception(
                    "Введено неверное количество данных. " +
                            "Пожалуйста, введите именно 6 значений!");
        }
        return inputData;
    }

    private void createContact() {
        String fileName = surname + ".txt";

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(
                        "src/main/java/org/UserRegistration/contacts/" +
                                fileName,
                        true))) {
            String output =
                    surname + " " +
                    firstName + " " +
                    lastName + " " +
                    dateOfBirth + " " +
                    phoneNumber + " " +
                    gender + "\n";
            writer.write(output);
            System.out.println("Данные записаны в файл: /contacts/" + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
