import java.util.Objects;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol ! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor !");
        System.out.println("----- <S>avas veya <K>ac -----------");
        String selectCase = inp.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " tüm düşmanları yendiniz !");
            System.out.println("Alan Özel İtemini Kazandınız." + this.getAward());
            collectAward();
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldün çık");
            return false;
        }

        return true;
    }

    public void collectAward() {
        if (Objects.equals(this.getAward(), "Food")) {
            this.getPlayer().getInvertory().setFood(true);
        }
        if (Objects.equals(this.getAward(), "Water")) {
            this.getPlayer().getInvertory().setWater(true);
        }
        if (Objects.equals(this.getAward(), "Firewood")) {
            this.getPlayer().getInvertory().setFirewood(true);
        }
    }

    @Override
    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStats();
            obstacleStats(i);
            Random randomNumber = new Random();
            if (randomNumber.nextInt(1, 10) < 6) {
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                    System.out.println("<S>aldır or <K>ac  : ");
                    String startCombat = inp.nextLine().toUpperCase();
                    if (startCombat.equals("S")) {
                        System.out.println(this.getPlayer().getName() + " sana saldırdı ! " + this.getObstacle().getName());
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar Sana Saldırdı ");
                            int monsterDDealt = this.getObstacle().getDamage() - this.getPlayer().getInvertory().getArmor().getBlok();
                            if (monsterDDealt < 0) {
                                monsterDDealt = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDDealt);
                            afterHit();
                        }

                    } else return false;
                }
            } else {
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                    System.out.println("<S>aldır or <K>ac : ");
                    String startCombat = inp.nextLine().toUpperCase();
                    if (startCombat.equals("S")) {
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar Sana Saldırdı !");
                            int monsterDDealt = this.getObstacle().getDamage() - this.getPlayer().getInvertory().getArmor().getBlok();
                            if (monsterDDealt < 0) {
                                monsterDDealt = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDDealt);
                            afterHit();
                            System.out.println();
                        }
                        System.out.println(this.getPlayer().getName() + " sana saldırdı ! " + this.getObstacle().getName());
                        this.getObstacle().setHealth(this.obstacle.getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                    } else return false;

                }

            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı Yendiniz !");
                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                    System.out.println();
                    System.out.println("Canavar  " + this.getObstacle().getName() + " yendin !");
                    this.obstacle.randomDrop();

                    if (this.getObstacle().getDropArmor() != null) {
                        this.getPlayer().getInvertory().setArmor((this.getObstacle().getDropArmor()));
                        System.out.println("İtem Envanterine eklendi ! " + this.getPlayer().getInvertory().getArmor().getName());
                    }



                    System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + getObstacle().getAward());
                    System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                } else {
                    return false;
                }

                System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
            } else {
                return false;
            }

        }
        return true;
    }


    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Degerleri: ");
        System.out.println("--------------------- ");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInvertory().getWeapon().getName());
        System.out.println("Zırh: " + this.getPlayer().getInvertory().getArmor().getName());
        System.out.println("Bloklama: " + this.getPlayer().getInvertory().getArmor().getBlok());
        System.out.println("Hasarımız : " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getMoney());


    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + "Değerleri: ");
        System.out.println("--------------------------");
        System.out.println("Saglık: " + this.getObstacle().getHealth());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül: " + this.getObstacle().getAward());
        System.out.println("--------------------------");
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
