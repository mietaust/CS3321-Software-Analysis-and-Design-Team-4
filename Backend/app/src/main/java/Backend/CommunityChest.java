package Backend;
import lombok.Getter;
import lombok.Setter;
public class CommunityChest extends Card {

    //Inspiration from https://github.com/fjricci/monopoly

    /**
     * Constructor
     *
     * @param name     Name of the space
     * @param location The postion on the gameboard
     */
    public CommunityChest(String name, int location) {
        super(name, location);
    }

    //variable and field declaration

    //generate community cards
    private void community(int a) {
        CardType type = CardType.COMMUNITY;
        switch (a) {
            case 0:
                advance();
                break;
            case 1:
                bank();
                break;
            case 2:
                doctor();
                break;
            case 3:
                stock();
                break;
            case 4:
                jailOut();
                break;
            case 5:
                jail();
                break;
            case 6:
                holiday();
                break;
            case 7:
                taxRefund();
                break;
            case 8:
                birthday();
                break;
            case 9:
                lifeInsurance();
                break;
            case 10:
                hospital();
                break;
            case 11:
                school();
                break;
            case 12:
                consultancy();
                break;
            case 13:
                repairs();
                break;
            case 14:
                contest();
                break;
            case 15:
                inherit();
                break;
            default:
                break;
        }
    }

    private void inherit() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("You have inherited $100!");
        super.setCardValue(100);
    }

    private void contest() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("You just won 4th place in your local beauty contest! Your winnings are $100.");
        super.setCardValue(100);
    }

    private void repairs() {
        super.setAction(CardAction.LOSEMONEY); //add enum for losing / gaining money with a multiple
        super.setCardDesc("You must pay $40 per house or $115 per hotel in repair costs.");
        super.setCardValue(0);
    }

    private void consultancy() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You receive a private consultation fee of $25.");
        super.setCardValue(25);
    }

    private void school() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You owe $50 in tuition.");
        super.setCardValue(50);
    }

    private void hospital() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You broke your pinkie toe! Pay $100.");
        super.setCardValue(100);
    }

    private void lifeInsurance() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("Life insurance matured. Gain $100.");
        super.setCardValue(10);
    }

    private void birthday() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("Happy Birthday! Collect $10 from each player.");
        super.setCardValue(10);
    }

    private void taxRefund() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You gave the government an interest free loan of $20.");
        super.setCardValue(20);
    }

    private void holiday() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("Holiday fund matured. Collect $100.");
        super.setCardValue(100);
    }

    private void jail() {
        super.setAction(CardAction.JAIL);
        super.setCardDesc("BONK!!! Straight to horny jail.");
        super.setCardValue(0);
    }

    private void jailOut() {
        super.setAction(CardAction.JAILBREAK);
        super.setCardDesc("MISTRIAL! Get out of jail free.");
        super.setCardValue(0);
    }

    private void stock() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("STONKS! You gain $50 from the stock market.");
        super.setCardValue(50);
    }

    private void doctor() {
        super.setAction(CardAction.LOSEMONEY);
        super.setCardDesc("You've got ligma. $50 doctor's fee.");
        super.setCardValue(50);
    }

    private void bank() {
        super.setAction(CardAction.ADDMONEY);
        super.setCardDesc("You wake up to an extra $200 dollars in your bank account. Don't tell anyone.");
        super.setCardValue(200);
    }

    private void advance() {
        super.setAction(CardAction.MOVE);
        super.setCardDesc("Advance to go. Collect $200.");
        super.setCardValue(0);
    }
}
