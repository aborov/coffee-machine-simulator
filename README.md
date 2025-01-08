# Coffee Machine Simulator

A Java application that simulates a coffee machine with various functionality. This project was created as part of a graduate Java programming course.

## Features

- Make three types of coffee:
  - Espresso (250 ml water, 16 g beans, $4)
  - Latte (350 ml water, 75 ml milk, 20 g beans, $7)
  - Cappuccino (200 ml water, 100 ml milk, 12 g beans, $6)
- Resource management:
  - Water, milk, coffee beans, and disposable cups tracking
  - Money collection and withdrawal
- Maintenance features:
  - Fill resources (water, milk, coffee beans, cups)
  - Take collected money
  - Machine cleaning required after every 10 cups
- Status checking:
  - View remaining resources
  - Monitor machine state

## Project Structure

The project consists of a main `CoffeeMachine` class and a `CoffeeType` enum:
- `CoffeeMachine.java`: Contains the main logic and user interface
- `CoffeeType`: Enum defining different types of coffee and their requirements

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE or text editor

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/yourusername/coffee-machine-simulator.git
```

2. Navigate to the project directory:
```bash
cd coffee-machine-simulator
```

3. Compile the Java files:
```bash
javac machine/CoffeeMachine.java
```

4. Run the application:
```bash
java machine.CoffeeMachine
```

## Usage

The program accepts the following commands:
- `buy`: Purchase coffee (espresso, latte, or cappuccino)
- `fill`: Add resources to the machine
- `take`: Collect money from the machine
- `clean`: Clean the machine when required
- `remaining`: Check current resource levels
- `exit`: Exit the program

## Initial State

The coffee machine starts with:
- 400 ml of water
- 540 ml of milk
- 120 g of coffee beans
- 9 disposable cups
- $550 in cash

## License

This project is licensed under the [MIT License](LICENSE) - see the LICENSE file for details.
