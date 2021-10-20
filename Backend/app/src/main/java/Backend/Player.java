package Backend;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {
    @Setter
    @Getter
    private String name;
    @Getter
    private double accountBalance;
    @Getter
    private int position;
    private double netWorth;
    @Setter
    @Getter
    private boolean inJail;
    //private ArrayList<Property> propertyOwned;
    //private ArrayList<Card> cardDrawn;


    /**
     * Constructor
     * @param name Name of player
     */
    public Player(String name) {
        this.name = name;
        this.accountBalance = 0;
        this.inJail = false;
        this.netWorth = 0;
        this.position = 0;
    }
    /**
     *
     * @param accountBalance updates the player account balance
     */

    public void setAccountBalance(double accountBalance) {
        this.accountBalance += accountBalance;
    }

    /**
     *
     * @param position updates the player position
     */
    public void setPosition(int position) {
        int temp = this.position;
        this.position =  (temp + position) % 39;
    }

    /**
     *
     * @return the players net worth
     */
    public double getNetWorth(){
        this.netWorth += this.accountBalance;
        return this.netWorth;
    }

    public static void main(String[] args) {
        Player play = new Player("Dave");
        play.setPosition(50);
        System.out.println(play.getPosition());
        System.out.println(play.getAccountBalance());
        play.setAccountBalance(200.00);
        play.setAccountBalance(200.00);
        play.setAccountBalance(-200.00);
        System.out.println(play.getAccountBalance());

    }
}
