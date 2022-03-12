import java.util.Scanner;

public class Game extends InputParser {

    static String[] heroes = new String[1];
    int playerTurn;

    public static void main(String[] args) throws Exception {
        heroes[0] = StartGame();
        Hunter hero1 = new Hunter(1, 5, 1, 2);
        generateCombat(hero1);
    }

    public static void generateCombat(Hero hero1) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vous entrez en combat !");
        BasicEnemy enemy = new BasicEnemy(2, 1);

        while (enemy.getLifePoints() != 0) {
            System.out.println("A = attaquer, D = défendre");
            String action = scanner.nextLine();
            if (action.equals("A")) {
                System.out.println("Enemy hp : " + enemy.getLifePoints());
                System.out.println("Hero Dammage : " + hero1.getWeaponDamage());
                enemy.setLifePoints(enemy.getLifePoints() - hero1.getWeaponDamage());
                System.out.println("Enemy hp : " + enemy.getLifePoints());

            }
            // else if (action.equals("B")) {

            // }
        }

    }

}