import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private String name;
    private String charName;

    private Scanner inp = new Scanner(System.in);

    private Invertory invertory;

    public Player(String name) {
        this.name = name;
        this.invertory = new Invertory();

    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Warrior()};
        System.out.println("Karakterler: ");
        System.out.println("--------------------------------------------");
        for (GameChar gamechar : charList) {
            System.out.println("ID: " + gamechar.getId() +
                    " Karakter: " + gamechar.getName() +
                    " Hasar: " + gamechar.getDamage() +
                    " Saglik: " + gamechar.getHealth() +
                    " Para: " + gamechar.getMoney());
        }
        System.out.println("------------------------------------------------");
        System.out.println("Lütfen karakter seciniz: ");

        int selectChar = inp.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Warrior());
                break;
            default:
                initPlayer(new Samurai());
        }
       /* System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Saglik: " + this.getHealth() +
                ", Para: " + this.getMoney());

        */
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(" Silahiniz: " + this.getInvertory().getWeapon().getName() +
                " Zırh: " + this.getInvertory().getArmor().getName() +
                " Bloklama: " + this.getInvertory().getArmor().getBlok() +
                ", Hasar: " + this.getTotalDamage() +
                ", Saglik: " + this.getHealth() +
                ", Para: " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInvertory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage + this.getInvertory().getWeapon().getDamage();
    }

    public void setHealth(int health) {
        if (this.health < 0) {
            health = 0;
        }

        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharName() {
        return charName;
    }

    public Scanner getInp() {
        return inp;
    }

    public void setInp(Scanner inp) {
        this.inp = inp;
    }

    public Invertory getInvertory() {
        return invertory;
    }

    public void setInvertory(Invertory invertory) {
        this.invertory = invertory;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

}
