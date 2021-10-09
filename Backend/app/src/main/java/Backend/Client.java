// Created 10/9/2021
/*
*   client program which will connect to the server
*/

package Backend;

import io.javalin.Javalin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Client {

    //Client
    //create new instance of Client
    Client()
    {
        System.out.println("Client active");
    }


    //get
    //asynchronous function to run HTTP GET request
    /*
    *   input: URI of address to send GET request to (String)
    *   return: asynchronous return from GET request to inputted URI
    */
    //TODO get this GET request to work.  My guess is that it is not waiting until the server activates (in App) before it tries to access that server.
    public CompletableFuture<String> get(String uri) {
        System.out.println("Sending GET request");

        //build the client
        HttpClient client = HttpClient.newHttpClient();

        //assemble the request script
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //asynchronous return for sending the request from client
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
    }
}
