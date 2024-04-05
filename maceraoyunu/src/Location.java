import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner inp = new Scanner(System.in);

    public Location(Player player,String name) {
        this.player = player;
        this.name=name;

    }

   public abstract boolean onLocation();

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public abstract boolean combat(int obsNumber);
}
