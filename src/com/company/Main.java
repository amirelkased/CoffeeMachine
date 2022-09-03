package com.company;

import java.util.Scanner;

public class Main {
    // TODO: terminate program when type "exit" else always runner.  -> DONE
    // TODO: when user input "remaining" out all resources.          -> DONE
    // TODO: when user input "back" rewrite all resources.           -> DONE
    static Scanner scanner = new Scanner(System.in);
    static Machine Main = new Machine();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String ope = scanner.nextLine();
            switch (ope) {
                case "buy" -> buy();
                case "fill" -> fill();
                case "take" -> System.out.printf("I gave you $%d%n", Main.takeBalance());
                case "remaining" -> Main.displayStatics();
                case "exit" -> {
                    return;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int disposableCup = scanner.nextInt();
        Main.fillMachine(water, milk, coffeeBeans, disposableCup);
    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String check;
        if (scanner.hasNextLine()) {
            check = scanner.nextLine();
        } else {
            check = Integer.toString(scanner.nextInt());
        }
        switch (check) {
            case "1" -> Main.checkBeforeBuy("espresso");
            case "2" -> Main.checkBeforeBuy("latte");
            case "3" -> Main.checkBeforeBuy("cappuccino");
            case "back" -> {
            }
            default -> {

            }
        }
    }
}

