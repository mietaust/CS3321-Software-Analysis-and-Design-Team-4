package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RailroadTest {

    @Test
    void getRent() {
        Player playerTest = new Player("Test");
        Railroad railroad = new Railroad("Reading Railroad Test", 5, 200, 25);
        playerTest.buy(railroad);

        assertEquals(playerTest, railroad.getOwner());
    }
}