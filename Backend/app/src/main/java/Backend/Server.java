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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Server {
  boolean hasRolled = false;
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

    //serializer details

    Gson g = new Gson();
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    //GAMEPLAY REQUEST HANDLERS

    //new player handler
    server.routes(() -> {
      post("/api/join", ctx -> {
        System.out.println(GameState.getInstance().getPlayerCount());
        Backend.Player newPlayer = new Player(ctx.body());
        System.out.println("received new player " + newPlayer.getName() + ", assigned ID " + newPlayer.getId() + ".");
        if(GameState.getInstance().getPlayerCount() == 0){
          GameState.getInstance().player1 = newPlayer;
          GameState.getInstance().setPlayerCount(1);
        }else if(GameState.getInstance().getPlayerCount() == 1){
          GameState.getInstance().player2 = newPlayer;
          GameState.getInstance().gameStart = true;
          GameState.getInstance().setPlayerCount(2);
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
      post("/api/purchase/house", ctx -> {
        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){
          System.out.println("Got good house request from UUID: " + GameState.getInstance().turn.getId());
          Gameplay.buildHouse(GameState.getInstance().turn);
        }else{
          System.out.println("Received bad house request. Pass on game logic execution.");
        }

      });
    });

    //player purchase hotel handler
    server.routes(() -> {
      post("/api/purchase/hotel", ctx -> {

        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){
          System.out.println("Got good hotel request from UUID: " + GameState.getInstance().turn.getId());
          Gameplay.buildHotel(GameState.getInstance().turn);
        }else{
          System.out.println("Received bad hotel request. Pass on game logic execution.");
        }
      });
    });

    //player purchase property handler
    server.routes(() -> {
      post("/api/purchase/property", ctx -> {
        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){
          System.out.println("Got good property purchase request from UUID: " + GameState.getInstance().turn.getId());
          Gameplay.buy(GameState.getInstance().turn);
        }else{
          System.out.println("Received bad property purchase request. Pass on game logic execution.");
        }

      });
    });

    //player roll dice handler
    server.routes(() -> {
      post("/api/roll", ctx -> {
        System.out.println(ctx.body());
        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){

          if(!hasRolled) {
            System.out.println("Got good request from UUID: " + GameState.getInstance().turn.getId());
            Gameplay.roll(GameState.getInstance().turn);
            hasRolled = true;
          }
        }else {
          System.out.println("Received bad roll request. Pass on game logic execution.");
        }
      });
    });


    //player end turn handler
    server.routes(() -> {
      post("/api/end", ctx -> {
        //parse provided uuid TODO add error handling for non-uuid reception
        String parsedString = ctx.body().substring(1, (ctx.body().length()-1));
        UUID idFromSender = UUID.fromString(parsedString);

        //check passed uuid against current player uuid then update player TODO player change should be handled on turn end, not simply dice roll
        if(idFromSender.equals(GameState.getInstance().turn.getId())){
          System.out.println("Got good end turn request from UUID: " + GameState.getInstance().turn.getId());
          hasRolled = false;
          if(idFromSender.equals(GameState.getInstance().player1.getId())){
            //set new player to player 2
            GameState.getInstance().setTurn(GameState.getInstance().player2);
          }else if ((idFromSender.equals(GameState.getInstance().player2.getId()))){
            //set new player to player 1
            GameState.getInstance().setTurn(GameState.getInstance().player1);
          }
        }else{
          System.out.println("Received bad end turn request. Pass on game logic execution.");
        }
      });
    });


    //client request board update handler
    server.routes(() -> {
      get("/api/update", ctx -> {
        //package the gamestate into json and send it as the response to this get request.
        //This got too verbose. System.out.println("Received an update request.");
        String l = g.toJson(GameState.getInstance());
        ctx.result(l);
        //System.out.println(l);
      });
    });

    System.out.println("Server active on port: " + port);

    return 1;
  }

}
