package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void getRent() {
        Utility utilityTest = new Utility("Electric Company", 12, 150, 0);
        Dice dice = Dice.getInstance();
        Player playerTest = new Player("Test");
        playerTest.buy(utilityTest);

        assertEquals(4 * dice.getTotal(), utilityTest.getRent(utilityTest));


    }

    @Test
    void getOwner() {
        Utility utilityTest = new Utility("Electric Company-2", 10, 150, 5);
        assertNull(utilityTest.getOwner());
        Player playerTest = new Player("Test");
        utilityTest.setOwner(playerTest);
        assertEquals(playerTest, utilityTest.getOwner());

    }

    @Test
    void setOwner() {
        Utility utilityTest = new Utility("Electric Company-3", 9, 15, 20);
        Player playerTest = new Player("Test");
        utilityTest.setOwner(playerTest);
        assertEquals(playerTest, utilityTest.getOwner());
    }
}