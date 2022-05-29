import java.util.ArrayList;

import javafx.scene.text.Text;

public abstract class Enemy {

    int lifePoints;
    int damage;

    public static void attackofEnemy(ArrayList<Text> infoHeroText, Enemy enemy, Hero hero) {
        System.out.println("Hero hp : " + hero.getLifePoints());
        System.out.println("Enemy hp : " + enemy.getLifePoints());
        System.out.println("Enemy Dammage : " + enemy.getDamage());
        hero.setLifePoints(hero.getLifePoints() - enemy.getDamage());
        infoHeroText.get(0).setText("HP du héros : " + Integer.toString(hero.getLifePoints()));
        System.out.println("Hero hp : " + hero.getLifePoints());
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
