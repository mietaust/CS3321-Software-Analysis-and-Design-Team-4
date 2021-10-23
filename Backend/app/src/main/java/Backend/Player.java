package Backend;

import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;

public class Player extends Owner {
    @Setter
    @Getter
    private String name;
    @Getter
    private int accountBalance;
    @Getter
    private int position;
    private int netWorth;
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
    public void move(int position) {
        int temp = this.position;
        this.position =  (temp + position) % 39;
        checkPosition(this.position);
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
    public void buy(Property property){
        for(Property element : getPropertyOwned()){
            if(element.equals(property)){
                return;
            }
        }
        this.accountBalance -= property.getValue();
        propertyOwned.add(property);
    }

    /**
     * Checks if player owns street color group
     * @param street Street player checks
     * @return True
     */
    public boolean ownAllStreetGroup(Street street){
        int count = 0;
        for (Property property : getPropertyOwned()){
            if(property instanceof Street){
                if(((Street) property).getColorGroup().equals(street.getColorGroup())){
                    count++;
                }
            }
        }
        if(count == street.getColorGroup().totalGroupNumber){
            return true;
        }
        return false;
    }


    /**
     *
     * @param utility,
     * @return number of utilities the player holds (maximum of 2)
     */
    public int utilitiesOwned(Utility utility){
        int count = 0;
        // for all the properties owned, search for Utilities
        for (Property property : getPropertyOwned()){
            if(property instanceof Utility){
                    count++;
            }
        }
        return count;
    }



    /**
     *
     * @param railRoad
     * @return
     */
    public int railRoadsOwned(Railroad railRoad){
        int count = 0;
        for (Property property : getPropertyOwned()) {
            if (property instanceof Railroad) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks player current position
     * @param position Player position
     */
    private void checkPosition(int position){
        if(position == Constants.GO_SPACE){
            setAccountBalance(Constants.PASSING_GO);
        }
        else if (position == Constants.COMMUNITY_CHEST){

        }
        else if (position == Constants.CHANCE_RED){

        }
        else if (position == Constants.GOTO_JAIL){
            if(!this.inJail) {
                setInJail(true);
            }
            move(11);

        }
        else if (position == Constants.COMMUNITY_CHEST2){

        }
        else if (position == Constants.CHANCE_BLUE){

        }
        else if (position == Constants.CHANCE_ORANGE){

        }
        else if (position == Constants.COMMUNITY_CHEST3){

        }
        else{
            return;

        }
    }

}
