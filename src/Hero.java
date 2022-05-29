import java.util.ArrayList;

import javafx.scene.text.Text;

public abstract class Hero extends Game {
    public int weaponDamage;
    public int lifePoints;
    public int armor;

    public int potion;

    public int arrow;

    public int efficacite = 1;

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getArmor() {
        return armor;
    }

    public int getPotion() {
        return potion;
    }

    public void setWeaponDammage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public int getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(int efficacite) {
        this.efficacite = efficacite;
    }

    public static void attack(ArrayList<Text> infoEnemyText, ArrayList<Text> infoHeroText, Enemy enemy, Hero hero) {
        if (hero.getClass().getName().equals("Hunter") && hero.getArrow() > 0) {
            hero.setArrow(hero.getArrow() - 1);

            System.out.println("Enemy hp : " + enemy.getLifePoints());
            System.out.println("Hero Dammage : " + hero.getWeaponDamage());
            enemy.setLifePoints(enemy.getLifePoints() - hero.getWeaponDamage());
            infoEnemyText.get(0).setText("HP du monstre : " + Integer.toString(enemy.getLifePoints()));
            infoHeroText.get(4).setText("Nombre de flèches : " + Integer.toString(hero.getArrow()));
            System.out.println("Enemy hp : " + enemy.getLifePoints());
        } else {
            System.out.println("Enemy hp : " + enemy.getLifePoints());
            System.out.println("Hero Dammage : " + hero.getWeaponDamage());
            enemy.setLifePoints(enemy.getLifePoints() - hero.getWeaponDamage());
            infoEnemyText.get(0).setText("HP du monstre : " + Integer.toString(enemy.getLifePoints()));
            System.out.println("Enemy hp : " + enemy.getLifePoints());
        }

    }

    public static void defend() {

    }

    public static void useConsumable(ArrayList<Text> infoHeroText, Hero hero, int potion) {
        if (potion > 0) {
            System.out.println("Hero HP : " + hero.getLifePoints());
            hero.setLifePoints(hero.getLifePoints() + hero.efficacite);
            infoHeroText.get(0).setText("HP du héros : " + Integer.toString(hero.getLifePoints()));
            hero.setPotion(hero.getPotion() - 1);
            infoHeroText.get(3).setText("Nombre de potions du héros : " + Integer.toString(hero.getPotion()));
        }
    }
}