package Backend;

import lombok.Getter;
import lombok.Setter;

public class Property extends Space{

    @Setter
    @Getter
    private Player owner;
    @Getter
    private final int value;
    private final  int rent;

    /**
     * Constructor
     *
     * @param name Name of the Space
     * @param location Position on the Board
     * @param value The price to purchase the Property
     * @param rent Cost for landing on the Property
     */
    public Property(String name, int location, int value, int rent ) {
        super(name, location);
        this.owner = null;
        this.rent = rent;
        this.value = value;

    }

    /**
     *
     * @param property  Checks the rent value
     * @return  Rent value for the property
     */
    public int getRent(Property property) {
        return rent;
    }

    /**
     *
     * @param owner Property Owner
     * @return Checks if owner is a player
     */
    public static boolean ownerIsPlayer(Object owner){
        return owner instanceof Player;
    }


}
