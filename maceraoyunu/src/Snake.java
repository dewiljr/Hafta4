import java.util.Random;

public class Snake extends Obstacle {

    public Snake() {
        super(4, "Yılan", 0, 12, 0);
    }

    @Override
    public int getDamage() {
        Random r = new Random();
        return r.nextInt(3, 7);
    }


    @Override
    public void randomDrop() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        Weapon[] weaponList = Weapon.weapons();
        Armor[] armorList = Armor.armors();
        int Gold[] = {1, 5, 10};
        int lootType = 0;

        if (x > 55) {
            lootType = 0;
        } else if (x > 30) {
            lootType = 1;
        } else if (x > 15) {
            lootType = 2;

        } else lootType = 3;

        int y = random.nextInt(100) + 1;
        int specialLoot = 0;

        if (x > 50) {
            specialLoot = 0;
        } else if (x > 30) {
            specialLoot = 1;
        } else specialLoot = 2;


        switch (lootType) {
            case 0:
                System.out.println("No drop :=) ");
                break;
            case 1:
                System.out.println("Gold drop");
                this.setAward(Gold[specialLoot]);
                break;
            case 2:
                System.out.println("Weapon drop");
                this.setDropWeapon(weaponList[specialLoot]);
                break;
            case 3:
                System.out.println("Armor Drop");
                this.setDropArmor(armorList[specialLoot]);
                break;


        }
    }
}