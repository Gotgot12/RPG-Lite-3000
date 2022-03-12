import java.util.Scanner;

public class InputParser {
    public static String StartGame() {

        Scanner scanner = new Scanner(System.in);
        String HeroesChoice = HeroesChoice(scanner);
        while (HeroesChoice == "False") {
            HeroesChoice = HeroesChoice(scanner);
        }
        return HeroesChoice;
    }

    public static String HeroesChoice(Scanner scanner) {
        System.out.println("Quelle classe veux-tu choisir (Hunter, Warrior, Mage, Healer)? ");
        String HeroesClass = scanner.nextLine();

        if (HeroesClass.equals("Hunter") || HeroesClass.equals("Warrior") || HeroesClass.equals("Mage")
                || HeroesClass.equals("Healer")) {
            return HeroesClass;
        } else {
            return "False";
        }
    }

}
