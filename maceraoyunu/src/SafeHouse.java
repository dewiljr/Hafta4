public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player){
        super(player, "Güvenli Bölge");
    }

    @Override
   public boolean onLocation() {
        System.out.println("Güvenli Bölgedesiniz !");
        System.out.println("Canınız Yenilendi !");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
