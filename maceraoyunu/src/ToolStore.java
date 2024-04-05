public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("-------Magazaya Hosgeldiniz ! -------");
        boolean showMenu = true;
        while (showMenu) {

            System.out.println("1 - Silahlar: ");
            System.out.println("2 - Zırhlar: ");
            System.out.println("3 - Çıkış Yap ");
            System.out.print("Seciminiz: ");
            int selectCase = Location.inp.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Gecersiz bir deger girdiniz: ");
                selectCase = Location.inp.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz ^^");
                    showMenu = false;
                    break;
            }

        }
        return true;

    }

    public void printWeapon() {
        System.out.println("------- Silahlar -------");

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() +
                    " - " + w.getName() +
                    " , Para: " + w.getPrice() +
                    ", Hasar: " + w.getDamage());
        }
        System.out.println("0 - Çıkış Yap !");
    }

    public void buyWeapon() {
        System.out.println("Bir silah seciniz: ");
        int selectWeaponID = inp.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Gecersiz bir deger girdiniz: ");
            selectWeaponID = Location.inp.nextInt();
        }

        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByIO(selectWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahini satin aldınız  !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önce ki silahınız: " + this.getPlayer().getInvertory().getWeapon().getName());
                    this.getPlayer().getInvertory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + this.getPlayer().getInvertory().getWeapon().getName());
                }
            }
        }

    }

    public void printArmor() {
        System.out.println("------- Zırhlar -------");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() +
                    " - " + a.getName() +
                    " , Para: " + a.getPrice() +
                    ", Zırh: " + a.getBlok());
        }
        System.out.println("0 - Çıkış Yap !");
    }

    public void buyArmor() {
        System.out.println("Bir zırh seciniz: ");
        int selectArmorID = inp.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Gecersiz bir deger girdiniz: ");
            selectArmorID = Location.inp.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByIO(selectArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhı satin aldınız  !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önce ki Armorunuz: " + this.getPlayer().getInvertory().getArmor().getName());
                    this.getPlayer().getInvertory().setArmor(selectedArmor);
                    System.out.println("Yeni Armorunuz: " + this.getPlayer().getInvertory().getArmor().getName());
                }
            }
        }

    }
}
