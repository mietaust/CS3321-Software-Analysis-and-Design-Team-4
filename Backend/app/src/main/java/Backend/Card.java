package Backend;
import lombok.Getter;
import lombok.Setter;

import java.util.Deque;


public class Card extends Space{
    //private variable and field storage
    @Getter private final int CHANCE_DECK = 16;
    @Getter private final int COM_CHEST = 16;
    @Getter@Setter private CardType type;
    @Getter@Setter private CardAction action;
    @Getter@Setter private String cardDesc;
    @Getter@Setter private int cardValue;

    public enum CardType {COMMUNITY,CHANCE}
    public enum CardAction{LOSEMONEY, ADDMONEY, JAIL, MOVE, JAILBREAK}
    /**
     * Constructor
     *
     *
     * @param name     Name of the space
     * @param location The postion on the gameboard
     * @param cardType  define which type of card
     */
    public Card(String name, int location, CardType cardType) {
        super(name, location);
        this.type =cardType;
    }

     /* @param action define which action is occuring
     */
    public void performAction(CardAction action){
        //action = this.action;
        switch(action){
            case LOSEMONEY:
                //logic to remove money from player account
                break;
            case ADDMONEY:
                //logic to add money to player account
                break;
            case JAIL:
                //logic to put the player in jail
                break;
            case MOVE:
                //logic to move player
                break;
            case JAILBREAK:
                //logic to break player out of jail
                break;
            default:
                //error in getting cardaction
                break;
        }
    }
}
