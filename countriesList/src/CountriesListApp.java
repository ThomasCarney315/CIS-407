
public class CountriesListApp {
    public static void main(String[]args) {
        CountriesList list = new CountriesList();
        int option = 0;
        list.displayWelcomeMessage();

        while (option != 3) {
            option = list.getMenuOption();
            if (option == 1) {
                //list countries
                System.out.println("list is empty");
            }
            if (option == 2) {
                //add country
                continue;
            }
            if (option == 3) {
                System.out.println("Goodbye.");
            }
        }
        list.input.close();
    }
}
