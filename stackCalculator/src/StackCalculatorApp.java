import java.util.Scanner;

public class StackCalculatorApp {
    public static void main(String[] args) {
        StackCalculator calc = new StackCalculator();
        calc.displayWelcomeMessage();
        calc.displayCommands();
        Scanner input = new Scanner(System.in);
        while(!calc.command.equalsIgnoreCase("quit")) {
            System.out.print("\nstack>  ");
            calc.command = input.nextLine().toLowerCase();
            if (calc.command.equalsIgnoreCase("quit")) {
                break;
            }
            if (calc.command.toLowerCase().startsWith("push ")) {
                String[] n = calc.command.split(" ");
                String s;
                double num;
                try {
                    s = n[1];
                    num = Double.parseDouble(s);
                    calc.push(num);
                    calc.listStack();
                }
                catch (Exception e) {
                    System.out.println("Unrecognized command.");
                }
            }
            else {
                double n1;
                double n2;
                try {
                    switch (calc.command) {
                        case "add":
                            n1 = calc.pop();
                            n2 = calc.pop();
                            calc.push(n1 + n2);
                            calc.listStack();
                            break;
                        case "sub":
                            n1 = calc.pop();
                            n2 = calc.pop();
                            calc.push(n1 - n2);
                            calc.listStack();
                            break;
                        case "mult":
                            n1 = calc.pop();
                            n2 = calc.pop();
                            calc.push(n1 * n2);
                            calc.listStack();
                            break;
                        case "div":
                            n1 = calc.pop();
                            n2 = calc.pop();
                            calc.push(n2 / n1);
                            calc.listStack();
                            break;
                        case "clear":
                            calc.clearStack();
                            calc.listStack();
                            break;
                        case "list":
                            if(calc.empty()) {
                                System.out.println("empty");
                            }
                            else {
                                for (Object val : calc.getValues()) {
                                    System.out.println(val);
                                }
                            }
                            break;
                        default:
                            System.out.println("Unrecognized command.");
                    }
                } catch (Exception e) {
                    System.out.println("must be more than one in stack");
                }
            }
        }
        System.out.println("\nThanks for using the Stack Calculator.");
        input.close();
    }
}
