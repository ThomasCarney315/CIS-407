import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesList {
    Scanner input = new Scanner(System.in);
    List<String> countries = new ArrayList<>();
    String menuOption;

    void displayWelcomeMessage() {
        System.out.println("Country List Manager\n");
    }
    void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("1 - List countries");
        System.out.println("2 - Add a country");
        System.out.println("3 - Exit");
    }
    int getMenuOption () {
        System.out.print("Enter menu number:  ");
        String option = "";

        try {
            option = input.nextLine();
            if (Integer.parseInt(option) > 3 || Integer.parseInt(option) < 1) {
                throw new Exception("not a valid option");
            }
        } catch (Exception ignore) {
            System.out.println("try again");
            return 0;
        }
        return Integer.parseInt(option);
    }
    void checkForCountry() {

    }
    void addCountry() {

    }
    void listCountries() {

    }
}
