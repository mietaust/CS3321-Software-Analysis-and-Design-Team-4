package Backend;
import lombok.Getter;
import lombok.Setter;

import java.util.Deque;


public class Card extends Space{
    /**
     * Constructor
     *
     *
     * @param name     Name of the space
     * @param location The postion on the gameboard
     */
    public Card(String name, int location) {
        super(name, location);
    }

    //private variable and field storage
    @Getter private final int CHANCE_DECK = 16;
    @Getter private final int COM_CHEST = 16;
    @Getter@Setter private Card.CardType type;
    @Getter@Setter private CardAction action;
    @Getter@Setter private String cardDesc;

    public enum CardType {COMMUNITY,CHANCE}
    public enum CardAction{LOSEMONEY, ADDMONEY, JAIL, MOVE, JAILBREAK}
}
