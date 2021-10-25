// Created 10/8/2021
/*
 *   program to build the server
 */

package Backend;

import io.javalin.Javalin;

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
    //todo: handlers for getState, roll, buy
    System.out.println("Server active on port: " + port);

    return 1;
  }

}
