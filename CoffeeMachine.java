package machine;

import java.util.Scanner;

// Enum to represent different types of coffee
enum CoffeeType {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    final int water;
    final int milk;
    final int beans;
    final int cost;

    CoffeeType(int water, int milk, int beans, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cost = cost;
    }
}

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private int coffeesMade;
    private boolean needsCleaning;
    private final Scanner scanner;

    public CoffeeMachine() {
        // Initial state
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.coffeesMade = 0;
        this.needsCleaning = false;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWrite action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine();

            if (action.equals("exit")) {
                break;
            }

            processAction(action);
        }
    }

    private void processAction(String action) {
        switch (action) {
            case "buy":
                processBuy();
                break;
            case "fill":
                processFill();
                break;
            case "take":
                processTake();
                break;
            case "clean":
                processClean();
                break;
            case "remaining":
                printState();
                break;
            default:
                System.out.println("Invalid action.");
        }
    }

    private void processBuy() {
        if (needsCleaning) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine();

        if (choice.equals("back")) {
            return;
        }

        CoffeeType selectedCoffee;
        switch (choice) {
            case "1":
                selectedCoffee = CoffeeType.ESPRESSO;
                break;
            case "2":
                selectedCoffee = CoffeeType.LATTE;
                break;
            case "3":
                selectedCoffee = CoffeeType.CAPPUCCINO;
                break;
            default:
                System.out.println("Invalid coffee type.");
                return;
        }

        makeCoffee(selectedCoffee);
    }

    private void makeCoffee(CoffeeType coffeeType) {
        // Check resources
        if (water < coffeeType.water) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < coffeeType.milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < coffeeType.beans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        // Make coffee
        water -= coffeeType.water;
        milk -= coffeeType.milk;
        beans -= coffeeType.beans;
        cups--;
        money += coffeeType.cost;
        coffeesMade++;

        System.out.println("I have enough resources, making you a coffee!");

        // Check if cleaning is needed
        if (coffeesMade >= 10) {
            needsCleaning = true;
        }
    }

    private void processFill() {
        System.out.println("\nWrite how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
    }

    private void processTake() {
        System.out.println("\nI gave you $" + money);
        money = 0;
    }

    private void processClean() {
        if (needsCleaning) {
            needsCleaning = false;
            coffeesMade = 0;
            System.out.println("I have been cleaned!");
        } else {
            System.out.println("I don't need cleaning right now!");
        }
    }

    private void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.start();
    }
}
