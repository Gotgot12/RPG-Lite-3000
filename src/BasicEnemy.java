public class BasicEnemy extends Enemy {
    int damage;

    public BasicEnemy(int lifePoints, int damage) {
        this.lifePoints = lifePoints;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
