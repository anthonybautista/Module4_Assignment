package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static PaintCalculator paintCalculator;
    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        paintCalculator = new PaintCalculator();
        boolean play = true;

        do {
            printMenu();
            switch (input.nextInt()){
                case 1: createRoom();
                        break;
                case 2: System.out.println(paintCalculator.toString());
                        break;
                case 3: readFile();
                        break;
                case 4: writeFile();
                        break;
                case 5: play = false;
                        System.out.println("Program ending...");
                        break;
                default: System.out.println("Invalid entry.");
            }

        } while (play);

    }

    private static void printMenu() {
        System.out.println("""
                1. Add room
                2. View room(s)
                3. Read room(s) from file
                4. Write room(s) to file
                5. Exit program""");
    }

    private static double promptForDimension(String dimensionName) {
        double response = 0.0;
        Scanner keyboard = new Scanner(System.in);
        do {
            try {
                System.out.printf("Please enter %s: ", dimensionName);
                response = Double.parseDouble(keyboard.nextLine());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid number entered");
            }
        } while (response == 0.0);

        return response;
    }

    private static void createRoom() {
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintCalculator.addRoom(width, length, height);
        System.out.println("Room added!\n");
    }

    private static void readFile() {
        try (FileInputStream fis = new FileInputStream("rooms.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            paintCalculator = (PaintCalculator) ois.readObject();
            System.out.println("Read successful!");
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("File could not be opened.");
        }
    }

    private static void writeFile() {
        try (FileOutputStream fos = new FileOutputStream("rooms.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
            System.out.println("Write successful!");
        } catch (IOException ioe) {
            System.out.println("File could not be written.");
        }
    }
}
