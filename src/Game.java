import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
    Scanner scanner = new Scanner(System.in);

    protected static String[] heroes = new String[1];
    int playerTurn;

    public static void main(String[] args) throws Exception {
        // heroes[0] = InputParser.StartGame();
        // Hunter hero1 = new Hunter(1, 5, 1, 2, 3);
        // playGame(hero1);
    }

    public static void playGame(Stage stage, ArrayList<Text> infoHeroText,
            StackPane MonsterStackPane, Hero hero,
            Button attack, Button defend,
            Button potion) {
        StackPane stackPaneInfoMonster = new StackPane();
        VBox vBoxInfoMonster = new VBox();
        Enemy enemy = generateEnemy(MonsterStackPane);

        ArrayList<Text> infoEnemyText = Screen.showInfoMonster(enemy);

        vBoxInfoMonster.getChildren().addAll(infoEnemyText.get(0), infoEnemyText.get(1));
        vBoxInfoMonster.setAlignment(Pos.CENTER);
        stackPaneInfoMonster.getChildren().add(vBoxInfoMonster);

        MonsterStackPane.getChildren().add(stackPaneInfoMonster);
        Random random = new Random();
        int nb = random.nextInt(2);
        combat(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, nb, attack, defend, potion);
    }

    public static Enemy generateEnemy(StackPane MonsterStackPane) {
        System.out.println("-------------------");
        System.out.println("Vous entrez en combat !");
        Random random = new Random();
        int lifePointMonster = random.nextInt(3) + 1;
        int damageMonster = random.nextInt(2) + 1;

        BasicEnemy enemy = new BasicEnemy(lifePointMonster, damageMonster);
        System.out.println("L'ennemi a " + lifePointMonster + " points de vie et " + damageMonster + " dégats");

        return enemy;
    }

    public static void combat(Stage stage, ArrayList<Text> infoHeroText, ArrayList<Text> infoEnemyText,
            StackPane MonsterStackPane, Enemy enemy,
            Hero hero, int nb, Button attack,
            Button defend,
            Button potion) {
        System.out.println("--------------------------------------------------");
        if (nb == 0) {
            Screen.CombatChoice(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, attack, defend,
                    potion);
            if (enemy.getLifePoints() > 0) {
                Enemy.attackofEnemy(infoHeroText, enemy, hero);
                if (hero.getLifePoints() <= 0) {
                    System.out.println("Perdu");
                    stage.close();
                    Screen.gameOver();
                }

            }
        } else {
            Enemy.attackofEnemy(infoHeroText, enemy, hero);
            if (hero.getLifePoints() > 0) {
                Screen.CombatChoice(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, attack, defend,
                        potion);
            } else {
                System.out.println("Perdu");
                stage.close();
                Screen.gameOver();

            }

        }
    }

    // public static void winCombat(Hero hero) {
    // System.out.println("Bravo vous avez gagné votre combat !");
    // InputParser.WinChoice(hero);
    // }

    public static void newRound(Stage stage, ArrayList<Text> infoHeroText, ArrayList<Text> infoEnemyText,
            StackPane MonsterStackPane, Enemy enemy,
            Hero hero, int nb, Button attack,
            Button defend,
            Button potion) {
        if (hero.getLifePoints() <= 0) {
            System.out.println("Perdu");
            stage.close();
            Screen.gameOver();

        }
        if (hero.getLifePoints() > 0) {
            if (enemy.getLifePoints() > 0) {
                combat(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, nb, attack, defend, potion);
            } else {
                Screen.winCombat(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, nb, attack, defend,
                        potion);
            }
        }

    }
}