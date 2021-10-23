package Backend;

import lombok.Getter;
import lombok.Setter;

public class Utility extends Property{

    /**
     * @param name Name of the Utility
     * @param location Position on the Board
     * @param value The price to purchase the Property
     * @param rent Cost for landing on the Property
     */
    public Utility(String name, int location, int value, int rent) {
        super(name, location, value, rent);
    }

    /**
     *
     * @param property  Checks the rent value
     * @return Value of rent
     */
    @Override
    public int getRent(Property property) {
        //TODO identify getOwner() for properties
        Player owner = Owner.isPlayer(getOwner());
        // if the owner exists
        if(owner != null){ 

            // if the player owns one utility
            if ((owner).utilitiesOwned((Utility) property) == 1){
                // the rent is 4 times the dice roll
                return 4*Dice.getInstance().getTotal();
            }

            //if the player owns both utilities
            if ((owner).utilitiesOwned((Utility) property) == 2){
                // the rent is 10 times the dice roll
                return 10*Dice.getInstance().getTotal();
            }

        }
        //return the calculated rent
        return super.getRent(property);
    }

}
