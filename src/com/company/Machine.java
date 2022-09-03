package com.company;

public class Machine {
    private int balance;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;

    //    enum Event{}
    public Machine() {
        this.balance = 550;
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
    }

    /**
     * this method check which it has resource for the order or not.
     *
     * @param type which order
     */
    protected void checkBeforeBuy(String type) {
        switch (type) {
            case "espresso" -> {
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.disposableCups == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    espresso();
                    System.out.println("I have enough resources, making you a coffee!");
                }
            }
            case "latte" -> {
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.disposableCups == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    latte();
                    System.out.println("I have enough resources, making you a coffee!");
                }
            }
            case "cappuccino" -> {
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.disposableCups == 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    cappuccino();
                    System.out.println("I have enough resources, making you a coffee!");
                }
            }
            default -> {
            }
        }
    }

    /**
     * For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans.
     * It costs $4.
     */
    private void espresso() {
        this.water -= 250;
        this.coffeeBeans -= 16;
        this.balance += 4;
        --this.disposableCups;
    }

    /**
     * For the latte, the coffee machine needs 350 ml of water,
     * 75 ml of milk, and 20 g of coffee beans.
     * It costs $7.
     */
    private void latte() {
        this.water -= 350;
        this.milk -= 75;
        this.coffeeBeans -= 20;
        this.balance += 7;
        --this.disposableCups;
    }

    /**
     * for the cappuccino, the coffee machine needs 200 ml of water,
     * 100 ml of milk, and 12 g of coffee beans.
     * It costs $6.
     */
    private void cappuccino() {
        this.water -= 200;
        this.milk -= 100;
        this.coffeeBeans -= 12;
        this.balance += 6;
        --this.disposableCups;
    }

    /**
     * This is for print status iof machine
     */
    protected void displayStatics() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, water, milk, coffeeBeans, disposableCups, balance);
    }


    /**
     * to charge machine by increase utilizes
     *
     * @param water          increase water
     * @param milk           increase milk
     * @param coffeeBeans    increase coffee beans
     * @param disposableCups increase disposable cups
     */
    protected void fillMachine(int water, int milk, int coffeeBeans, int disposableCups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.disposableCups += disposableCups;
    }

    /**
     * give all the money that it earned from selling coffee to owner.
     *
     * @return All money
     */
    protected int takeBalance() {
        int res = this.balance;
        this.balance = 0;
        return res;
    }

}
