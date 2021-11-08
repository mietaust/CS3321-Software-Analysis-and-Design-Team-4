// Created 10/8/2021
/*
 *   program to build the server
 */

package Backend;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import com.google.gson.Gson;

import static io.javalin.apibuilder.ApiBuilder.before;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;
import static java.util.Objects.isNull;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Server {

  // port number to attach server to
  private final int port = 7000;

  // Server
  // initializer for Server
  Server() {
  }


  // newServer
  // create a new server
  /*
   *   output: 1 for success, 0 for failure
   */
  //TODO add 0 return on server initialization failure
  public int newServer() {
    System.out.println("Building Server");

    // create server (named "server")
    Javalin server = Javalin.create().start(port);

    // GET request handler
    server.get("/", ctx -> ctx.result("Connection made"));

    //temporary variable for active players
    List<NewPlayer> players = new LinkedList<>();
    Gson g = new Gson();

    //gamestate variable for use / testing? <-- TODO: DISCUSS IN DISCORD
    GameState bigolgame = GameState.getInstance();
    bigolgame.player1 = new Player("bingus");
    bigolgame.player2 = new Player("dingus");

    //serializer details
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    //GAMEPLAY REQUEST HANDLERS

    //new player handler
    server.routes(() -> {
      post("/api/join", ctx -> {
        System.out.println(GameState.getInstance().getPlayercount());
        Backend.Player newPlayer = new Player(ctx.body());
        System.out.println("received new player " + newPlayer.getName() + ", assigned ID " + newPlayer.getId() + ".");
        if(GameState.getInstance().getPlayercount() == 0){
          GameState.getInstance().player1 = newPlayer;
          GameState.getInstance().setPlayercount(1);
        }else if(GameState.getInstance().getPlayercount() == 1){
          GameState.getInstance().player2 = newPlayer;
          GameState.getInstance().gamestart = true;
          GameState.getInstance().setPlayercount(2);
          GameState.getInstance().setTurn(GameState.getInstance().player1);
        }else{
          System.out.println("hey we're here");
          //game is full until we make it >2 players. shouldn't be too hard just haven't yet.
        }
        ctx.result(newPlayer.getId().toString());
        //TODO change logic later on when the rest of the game is more defined - Eventually NewPlayer won't exist
//        try {
//          //NewPlayer np = g.fromJson(ctx.body(), NewPlayer.class);
//          Player newP = new Player(ctx.body());
//          if (players.contains(np)) {
//            //change name on the server side i guess lol
//          } else {
//            players.add(np);
//            System.out.println("Player " + np.getPname() + " has joined.");
//          }
//        } catch (Exception e) {
//          //handle non-json requests, shouldn't happen but good to have
//        }

      });
    });

    //player purchase house handler
    server.routes(() -> {
      get("/api/purchase/house", ctx -> {
        //handle game logic on current player submitting a buy house request on the property they're currently on
        UUID idFromSender = UUID.fromString(g.fromJson(ctx.body(),String.class));
        if (idFromSender.equals(GameState.getInstance().turn.getId())) {
          Gameplay.buildHouse(GameState.getInstance().player1);
        }


      });
    });

    //player purchase hotel handler
    server.routes(() -> {
      post("/api/purchase/hotel", ctx -> {
        UUID idFromSender = UUID.fromString(ctx.body());
        if (idFromSender.equals(GameState.getInstance().turn.getId())) {
          Gameplay.buildHotel(GameState.getInstance().turn);
          //handle game logic on current player submitting a buy hotel request on the property they're currently on
        }


      });
    });

    //player roll dice handler
    server.routes(() -> {
      post("/api/roll", ctx -> {
        System.out.println(ctx.body());
        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        System.out.println(parsedString);
        System.out.println(GameState.getInstance().turn.getId());
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){
          System.out.println("Got good request from UUID: " + GameState.getInstance().turn.getId());

          Gameplay.roll(GameState.getInstance().turn);

          if(idFromSender.equals(GameState.getInstance().player1.getId())){
            //set new player to player 2
            GameState.getInstance().setTurn(GameState.getInstance().player2);
          }else if ((idFromSender.equals(GameState.getInstance().player2.getId()))){
            //set new player to player 1
            GameState.getInstance().setTurn(GameState.getInstance().player1);
          }


        }else{
          System.out.println("Received bad request. Pass on game logic execution.");
        }
        //handle game logic on current player submitting a buy hotel request on the property they're currently on

      });
    });

    //client request board update handler
    server.routes(() -> {
      get("/api/update", ctx -> {
        //package the gamestate into json and send it as the response to this get request.
        System.out.println("Received an update request.");
        String l = g.toJson(GameState.getInstance());
        ctx.result(l);
        //System.out.println(l);
      });
    });

    System.out.println("Server active on port: " + port);

    return 1;
  }


}
