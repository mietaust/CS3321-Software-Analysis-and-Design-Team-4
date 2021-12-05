package Backend;

import lombok.Getter;
import lombok.Setter;

public class CommunityChest extends Card {

  //Inspiration from https://github.com/fjricci/monopoly

  /**
   * Constructor
   *
   * @param name     Name of the space
   * @param location The position on the gameboard
   */
  public CommunityChest(String name, int location, CardType cardType) {
    super(name, location, cardType);
  }

  //variable and field declaration

  //generate community cards

  /**
   * Initializes a Community card
   *
   * @param cardNumber Takes in card value
   */
  void community(int cardNumber) {
    CardType type = CardType.COMMUNITY;
    switch (cardNumber) {
      case 0 -> advance();
      case 1 -> bank();
      case 2 -> doctor();
      case 3 -> stock();
      case 4 -> jailOut();
      case 5 -> jail();
      case 6 -> holiday();
      case 7 -> taxRefund();
      case 8 -> birthday();
      case 9 -> lifeInsurance();
      case 10 -> hospital();
      case 11 -> school();
      case 12 -> consultancy();
      case 13 -> repairs();
      case 14 -> contest();
      case 15 -> inherit();
      default -> {
      }
    }
  }

  private void inherit() {
    super.setAction(CardAction.ADDMONEY);
    super.setCardDesc("You have inherited $100!");
    super.setCardValue(100);
  }

  private void contest() {
    super.setAction(CardAction.ADDMONEY);
    super.setCardDesc(
        "You just won 4th place in your local beauty contest! Your winnings are $100.");
    super.setCardValue(100);
  }

  private void repairs() {
    super.setAction(CardAction.LOSEMONEY); //add enum for losing / gaining money with a multiple
    super.setCardDesc("You must pay $40 per house or $115 per hotel in repair costs.");
    super.setCardValue(0);
  }

  private void consultancy() {
    super.setAction(CardAction.ADDMONEY);
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
    super.setAction(CardAction.ADDMONEY);
    super.setCardDesc("You gave the government an interest free loan of $20.");
    super.setCardValue(20);
  }

  private void holiday() {
    super.setAction(CardAction.ADDMONEY);
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
    super.setCardDesc(
        "You wake up to an extra $200 dollars in your bank account. Don't tell anyone.");
    super.setCardValue(200);
  }

  private void advance() {
    super.setAction(CardAction.MOVE);
    super.setCardDesc("Advance to go. Collect $200.");
    super.setCardValue(0);
  }
}
