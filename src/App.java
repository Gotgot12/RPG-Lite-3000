import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, World!");
        String HeroesChoice = HeroesChoice(scanner);
        while (HeroesChoice == "False") {
            HeroesChoice = HeroesChoice(scanner);
        }
        scanner.close();
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
