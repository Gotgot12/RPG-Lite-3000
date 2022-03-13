public abstract class Enemy {

    int lifePoints;
    int damage;

    public static void attackofEnemy(Enemy enemy, Hero hero) {
        System.out.println("Hero hp : " + hero.getLifePoints());
        System.out.println("Enemy Dammage : " + enemy.getDamage());
        hero.setLifePoints(hero.getLifePoints() - enemy.getDamage());
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
