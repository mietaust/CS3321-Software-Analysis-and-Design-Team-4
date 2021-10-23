package Backend;

public class Railroad extends Property{

    /**
     *
     * @param name Name of the Railroad
     * @param location Position on the Board
     * @param value The price to purchase the Property
     * @param rent Cost for landing on the Property
     */
    public Railroad(String name, int location, int value, int rent) {
        super(name, location, value, rent);
    }

    /**
     *
     * @param property  Checks the rent value
     * @return Value of rent
     */
    @Override
    public int getRent(Property property) {
        if(Property.ownerIsPlayer(getOwner())){
            if (((Player)getOwner()).railRoadsOwned((Railroad) property) == 1){
                return 25;
            }
            if (((Player)getOwner()).railRoadsOwned((Railroad) property) == 2){
                return 50;
            }
            else if (((Player)getOwner()).railRoadsOwned((Railroad) property) == 3){
                return 100;
            }
            if (((Player)getOwner()).railRoadsOwned((Railroad) property) == 4){
                return 200;
            }
        }
        return super.getRent(property);  // Thinking of changing to 0.
    }
}
