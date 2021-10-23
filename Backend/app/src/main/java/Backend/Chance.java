package Backend;
import lombok.Getter;
import lombok.Setter;
public class Chance extends Card {

    //Inspiration from https://github.com/fjricci/monopoly

    /**
     * Constructor
     *
     * @param name     Name of the space
     * @param location The postion on the gameboard
     */
    public Chance(String name, int location) {
        super(name, location);
    }

    //variable and field declaration


    private void chance(int a) {
        CardType type = CardType.CHANCE;
        switch (a) {
            case 0:
                aBoard();
                break;
            case 1:
                aGo();
                break;
            case 2:
                aIll();
                break;
            case 3:
                aCharl();
                break;
            case 4:
                aRail();
                break;
            case 5:
                aUtil();
                break;
            case 6:
                dividend();
                break;
            case 7:
                goBack();
                break;
            case 8:
                speeding();
                break;
            case 9:
                aReading();
                break;
            case 10:
                elected();
                break;
            case 11:
                loanMature();
                break;
            case 12:
                jail();
                break;
            case 13:
                jailOut();
                break;
            case 14:
                repairs();
                break;
            case 15:
                crosswords();
                break;
            default:
                break;
        }
    }

    private void crosswords() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("You won a crossword contest! Gain $100.");
    }

    private void loanMature() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("Your building loan matured. Collect $150.");
    }

    private void elected() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You've been elected to Chairman. Pay each player $50.");
    }

    private void aReading() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to reading railroad.");
    }

    private void speeding() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("Slow down there, buddy! $15 dollar speeding ticket.");
    }

    private void goBack() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Move back 3 spaces.");
    }

    private void dividend() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("You received a $50 dollar dividend.");
    }

    private void repairs() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You must repair your property. $25 per house, $100 per hotel.");
    }

    private void aUtil() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to the nearest utility.");
    }

    private void aBoard() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to Boardwalk.");
    }

    private void aIll() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to Illinois Avenue.");
    }

    private void aCharl() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to St. Charles Place.");
    }

    private void aRail() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to the nearest railroad.");
    }

    private void aGo() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Travel to Go. Collect $200.");
    }

    private void jail() {
        super.setAction(CardAction.JAIL);
        super.setCardDesc("BONK!!! Straight to horny jail.");
    }

    private void jailOut() {
        super.setAction(CardAction.JAILBREAK);
        super.setCardDesc("MISTRIAL! Get out of jail free.");
    }
}
