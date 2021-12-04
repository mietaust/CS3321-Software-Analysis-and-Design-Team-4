package Backend;

import static org.junit.jupiter.api.Assertions.*;


import Backend.Card.CardType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class GameplayTest {

  GameState game = GameState.getInstance();

  @BeforeEach
  void beforeEach() {
    System.out.println("this is the timestamp");
    Gameplay.reset();
    game = GameState.getInstance();
  }

  @Test
  void turnSwapTest() {
    Gameplay.endTurn();
    assertEquals(game.player2, game.getTurn(), "The active player has failed to swap.");
  }

  @Test
  void rollTest() {
    Gameplay.roll(game.player1);

    assertTrue(game.rolled, "The player has rolled and was allowed to roll again.");
  }

  @Test
  void endStateTest() {
    game.player1.setAccountBalance(
        -1000);//negative mode large to ensure that a card draw can't break the test
    Gameplay.roll(game.player1);
    assertEquals(game.player2, game.getWinner());
  }

  @Test
  void testBuySuccess() {
    Gameplay.roll(game.player1);
    game.player1.setPosition(1);
    Gameplay.buy(game.player1);
    assertEquals(1, game.player1.getPropertyOwned().size(), "Player 1 should own one property.");
  }

  @Test
  void testBuyWrongSpace() {
    Gameplay.roll(game.player1);
    game.player1.setPosition(2);
    Gameplay.buy(game.player1);
    assertEquals(0, game.player1.getPropertyOwned().size(), "Player 1 should own no property.");
  }

  //jail tests
  @Test
  void testLandOnJail() {
    game.player1.setPosition(30);
    Gameplay.checkPosition(game.player1);
    assertTrue(game.player1.isInJail(), "Player 1 should be in jail");
  }

  @Test
  void testJailPosition() {
    game.player1.setPosition(30);
    Gameplay.checkPosition(game.player1);
    assertTrue(game.player1.getPosition() == 10, "Player 1 should be in jail and on the jail spot");
  }

  @Test
  void testGOOJCard() {
    CommunityChest testCard = new CommunityChest("br", 2, CardType.COMMUNITY);
    testCard.community(4);
    testCard.performAction(testCard.getAction(), game.player1);
    testCard.performAction(testCard.getAction(), game.player1);
    game.player1.setPosition(30);
    Gameplay.checkPosition(game.player1);
    Gameplay.roll(game.player1);
    assertFalse(game.player1.isInJail() && game.player1.getOOJCards() == 1,
        "Player 1 should have used a GOOJ card to escape jail.");
  }

  @Test
  void testBreakOutOrBail() {
    //this will test either that the player rolls a double and breaks out or is removed after 3 rolls.
    game.player1.setPosition(30);
    Gameplay.checkPosition(game.player1);
    double money = game.player1.getAccountBalance();
    for (int x = 0; x < 3; x++) {
      Gameplay.roll(game.player1);
      if(!game.player1.isInJail()){
        break;
      }
    }
    assertTrue((!game.player1.isInJail()) ||( money!=game.player1.getAccountBalance()));
  }


}
