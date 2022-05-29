import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.text.Text;

public class InputParser {
    // public static String StartGame() {
    // Scanner scanner = new Scanner(System.in);
    // String HeroesChoice = HeroesChoice(scanner);
    // while (HeroesChoice == "False") {
    // HeroesChoice = HeroesChoice(scanner);
    // }
    // return HeroesChoice;
    // }

    // public static String HeroesChoice(Scanner scanner) {
    // System.out.println("Quelle classe veux-tu choisir (Hunter, Warrior, Mage,
    // Healer)? ");
    // String HeroesClass = scanner.nextLine();

    // if (HeroesClass.equals("Hunter") || HeroesClass.equals("Warrior") ||
    // HeroesClass.equals("Mage")
    // || HeroesClass.equals("Healer")) {
    // return HeroesClass;
    // } else {
    // return "False";
    // }
    // }

    // public static void CombatChoice(ArrayList<Text> infoEnemyText,
    // ArrayList<Text> infoHeroText, Enemy enemy,
    // Hero hero) {
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Vous avez " + hero.getArrow() + " flèches.");
    // System.out.println("Vous avez " + hero.getPotion() + " potions.");
    // System.out.println("A = attaquer, D = défendre, P = potion");
    // String action = scanner.nextLine();
    // if (action.equals("A")) {
    // Hero.attack(infoEnemyText, infoHeroText, enemy, hero);
    // }
    // // else if (action.equals("D")) {

    // // }
    // else if (action.equals("P")) {
    // Hero.useConsumable(hero, hero.getPotion());
    // }

    // }

    public static void WinChoice(Hero hero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vous avez le droit a un bonus ! Choissisez ;)");
        System.out.println(
                "A = augmenter son armure de 1, D = augmenter les dégats de son arme de 1, E = augmenter l'efficacité de la potion et de la nourriture de 1, N = augmenter le nombre de potions ou de nourriture de 1, F = augmenter le nombre de flèches de 1");
        System.out.println(
                "Vous avez dans votre sac à dos : " + hero.getArrow() + " flèches et " + hero.getPotion()
                        + " potions.");
        String win = scanner.nextLine();

        if (win.equals("A")) {
            hero.setArmor(hero.getArmor() + 1);
        } else if (win.equals("D")) {
            hero.setWeaponDammage(hero.getWeaponDamage() + 1);
        } else if (win.equals("E")) {
            hero.efficacite += 1;
        } else if (win.equals("N")) {
            hero.setPotion(hero.getPotion() + 1);
        } else if (win.equals("F")) {
            hero.setArrow(hero.getArrow() + 1);
        }
    }

}
