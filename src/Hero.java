public abstract class Hero extends Game {
    public int weaponDamage;
    public int lifePoints;
    public int armor;

    String[] potions = new String[5];
    String[] lembas = new String[5];

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public int getArmor() {
        return armor;
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

    public void attack() {

    }

    public void defend() {

    }

    public void useConsumable(String Consumable) {

    }
}