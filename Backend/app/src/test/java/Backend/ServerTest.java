package Backend;

import java.io.IOException;
import java.net.ResponseCache;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Backend.Server;

public class ServerTest {


  @BeforeAll
  public static void before() {
    //initialize and start server
    Server server = new Server();
    server.newServer();

  }

  // simple test to see if server responds
  @Test
  public void simplePing() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:7000/")).build();
    HttpResponse<String> responce = client.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println(responce.body());
    assertTrue(responce.body().equals("Connection made"), "Server failed to start");
  }


}
