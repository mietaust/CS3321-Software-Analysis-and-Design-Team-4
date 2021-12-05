package Backend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CommunityChestTest {

  GameState game = GameState.getInstance();
  //Community Chest Card Test

  @BeforeEach
  public void beforeEach() {
    System.out.println("Resetting for next test...");
    Gameplay.reset();
    game = GameState.getInstance();
  }

  //tests to make sure card responses are accurate to the numbers passed in.
  @Test
  public void advanceGo() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(0);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  @Test
  public void bank() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(1);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void doctor() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(2);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void stock() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(3);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void jailOut() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(4);
    assertEquals(Card.CardAction.JAILBREAK, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertTrue(game.player1.getOOJCards() > 0);

  }

  @Test
  public void jail() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(5);
    assertEquals(Card.CardAction.JAIL, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(10, game.player1.getPosition());
    assertTrue(game.player1.isInJail());

  }

  @Test
  public void holiday() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(6);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void taxrefund() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(7);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void birthday() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(8);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void lifeInsurance() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(9);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void hospital() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(10);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void school() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(11);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void consultancy() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(12);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void repairs() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(13);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void contest() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(14);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void inherit() {
    CommunityChest test = new CommunityChest("testcard", (0), Card.CardType.COMMUNITY);
    test.community(15);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }
}
