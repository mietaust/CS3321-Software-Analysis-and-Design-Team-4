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

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

import java.util.LinkedList;
import java.util.List;

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
        System.out.println("received");
        //TODO change logic later on when the rest of the game is more defined - Eventually NewPlayer won't exist
        try {
          NewPlayer np = g.fromJson(ctx.body(), NewPlayer.class);

          if (players.contains(np)) {
            //change name on the server side i guess lol
          } else {
            players.add(np);
            System.out.println("Player " + np.getPname() + " has joined.");
          }
        } catch (Exception e) {
          //handle non-json requests, shouldn't happen but good to have
        }
      });
    });

    //player purchase house handler
    server.routes(() -> {
      get("/api/purchase/house", ctx -> {
        //handle game logic on current player submitting a buy house request on the property they're currently on
        Gameplay.buildHouse(
            GameState.getInstance().player1);//todo figure out how to differintiate between requests.
      });
    });

    //player purchase hotel handler
    server.routes(() -> {
      get("/api/purchase/hotel", ctx -> {
        //handle game logic on current player submitting a buy hotel request on the property they're currently on
        Gameplay.buildHotel(GameState.getInstance().player1);
      });
    });

    //player roll dice handler
    server.routes(() -> {
      get("/api/roll", ctx -> {
        //handle game logic on current player submitting a buy hotel request on the property they're currently on
        Gameplay.roll(GameState.getInstance().player1);
      });
    });

    //client request board update handler
    server.routes(() -> {
      get("/api/update", ctx -> {
        //package the gamestate into json and send it as the response to this get request.
        System.out.println("Received an update request.");
        String l = g.toJson(bigolgame);
        System.out.println(bigolgame.player1.getName());
        ctx.result(l);
        System.out.println(l);
      });
    });

    System.out.println("Server active on port: " + port);

    return 1;
  }


}
