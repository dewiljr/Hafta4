public class Obstacle {

    private int id;
    private String name;
    private int damage;
    private int health;
    private int award;
    private int orijinalHealth;
    private Weapon dropWeapon;
    private Armor dropArmor;

    public Obstacle(int id, String name, int damage, int health, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.orijinalHealth = health;
        this.award = award;

    }

    public void randomDrop(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

    public Weapon getDropWeapon() {
        return dropWeapon;
    }

    public void setDropWeapon(Weapon dropWeapon) {
        this.dropWeapon = dropWeapon;
    }

    public Armor getDropArmor() {
        return dropArmor;
    }

    public void setDropArmor(Armor dropArmor) {
        this.dropArmor = dropArmor;
    }
}
