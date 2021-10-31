package Backend;

import Backend.Board;
import lombok.Getter;
import lombok.Setter;

public class GameState {

  private static GameState gamestate;
  @Getter
  private static Space[] board;
  @Getter
  @Setter
  private static boolean error = false;
  static Player player1;
  static Player player2;
  CommunityChest communityChest;

  private GameState() {

    board = Board.getInstance();
    //todo remove the player instantiations and make an actual class for that.
    player1 = new Player("p1");
    player1.addToAccount(1500);
  }

  public static GameState getInstance() {
    if (gamestate == null) {
      gamestate = new GameState();
    }
    return gamestate;
  }
  public static void resetState(){
    gamestate = new GameState();
  }

  public static void main(String[] args) {

    board = Board.getInstance();
    for (int x = 0; x < board.length; x++) {
      System.out.println(board[x]);

    }

  }

}
