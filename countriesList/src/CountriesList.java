import java.util.*;

public class CountriesList {
    Scanner input;
    CountriesList () {
        this.input = new Scanner(System.in);
    }
    List<String> countries = new ArrayList<>();
    String menuOption = "";

    void displayWelcomeMessage() {
        System.out.println("Country List Manager\n");
    }
    void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("1 - List countries");
        System.out.println("2 - Add a country");
        System.out.println("3 - Exit\n");
    }
    void getMenuOption () {
        System.out.print("Enter menu number:  ");
        try {
            menuOption = input.nextLine();
            if (Integer.parseInt(menuOption) > 3 || Integer.parseInt(menuOption) < 1) {
                throw new Exception("not a valid option");
            }
        } catch (Exception ignore) {
            System.out.println("try again");
            menuOption = "";
        }
    }
    boolean checkForCountry(String country) {
        return countries.contains(country);
    }
    void addCountry() {
        String country;
        System.out.print("Enter country:  ");
        country = input.nextLine();
        if (checkForCountry(country)) {
            System.out.printf("Country %s already exists in list.\n", country);
        }
        else {
            countries.add(country);
            System.out.printf("Country %s has been added.\n", country);
        }
    }
    void listCountries() {
        if (countries.isEmpty()) {
            System.out.println("No countries in the list.\n");
        }
        else {
            Collections.sort(countries);
            for (String country : countries) {
                System.out.println(country);
            }
            System.out.println();
        }
    }
}
