package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setAccountBalance() {
        Player playerTest = new Player("Testing");
        playerTest.setAccountBalance(200);
        assertEquals(200, playerTest.getAccountBalance());

    }

    @Test
    void move() {
        Player playerTest = new Player("Testing");
        playerTest.move(2);
        assertEquals(2, playerTest.getPosition());

        //Checks to see if value is added to
        // current position and never goes past 39
        playerTest.move(38);
        assertEquals(0, playerTest.getPosition());

    }

    @Test
    void buy() {
        Property testProperty = new Property("TestProp", 1, 30,2);
        Player playerTest = new Player("Testing");
        playerTest.setAccountBalance(200);
        playerTest.buy(testProperty);
        assertEquals(170, playerTest.getAccountBalance());
        assertEquals(1, playerTest.getPropertyOwned().size());

        playerTest.buy(new Property("TestProp", 1, 30,2));

    }

    @Test
    void ownAllStreetGroup() {
        Player playerTest = new Player("Testing");
        playerTest.setAccountBalance(30);
        playerTest.buy(new Street("test", 0, Color.BROWN, 10, 2, 50, new int[]{10, 30, 90, 160, 250}));
        playerTest.buy(new Street("test2", 1, Color.BROWN, 10, 2, 50, new int[]{10, 30, 90, 160, 250}));
        assertTrue(playerTest.ownAllStreetGroup(new Street("test", 0, Color.BROWN, 10, 2, 50, new int[]{10, 30, 90, 160, 250})));
        assertEquals(10,playerTest.getAccountBalance());
    }


    @Test
    void utilitiesOwned() {
        Player playerTest = new Player("Testing");
        playerTest.setAccountBalance(1000);
        playerTest.buy(new Utility("test", 12, 150, 0));
        assertEquals(1, playerTest.utilitiesOwned(new Utility("Electric Company", 12, 150, 0)));
    }

    @Test
    void railRoadsOwned() {
        Player playerTest = new Player("Testing");
        playerTest.setAccountBalance(500);
        playerTest.buy(new Railroad("testRailroad", 5, 200, 25));
        playerTest.buy(new Railroad("testRail", 5, 100, 35));
        assertEquals(2, playerTest.railRoadsOwned(new Railroad("testRailroad", 5, 200, 25)));
        assertEquals(200, playerTest.getAccountBalance());

    }

    @Test
    void getName() {
        Player playerTest = new Player("Testing");
        assertEquals("Testing", playerTest.getName());
    }

    @Test
    void getAccountBalance() {
        Player playerTest = new Player("Testing");
        assertEquals(0, playerTest.getAccountBalance());
    }

    @Test
    void getPosition() {
        Player playerTest = new Player("Testing");
        assertEquals(0, playerTest.getPosition());
    }

    @Test
    void isInJail() {
        Player playerTest = new Player("Testing");
        assertFalse(playerTest.isInJail());
    }

    @Test
    void getPropertyOwned() {
        Player playerTest = new Player("Testing");
        assertEquals(0, playerTest.getPropertyOwned().size());
    }

    @Test
    void setName() {
        Player playerTest = new Player("Testing");
        playerTest.setName("Daniel");
        assertEquals("Daniel", playerTest.getName());
    }

    @Test
    void setInJail() {
        Player playerTest = new Player("Testing");
        playerTest.setInJail(true);
        assertTrue(playerTest.isInJail());
        assertEquals(Constants.JAIL, playerTest.getPosition());
    }
}