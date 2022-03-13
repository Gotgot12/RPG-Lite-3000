import java.util.Random;
import java.util.Scanner;

public class Game extends InputParser {
    Scanner scanner = new Scanner(System.in);

    protected static String[] heroes = new String[1];
    int playerTurn;

    public static void main(String[] args) throws Exception {
        heroes[0] = StartGame();
        Hunter hero1 = new Hunter(1, 5, 1, 2, 3);
        playGame(hero1);
    }

    public static void playGame(Hero hero) {
        while (hero.getLifePoints() > 0) {
            Enemy enemy = generateCombat();
            Random random = new Random();
            int nb = random.nextInt(2);
            while (enemy.getLifePoints() > 0 && hero.getLifePoints() > 0) {
                combat(enemy, hero, nb);
            }
            if (hero.getLifePoints() > 0) {
                winCombat(hero);
            }
        }
        if (hero.getLifePoints() <= 0) {
            System.out.println("Perdu");
        }
    }

    public static Enemy generateCombat() {
        System.out.println("-------------------");
        System.out.println("Vous entrez en combat !");
        Random random = new Random();
        int nombre1 = random.nextInt(3) + 1;
        int nombre2 = random.nextInt(3) + 1;

        BasicEnemy enemy = new BasicEnemy(nombre1, nombre2);
        System.out.println("L'ennemi a " + nombre1 + " points de vie et " + nombre2 + " dégats");

        return enemy;
    }

    public static void combat(Enemy enemy, Hero hero, int nb) {

        if (nb == 0) {
            CombatChoice(enemy, hero);
            if (enemy.getLifePoints() > 0) {
                Enemy.attackofEnemy(enemy, hero);
            }
        } else {
            Enemy.attackofEnemy(enemy, hero);
            if (hero.getLifePoints() > 0) {
                CombatChoice(enemy, hero);
            }

        }
    }

    public static void winCombat(Hero hero) {
        System.out.println("Bravo vous avez gagné votre combat !");
        WinChoice(hero);
    }

}