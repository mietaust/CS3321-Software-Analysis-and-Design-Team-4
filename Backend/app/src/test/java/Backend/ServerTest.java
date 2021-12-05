package Backend;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Backend.Server;

public class ServerTest {

  String uuid1;
  String uuid2;
  Gson gson = new Gson();
  @BeforeAll
  public static void before() {
    //initialize and start server
    Server server = new Server();
    server.newServer();
  }
  @AfterEach
  public void after(){

  }
  @BeforeEach
  void beforeEach(){

  }

  // simple test to see if server responds
  @Test
  public void simplePing() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:7000/")).build();
    HttpResponse<String> responce = client.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println(responce.body());
    assertEquals("Connection made", responce.body(), "Server failed to start");
  }
  @Test
  public void getUpdateTest() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:7000/api/update")).build();
    HttpResponse<String> responce = client.send(req, HttpResponse.BodyHandlers.ofString());
    System.out.println(responce.body());
    assertDoesNotThrow(()->{
      gson.fromJson(responce.body(),GameState.class);
    });
  }
  @Test
  public void joinAndRollandEndTurntest() throws IOException, InterruptedException {
    URL url = new URL("http://localhost:7000/api/join");
    URLConnection con = url.openConnection();
    HttpURLConnection http = (HttpURLConnection)con;
    http.setRequestMethod("POST");
    http.setDoOutput(true);

    http.setRequestProperty("Content-Type", "text/strings; charset=UTF-8");
    http.connect();
    try(OutputStream os = http.getOutputStream()) {
      assertDoesNotThrow(()->{
        os.write("jeff1111".getBytes(StandardCharsets.UTF_8));
      });
    }
    uuid1 = http.getInputStream().toString();
    http.disconnect();
    URL url1 = new URL("http://localhost:7000/api/join");
    URLConnection con1 = url1.openConnection();
    HttpURLConnection http1 = (HttpURLConnection)con1;
    http1.setRequestMethod("POST");
    http1.setDoOutput(true);

    http1.setRequestProperty("Content-Type", "text/strings; charset=UTF-8");
    http1.connect();
    try(OutputStream os = http1.getOutputStream()) {
      assertDoesNotThrow(()->{
      os.write("berry1111".getBytes(StandardCharsets.UTF_8));
      });
    }
    http1.disconnect();


    URL url2 = new URL("http://localhost:7000/api/roll");
    URLConnection con2 = url2.openConnection();
    HttpURLConnection http2 = (HttpURLConnection)con2;
    http2.setRequestMethod("POST");
    http2.setDoOutput(true);

    http2.setRequestProperty("Content-Type", "text/strings; charset=UTF-8");
    http2.connect();
    try(OutputStream os = http2.getOutputStream()) {
      assertDoesNotThrow(()-> {
        os.write(uuid1.getBytes(StandardCharsets.UTF_8));
      });
    }
    http2.disconnect();
// Do something with http.getInputStream()
  }



}
