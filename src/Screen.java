import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Screen extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        VBox stackPaneGlobal = new VBox();

        Text textePresentation = new Text("Bienvenue dans le mini RPG Lite 3000");

        Button boutonHunter = new Button("Classe Hunter");
        Button boutonWarrior = new Button("Classe Warrior");
        Button boutonMage = new Button("Classe Mage");
        Button boutonHealer = new Button("Classe Healer");

        boutonHunter.setPadding(new Insets(10));
        boutonWarrior.setPadding(new Insets(10));
        boutonMage.setPadding(new Insets(10));
        boutonHealer.setPadding(new Insets(10));

        EventHandler<ActionEvent> actionOnHunter = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello Hunter");
                Hunter hero = new Hunter(2, 5, 1, 2, 3);
                primaryStage.close();
                affichageCombat(hero, "Hunter");
            }
        };

        EventHandler<ActionEvent> actionOnWarrior = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello Warrior");
                Warrior hero = new Warrior(3, 5, 1, 2);
                primaryStage.close();
                affichageCombat(hero, "Warrior");
            }
        };

        EventHandler<ActionEvent> actionOnMage = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello Mage");
                Mage hero = new Mage(1, 5, 1, 2, 3);
                primaryStage.close();
                affichageCombat(hero, "Mage");
            }
        };

        EventHandler<ActionEvent> actionOnHealer = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello Healer");
                Healer hero = new Healer(1, 5, 1, 2, 3);
                primaryStage.close();
                affichageCombat(hero, "Healer");
            }
        };

        boutonHunter.setOnAction(actionOnHunter);
        boutonWarrior.setOnAction(actionOnWarrior);
        boutonMage.setOnAction(actionOnMage);
        boutonHealer.setOnAction(actionOnHealer);

        stackPaneGlobal.setAlignment(Pos.CENTER);
        stackPaneGlobal.setSpacing(10);

        stackPaneGlobal.getChildren().addAll(textePresentation, boutonHunter, boutonWarrior, boutonMage, boutonHealer);

        Scene scene = new Scene(stackPaneGlobal);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Choix du héros");
        primaryStage.show();
    }

    public void affichageCombat(Hero hero, String classe) {
        String imgChasseur = "img/chasseur.jpg";
        String imgWarrior = "img/warrior.jpg";
        String imgMage = "img/mage.jpg";
        String imgHealer = "img/healer.jpg";

        String imgMonster = choiceImgMonster();

        // HERO
        StackPane HeroStackPane = new StackPane();

        SplitPane splitPaneLeft = new SplitPane();
        splitPaneLeft.setOrientation(Orientation.VERTICAL);

        Label infoHeroLabel = new Label("Informations du héros");

        StackPane imageHeroStackPane = new StackPane();
        imageHeroStackPane.setStyle("-fx-border-color: black");

        try {
            FileInputStream inputStreamHero = new FileInputStream(imgChasseur);
            if (classe == "Warrior") {
                inputStreamHero = new FileInputStream(imgWarrior);
            } else if (classe == "Mage") {
                inputStreamHero = new FileInputStream(imgMage);
            } else if (classe == "Healer") {
                inputStreamHero = new FileInputStream(imgHealer);
            }

            Image imageHero = new Image(inputStreamHero);

            ImageView imageViewHero = new ImageView(imageHero);
            imageViewHero.setFitHeight(200);
            imageViewHero.setFitWidth(200);
            imageHeroStackPane.getChildren().add(imageViewHero);

            imageHeroStackPane.setAlignment(imageViewHero, Pos.BOTTOM_CENTER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        splitPaneLeft.getItems().addAll(infoHeroLabel, imageHeroStackPane);
        HeroStackPane.getChildren().add(splitPaneLeft);

        // MONSTER
        StackPane MonsterStackPane = new StackPane();

        SplitPane splitPaneRight = new SplitPane();

        splitPaneRight.setOrientation(Orientation.VERTICAL);

        Label infoMonsterLabel = new Label("Info du monstre");

        StackPane imageMonsterStackPane = new StackPane();
        imageMonsterStackPane.setStyle("-fx-border-color: red");

        try {
            FileInputStream inputStreamMonster = new FileInputStream(imgMonster);
            Image imageMonster = new Image(inputStreamMonster);
            ImageView imageViewMonster = new ImageView(imageMonster);
            imageViewMonster.setFitHeight(200);
            imageViewMonster.setFitWidth(200);
            imageMonsterStackPane.getChildren().add(imageViewMonster);

            imageMonsterStackPane.setAlignment(imageViewMonster, Pos.BOTTOM_CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }

        splitPaneRight.getItems().addAll(infoMonsterLabel, imageMonsterStackPane);
        MonsterStackPane.getChildren().add(splitPaneRight);

        VBox VBoxButton = new VBox();

        Button boutonAttaquer = new Button("Attaquer");
        Button boutonDefendre = new Button("Défendre");
        Button boutonPotion = new Button("Potions");

        boutonAttaquer.setPadding(new Insets(10));
        boutonDefendre.setPadding(new Insets(10));
        boutonPotion.setPadding(new Insets(10));

        VBoxButton.getChildren().addAll(boutonAttaquer, boutonDefendre, boutonPotion);
        VBoxButton.setAlignment(Pos.CENTER);
        VBoxButton.setSpacing(10);

        // GLOBAL
        SplitPane splitPaneGlobal = new SplitPane();

        splitPaneGlobal.getItems().addAll(HeroStackPane, MonsterStackPane, VBoxButton);

        Scene scene = new Scene(splitPaneGlobal);

        Stage secondaryStage = new Stage();
        secondaryStage.setScene(scene);
        secondaryStage.setMaximized(true);
        secondaryStage.setTitle("Combat");
        secondaryStage.show();

        StackPane stackPaneInfoHero = new StackPane();
        VBox vBoxInfoHero = new VBox();
        ArrayList<Text> infoHero = showInfoHero(hero);
        if (infoHero.size() == 5) {
            vBoxInfoHero.getChildren().addAll(infoHero.get(0), infoHero.get(1), infoHero.get(2), infoHero.get(3),
                    infoHero.get(4));
        } else {
            vBoxInfoHero.getChildren().addAll(infoHero.get(0), infoHero.get(1), infoHero.get(2), infoHero.get(3));
        }
        vBoxInfoHero.setAlignment(Pos.CENTER);
        stackPaneInfoHero.getChildren().add(vBoxInfoHero);

        Game.playGame(secondaryStage, infoHero, MonsterStackPane, hero, boutonAttaquer,
                boutonDefendre, boutonPotion);

        HeroStackPane.getChildren().add(stackPaneInfoHero);

    }

    public static void CombatChoice(Stage stage, ArrayList<Text> infoHeroText, ArrayList<Text> infoEnemyText,
            StackPane MonsterStackPane, Enemy enemy,
            Hero hero, Button attack,
            Button defend, Button potion) {

        EventHandler<ActionEvent> actionOnAttack = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Hero.attack(infoEnemyText, infoHeroText, enemy, hero);
                Hero.newRound(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, 0, attack, defend,
                        potion);
            }
        };

        EventHandler<ActionEvent> actionOnDefend = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Hero.defend();
                Hero.newRound(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, 0, attack, defend,
                        potion);
            }
        };

        EventHandler<ActionEvent> actionOnPotion = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Hero.useConsumable(infoHeroText, hero, hero.getPotion());
                Hero.newRound(stage, infoHeroText, infoEnemyText, MonsterStackPane, enemy, hero, 0, attack, defend,
                        potion);
            }
        };

        attack.setOnAction(actionOnAttack);
        defend.setOnAction(actionOnDefend);
        potion.setOnAction(actionOnPotion);

    }

    public static ArrayList<Text> showInfoHero(Hero hero) {
        ArrayList<Text> allTextHero = new ArrayList<Text>();

        Text textLife = new Text("HP du héros : " + Integer.toString(hero.getLifePoints()));
        Text textDammage = new Text("Dégats du héros : " + Integer.toString(hero.getWeaponDamage()));
        Text textEfficacite = new Text("Efficacité des potions du héros : " + Integer.toString(hero.getEfficacite()));
        Text textPotion = new Text("Nombre de potions du héros : " + Integer.toString(hero.getPotion()));

        allTextHero.add(textLife);
        allTextHero.add(textDammage);
        allTextHero.add(textEfficacite);
        allTextHero.add(textPotion);

        if (hero.getClass().getName() == "Hunter") {
            Text textArrow = new Text("Nombre de flèches du héros : " + Integer.toString(hero.getArrow()));
            allTextHero.add(textArrow);
        }

        return allTextHero;
    }

    public static ArrayList<Text> showInfoMonster(Enemy enemy) {
        Text textLife = new Text("HP du monstre : " + Integer.toString(enemy.getLifePoints()));
        Text textDammage = new Text("Dégats du monstre : " + Integer.toString(enemy.getDamage()));

        ArrayList<Text> allTextMonster = new ArrayList<Text>();
        allTextMonster.add(textLife);
        allTextMonster.add(textDammage);

        return allTextMonster;
    }

    public static void winCombat(Stage stage, ArrayList<Text> infoHeroText, ArrayList<Text> infoEnemyText,
            StackPane monsterStackPane, Enemy enemy,
            Hero hero, int nb, Button attack,
            Button defend,
            Button potion) {

        monsterStackPane.getChildren().removeAll(monsterStackPane.getChildren());

        VBox vBoxGlobal = new VBox();

        Text textePresentation = new Text("Bravo vous avez battu ce monstre, choississez une récompense !");

        Button increaseDamage = new Button("Augmenter les dégats");
        Button increaseArmor = new Button("Augmenter l'armure");
        Button increasePotion = new Button("Augmenter l'efficacité de la potion");
        Button increaseNumberPotion = new Button("Augmenter le nombre de potions");

        increaseDamage.setPadding(new Insets(10));
        increaseArmor.setPadding(new Insets(10));
        increasePotion.setPadding(new Insets(10));
        increaseNumberPotion.setPadding(new Insets(10));

        EventHandler<ActionEvent> actionOnIncreaseDamage = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hero.setWeaponDammage(hero.getWeaponDamage() + 1);
                infoHeroText.get(1).setText("Dégats du héros : " + Integer.toString(hero.getWeaponDamage()));

                newCombat(stage, infoHeroText, infoEnemyText, monsterStackPane, enemy, hero, nb, attack, defend,
                        potion);
            }
        };

        EventHandler<ActionEvent> actionOnIncreaseArmor = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hero.setArmor(hero.getArmor() + 1);
                newCombat(stage, infoHeroText, infoEnemyText, monsterStackPane, enemy, hero, nb, attack, defend,
                        potion);
            }
        };

        EventHandler<ActionEvent> actionOnIncreasePotion = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hero.setEfficacite(hero.getEfficacite() + 1);
                infoHeroText.get(2)
                        .setText("Efficacité des potions du héros : " + Integer.toString(hero.getEfficacite()));

                newCombat(stage, infoHeroText, infoEnemyText, monsterStackPane, enemy, hero, nb, attack, defend,
                        potion);

            }
        };

        EventHandler<ActionEvent> actionOnIncreaseNumberPotion = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hero.setPotion(hero.getPotion() + 1);
                infoHeroText.get(3).setText("Nombres de potions du héros : " + Integer.toString(hero.getPotion()));

                newCombat(stage, infoHeroText, infoEnemyText, monsterStackPane, enemy, hero, nb, attack, defend,
                        potion);
            }
        };

        increaseArmor.setOnAction(actionOnIncreaseArmor);
        increaseDamage.setOnAction(actionOnIncreaseDamage);
        increasePotion.setOnAction(actionOnIncreasePotion);
        increaseNumberPotion.setOnAction(actionOnIncreaseNumberPotion);

        vBoxGlobal.getChildren().addAll(textePresentation, increaseArmor, increaseDamage, increasePotion,
                increaseNumberPotion);

        if (hero.getClass().getName() == "Hunter") {
            Button increaseNumberArrow = new Button("Augmenter le nombre de flèches");
            increaseNumberArrow.setPadding(new Insets(10));

            EventHandler<ActionEvent> actionOnIncreaseNumberArrow = new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    hero.setArrow(hero.getArrow() + 1);
                    infoHeroText.get(4).setText("Nombres de flèches du héros : " + Integer.toString(hero.getArrow()));

                    newCombat(stage, infoHeroText, infoEnemyText, monsterStackPane, enemy, hero, nb, attack, defend,
                            potion);
                }
            };
            increaseNumberArrow.setOnAction(actionOnIncreaseNumberArrow);
            vBoxGlobal.getChildren().add(increaseNumberArrow);
        }

        vBoxGlobal.setAlignment(Pos.CENTER);
        vBoxGlobal.setSpacing(10);

        monsterStackPane.getChildren().add(vBoxGlobal);

    }

    public static void newCombat(Stage stage, ArrayList<Text> infoHeroText, ArrayList<Text> infoEnemyText,
            StackPane monsterStackPane, Enemy enemy,
            Hero hero, int nb, Button attack,
            Button defend,
            Button potion) {
        monsterStackPane.getChildren().removeAll(monsterStackPane.getChildren());
        SplitPane splitPaneRight = new SplitPane();

        splitPaneRight.setOrientation(Orientation.VERTICAL);

        Label infoMonsterLabel = new Label("Informations du monstre");

        StackPane imageMonsterStackPane = new StackPane();
        imageMonsterStackPane.setStyle("-fx-border-color: red");

        String imgMonster = choiceImgMonster();

        try {
            FileInputStream inputStreamMonster = new FileInputStream(imgMonster);
            Image imageMonster = new Image(inputStreamMonster);
            ImageView imageViewMonster = new ImageView(imageMonster);
            imageViewMonster.setFitHeight(200);
            imageViewMonster.setFitWidth(200);
            imageMonsterStackPane.getChildren().add(imageViewMonster);

            imageMonsterStackPane.setAlignment(imageViewMonster, Pos.BOTTOM_CENTER);

        } catch (IOException e) {
            e.printStackTrace();
        }

        splitPaneRight.getItems().addAll(infoMonsterLabel, imageMonsterStackPane);
        monsterStackPane.getChildren().add(splitPaneRight);

        Game.playGame(stage, infoHeroText, monsterStackPane, hero, attack,
                defend, potion);
    }

    public static void gameOver() {
        String gameOver = "img/gameover.png";

        StackPane gameOverStackPane = new StackPane();

        try {
            FileInputStream gameOverInput = new FileInputStream(gameOver);
            Image gameOverImage = new Image(gameOverInput);
            ImageView gameOverImageView = new ImageView(gameOverImage);

            gameOverStackPane.getChildren().add(gameOverImageView);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(gameOverStackPane);

        Stage thirdStage = new Stage();
        thirdStage.setScene(scene);
        thirdStage.setMaximized(true);
        thirdStage.setTitle("Game Over");
        thirdStage.show();
    }

    public static String choiceImgMonster() {
        String imgMonster = new String();
        Random rd = new Random();
        int alea = rd.nextInt(3);
        if (alea == 0) {
            imgMonster = "img/monster.png";
        } else if (alea == 1) {
            imgMonster = "img/monster2.jpg";
        } else {
            imgMonster = "img/monster3.jpg";
        }
        return imgMonster;
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }

}
