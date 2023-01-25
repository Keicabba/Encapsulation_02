package it.figuccia;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Tester {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("Enter name: ");
        person.setName(scanner.nextLine());

        System.out.print("Enter surname: ");
        person.setSurname(scanner.nextLine());

        /*
        System.out.print("Enter height: ");
        person.setHeight (scanner.nextDouble());
        scanner.nextLine();
        */
        //to elude not double input error
        int attempt = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter height: ");
            String heightInput = scanner.nextLine();
            try {
                person.setHeight(Double.parseDouble(heightInput.replace(',', '.')));
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid height value. Please enter a valid number.");
                attempt++;
                if (attempt == 5) {
                    System.out.println("Too many attempt, exiting...");
                    return;
                }
            }
        }
        /*
        System.out.print("Enter age: ");
        person.setAge(scanner.nextInt());
        */
        //to elude not int error
        attempt = 0;
        isValid = false;
        while (!isValid && attempt < 5) {
            System.out.print("Enter age: ");
            String ageInput = scanner.nextLine();
            try {
                person.setAge(Integer.parseInt(ageInput));
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age value. Please enter a valid number.");
                attempt++;
                if (attempt == 5) {
                    System.out.println("Too many attempt, exiting...");
                    return;
                }
            }
        }
        System.out.printf("Person details: %nName: %s %nSurname: %s %nHeight: %s %nAge: %d%n",
                person.getName(), person.getSurname(), df.format(person.getHeight()), person.getAge());
    }
}