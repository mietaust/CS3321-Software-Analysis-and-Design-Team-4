package Backend;
import java.util.UUID;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Player{
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private double accountBalance;
    @Getter
    @Setter
    private int position;
    @Setter
    @Getter
    private boolean inJail;
    private boolean turn;
    @Setter
    @Getter
    private transient ArrayList<Property> propertyOwned;
    @Getter
    @Setter
    private int OOJCards = 0;
    @Getter
    @Setter
    private int numJailEscAttempts = 0;
    @Getter
    private final UUID id;
    private ArrayList<String> propertyName;


    /**
     * Constructor
     * @param name Name of player
     */
    public Player(String name) {
        this.name = name;
        this.accountBalance = 1500;
        this.inJail = false;
        this.position = 0;
        this.propertyOwned = new ArrayList<>();
        this.propertyName = new ArrayList<>();
        this.id = UUID.randomUUID();
    }


    /**
     *
     * @param accountBalance Updates the player account balance
     */

    public void addToAccount(double accountBalance) {
        this.accountBalance += accountBalance;
    }

    /**
     * Player position ranges from 0 to 39
     * @param position updates the player position
     */
    public void move(int position) {
        int temp = this.position;

        this.position =  (temp + position) % 40;
        //checkPosition(this.position);
    }
    public void goToJail(){
        this.position = Constants.JAIL;
        inJail = true;
    }


    /**
     * Checks if property already exits in list, else it adds the property
     * Subtracts the value of the property from the players account balance
     * @param property Add property to players list of properties
     */
    //Thinking of changing property to space, since we cant be sure if the player is on a non-property or property
    public void buy(Property property) {
        if (property != null) {
            for (Property element : getPropertyOwned()) {
                if (element.equals(property)) {
                    return;
                }
            }
            if(property.getOwner() == null ){
                this.accountBalance -= property.getValue();
                propertyOwned.add(property);
                propertyName.add(property.getName());
                property.setOwner(this);
            }

        }
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
        return count == street.getColorGroup().totalGroupNumber;
    }


    /**
     *
     * @return number of utilities the player holds (maximum of 2)
     */
    public int utilitiesOwned(){
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
     * @return The number of railroads owned by a player
     */
    public int railRoadsOwned(){
        int count = 0;
        for (Property property : getPropertyOwned()) {
            if (property instanceof Railroad) {
                count++;
            }
        }
        return count;
    }


    public boolean equals(@NotNull Player p){
        return p.getId().equals(this.id);
    }
    /// Moving checkposition method to game-logic


}
