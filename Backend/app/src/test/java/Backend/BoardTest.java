package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void getInstance() {
        Space [] board = Board.getInstance();
        assertEquals(40, board.length);

    }


    @Test
    void getSpaceNames() {
        Space [] board = Board.getInstance();
        assertEquals("GO", board[0].getName());
        assertEquals("Free Parking", board[20].getName());

    }
}