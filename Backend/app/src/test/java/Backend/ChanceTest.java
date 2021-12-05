package Backend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ChanceTest {

  GameState game = GameState.getInstance();

  @BeforeEach
  public void beforeEach() {
    System.out.println("Resetting for next test...");
    Gameplay.reset();
    game = GameState.getInstance();
  }

  //tests to make sure card responses are accurate to the numbers passed in.
  @Test
  public void boardwalk() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(0);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  @Test
  public void go() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(1);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  @Test
  public void illinois() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(2);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  @Test
  public void charles() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(3);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  //    @Test
//    public void railroad() {
//        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
//        test.chance(4);
//        assertEquals(Card.CardAction.MOVE, test.getAction());
//    }
//    @Test
//    public void utility() {
//        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
//        test.chance(5);
//        assertEquals(Card.CardAction.MOVE, test.getAction());
//    }
  @Test
  public void dividend() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(4);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  //    @Test
//    public void goback() {
//        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
//        test.chance(7);
//        assertEquals(Card.CardAction.MOVE, test.getAction());
//    }
  @Test
  public void speeding() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(5);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void reading() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(6);
    assertEquals(Card.CardAction.MOVE, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(test.getCardValue(), game.player1.getPosition());
  }

  @Test
  public void elected() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(7);
    assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money - test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void loan() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(8);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }

  @Test
  public void jail() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(9);
    assertEquals(Card.CardAction.JAIL, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertEquals(10, game.player1.getPosition());
    assertTrue(game.player1.isInJail());
  }

  @Test
  public void jailout() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(10);
    assertEquals(Card.CardAction.JAILBREAK, test.getAction());
    test.performAction(test.getAction(), game.player1);
    assertTrue(game.player1.getOOJCards() > 0);
  }

  //    @Test
//    public void repair() {
//        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
//        test.chance(14);
//        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
//    }
  @Test
  public void crossword() {
    Chance test = new Chance("testcard", (0), Card.CardType.COMMUNITY);
    test.chance(11);
    assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    double money = game.player1.getAccountBalance();
    test.performAction(test.getAction(), game.player1);
    assertEquals(money + test.getCardValue(), game.player1.getAccountBalance(),
        "The player should have been given an amount equal to the card value");
  }
}