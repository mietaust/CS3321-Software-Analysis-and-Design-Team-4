package Backend;
import lombok.Getter;
import lombok.Setter;

public class Railroad extends Property{


    @Getter @Setter private boolean hasTrainStation;

    /**
     * Constructor
     *
     * @param name     Name of the space
     * @param location The position on the gameboard
     */
    public Railroad(String name, int location, boolean tStation) {
        super(name, location);
        this.hasTrainStation = tStation;
    }

}
