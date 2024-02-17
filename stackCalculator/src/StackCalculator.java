import java.util.Stack;

public class StackCalculator {
    Stack calculator;
    String command = "start";

    public StackCalculator() {
        calculator = new Stack();
    }
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Stack Calculator");
        System.out.println();
    }
    public void displayCommands() {
        System.out.println("Commands: push n, add, sub, mult, div, list, clear, or quit.");
    }
    public void push(double n) {
        calculator.push(n);
    }
    public double pop() {
        return (double) calculator.pop();
    }
    public int size() {
        return calculator.size();
    }
    public Object[] getValues() {
        return calculator.toArray();
    }
    public void listStack() {
        if(calculator.empty()) {
            System.out.println("empty");
        }
        else {
            for (Object val : calculator.toArray()) {
                System.out.println(val);
            }
        }
    }
    public void clearStack() {
        calculator.clear();
    }

    public boolean empty() {
        return calculator.empty();
    }
}
