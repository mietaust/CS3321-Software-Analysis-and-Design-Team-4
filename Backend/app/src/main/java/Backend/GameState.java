package Backend;

import Backend.Board;
import Backend.Card.CardType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;

public class GameState {

  private static GameState gamestate;
  @Getter
  private  Space[] board;
  @Getter
  @Setter
  private boolean error = false;
  Player player1;
  Player player2;
  @Getter
  @Setter
  private int playercount = 0;
  boolean gamestart = false;
  @Getter
  @Setter
  Player turn;
  @Getter
  @Setter
  Boolean rolled = false;
  CommunityChest communityChest = new CommunityChest("Chest", 3, CardType.COMMUNITY);

  private GameState() {

    board = Board.getInstance();
    //todo remove the player instantiations and make an actual method for that.
    player1 = new Player("p1");
    player2 = new Player("p2");
    turn = player1;
    player1.addToAccount(1500);
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

  public static void main(String[] args) {
    GameState gs = GameState.getInstance();
    System.out.println(gs.turn.getName());

    GsonBuilder builder = new GsonBuilder();
    builder.serializeNulls();
    Gson gson = builder.create();
    System.out.println(gson.toJson(gs));


  }

}


