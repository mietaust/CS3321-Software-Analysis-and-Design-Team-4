//
/*
 * Run both the Server and Client processes
 */

package Backend;

import io.javalin.Javalin;

//import client and server
import Backend.Server;
import Backend.Client;

import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Initialize the server
        Server server = new Server();
        server.newServer();

        System.out.println("\n\n");

        //initialize the client
        Client client = new Client();
        System.out.println("returned GET request: " + client.get("http://localhost:7000/") );

    }

}
