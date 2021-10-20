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
    @Getter
    private ArrayList<Property> propertyOwned;
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
        this.propertyOwned = new ArrayList<>();
    }
    /**
     *
     * @param accountBalance updates the player account balance
     */

    public void setAccountBalance(double accountBalance) {
        this.accountBalance += accountBalance;
    }

    /**
     * Player position ranges from 0 to 39
     * @param position updates the player position
     */
    public void setPosition(int position) {
        int temp = this.position;
        this.position =  (temp + position) % 39;
    }

    /**
     * Sum of the value of all property and account balance
     * @return the players net worth
     */
    public double getNetWorth(){
        this.netWorth += this.accountBalance;
        return this.netWorth;
    }

    /**
     * Checks if property already exits in list, else it adds the property
     * @param property Add property to players list of properties
     */
    public void addProperty(Property property){
        for(Property element : getPropertyOwned()){
            if(element.equals(property)){
                return;
            }
        }
        propertyOwned.add(property);
    }

}
