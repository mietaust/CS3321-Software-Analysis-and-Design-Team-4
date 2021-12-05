package Backend;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class RentTest {
  GameState game = GameState.getInstance();

  @BeforeEach
  void beforeEach() {
    System.out.println("Resetting for next test...");
    Gameplay.reset();
    game = GameState.getInstance();
    Gameplay.roll(game.player1);
    game.player1.setPosition(3);
    Gameplay.buy(game.player1);
    game.player1.setPosition(1);
    Gameplay.buy(game.player1);
  }
 //space rents should be :2, 10, 30, 90, 160, 250
  @Test
  void noHouseRentTest(){
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-2);
  }

  @Test
  void oneHouseRentTest(){
    Gameplay.buildHouse(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-10);
  }
  @Test
  void twoHouseRentTest(){
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-30);
  }
  @Test
  void threeHouseRentTest(){
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-90);
  }
  @Test
  void fourHouseRentTest(){
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-160);
  }
  @Test
  void hotelRentTest(){
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHouse(game.player1);
    Gameplay.buildHotel(game.player1);
    System.out.println(((Street) game.getBoard()[1]).getHouseNumber());
    System.out.println(((Street) game.getBoard()[1]).getHotelNumber());
    double money = game.player2.getAccountBalance();
    game.player2.setPosition(1);
    Gameplay.checkPosition(game.player2);
    System.out.println(game.player2.getAccountBalance());
    assertTrue(game.player2.getAccountBalance()==money-250);
  }



}
