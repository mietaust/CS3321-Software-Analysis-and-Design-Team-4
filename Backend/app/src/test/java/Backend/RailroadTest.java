package Backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailroadTest {

  GameState game = GameState.getInstance();

  @BeforeEach
  void beforeEach() {
    System.out.println("Resetting for next test...");
    Gameplay.reset();
    game = GameState.getInstance();
    Gameplay.roll(game.player1);

  }

  @Test
  void getRent() {
    Player playerTest = new Player("Test");
    Railroad railroad = new Railroad("Reading Railroad Test", 5, 200, 25);
    playerTest.buy(railroad);

    assertEquals(playerTest, railroad.getOwner());
  }

  @Test
  void testRailRoadNoOwner() {
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(5);
    Gameplay.checkPosition(game.player2);
    assertTrue(game.player2.getAccountBalance() == money);
  }

  @Test
  void testRailRoadRent() {
    game.player1.setPosition(5);
    Gameplay.buy(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(5);
    Gameplay.checkPosition(game.player2);
    assertTrue(game.player2.getAccountBalance() == money - 25);
  }

  @Test
  void test2RailroadsRent() {
    game.player1.setPosition(5);
    Gameplay.buy(game.player1);
    game.player1.setPosition(15);
    Gameplay.buy(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(5);
    Gameplay.checkPosition(game.player2);
    assertTrue(game.player2.getAccountBalance() == money - 50);
  }

  @Test
  void test3RailroadsRent() {
    game.player1.setPosition(5);
    Gameplay.buy(game.player1);
    game.player1.setPosition(15);
    Gameplay.buy(game.player1);
    game.player1.setPosition(25);
    Gameplay.buy(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(5);
    Gameplay.checkPosition(game.player2);
    assertTrue(game.player2.getAccountBalance() == money - 100);
  }

  @Test
  void test4RailroadsRent() {
    game.player1.setPosition(5);
    Gameplay.buy(game.player1);
    game.player1.setPosition(15);
    Gameplay.buy(game.player1);
    game.player1.setPosition(25);
    Gameplay.buy(game.player1);
    game.player1.setPosition(35);
    Gameplay.buy(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(5);
    Gameplay.checkPosition(game.player2);
    assertTrue(game.player2.getAccountBalance() == money - 200);
  }
}