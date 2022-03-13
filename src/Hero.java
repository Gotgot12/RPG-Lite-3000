public abstract class Hero extends Game {
    public int weaponDamage;
    public int lifePoints;
    public int armor;

    public int potion;
    public int lembas;

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

    public static void attack(Enemy enemy, Hero hero) {
        if (hero.getClass().getName().equals("Hunter") && hero.getArrow() > 0) {
            hero.setArrow(hero.getArrow() - 1);
            System.out.println("Enemy hp : " + enemy.getLifePoints());
            System.out.println("Hero Dammage : " + hero.getWeaponDamage());
            enemy.setLifePoints(enemy.getLifePoints() - hero.getWeaponDamage());
            System.out.println("Enemy hp : " + enemy.getLifePoints());
        } else if (hero.getClass().getName().equals("Hero")) {
            System.out.println("Enemy hp : " + enemy.getLifePoints());
            System.out.println("Hero Dammage : " + hero.getWeaponDamage());
            enemy.setLifePoints(enemy.getLifePoints() - hero.getWeaponDamage());
            System.out.println("Enemy hp : " + enemy.getLifePoints());
        }

    }

    public void defend() {

    }

    public static void useConsumable(Hero hero, int potion) {
        if (potion > 0) {
            System.out.println("Hero HP : " + hero.getLifePoints());
            hero.setLifePoints(hero.getLifePoints() + hero.efficacite);
            hero.setPotion(hero.getPotion() - 1);
        }
    }
}