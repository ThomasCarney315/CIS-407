
public class CountriesListApp {
    public static void main(String[]args) {
        CountriesList list = new CountriesList();
        list.displayWelcomeMessage();
        list.displayMenu();
        while (!list.menuOption.equals("3")) {
            list.getMenuOption();
            switch(list.menuOption) {
                case "1":
                    list.listCountries();
                    break;
                case "2":
                    list.addCountry();
                    break;
                case "3":
                    System.out.println("Goodbye.");
                    break;
            }
        }
        list.input.close();
    }
}
