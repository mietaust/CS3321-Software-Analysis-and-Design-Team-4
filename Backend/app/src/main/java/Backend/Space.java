package Backend;

import lombok.Getter;
import lombok.Setter;

public class Space {

    @Getter
    private final String name;
    @Getter
    private final int location;


    /**
     * Constructor
     *
     * @param location The postion on the gameboard
     * @param name Name of the space
     */
    public Space(String name, int location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Checks if Space is an instance of Property
     * @param space position on the game board
     * @return returns true if space is an instance of property
     */
    public static boolean isProperty(Space space){
       return space instanceof Property;
    }

    @Override
    public String toString() {
        return "Space{" +
                "name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
