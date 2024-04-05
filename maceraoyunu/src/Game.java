import java.util.Scanner;

public class Game {
    private Scanner inp = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldiniz! ");
        System.out.println("Lütfen bir isim giriniz: ");
        String playerName = inp.nextLine();
        Player player = new Player(playerName);
        System.out.println(" Büyük Savaşcı " + player.getName() + " bu karanlık ve sisli ortama hoşgeldin !");
        System.out.println("Lütfen bir karakter seciniz: ");
        System.out.println("-------------------------------------------------------------");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("########## Bölgeler:  ");
            System.out.println();
            System.out.println("1 - Güvenli Bölge --> Burada düşman yoktur !");
            System.out.println("2 - Dükkan --> Silah veya Zırh alarak güçlenebilirsin !");
            System.out.println("3 - Magara  --> Ödül <Yemek> , dikkatli ol Zombie çıkabilir !");
            System.out.println("4 - Orman  --> Ödül <Odun> , dikkatli ol Vampire çıkabilir !");
            System.out.println("5 - Nehir  --> Ödül <Su> , dikkatli ol Bear çıkabilir !");
            System.out.println("6 - Maden  --> Ödül <Random item> , dikkatli ol Snake çıkabilir !");
            System.out.println("0- Cıkıs Yap --> Oyunu sonlandır !");
            System.out.println("Lütfen gitmek istediginiz bölgeyi seciniz: ");
            int selectLoc = inp.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    if (player.getInvertory().isFood() && player.getInvertory().isFirewood() && player.getInvertory().isWater()) {
                        System.out.println("Tüm Ödülleri topladınız, geçmiş olsun.");
                        System.exit(0);
                    }
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.getInvertory().isFood()) {
                        System.out.println("Bu bölgenin ödülü alınmıştır !");
                        continue;
                    }
                    location = new Cave(player);

                    break;
                case 4:
                    if (player.getInvertory().isFirewood()) {
                        System.out.println("Bu bölgenin ödülü alınmıştır !");
                        continue;
                    }
                    location = new Forest(player);
                    break;
                case 5:
                    if (player.getInvertory().isWater()) {
                        System.out.println("Bu bölgenin ödülü alınmıştır !");
                        continue;
                    }
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen gecerli bir bölge giriniz..");
            }
            if (location == null) {
                System.out.println("Bu karanlık ve sisli adadan ayrıldın..");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !");
                break;
            }
        }

    }
}

