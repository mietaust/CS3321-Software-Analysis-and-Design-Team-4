package Backend;


import Backend.Card.CardType;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

public class GameState {

  private static GameState gamestate;
  @Getter
  private Space[] board;
  @Getter
  @Setter
  private boolean error = false;

  private ArrayList<String> log;
  Player player1;
  Player player2;
  @Getter
  @Setter
  private int playerCount = 0;
  boolean gameStart = false;
  @Getter
  @Setter
  Player turn;
  @Getter
  @Setter
  Boolean rolled = false;
  CommunityChest communityChest = new CommunityChest("Chest", 3, CardType.COMMUNITY);


  public void log(String newLog) {
    log.add(newLog);
    System.out.println(newLog);
  }

  private GameState() {

    board = Board.getInstance();
    //todo remove the player instantiations and make an actual method for that.
    player1 = new Player("p1");
    player2 = new Player("p2");
    turn = player1;
    player1.addToAccount(1500);
    log = new ArrayList<>();
    log.add("The game is now starting!");
  }

  public static GameState getInstance() {
    if (gamestate == null) {
      gamestate = new GameState();
    }
    return gamestate;
  }

  public static void resetState() {
    gamestate = new GameState();
  }

}


