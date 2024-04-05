public class Invertory {
    private Weapon weapon;

    private Armor armor;

    private boolean water =false;
    private boolean food = false;
    private boolean firewood = false;


    public Invertory() {
        this.weapon = new Weapon("Yumruk ", -1, 0, 0);
        this.armor = new Armor(-1, "Bez ", 0, 0);

    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}

