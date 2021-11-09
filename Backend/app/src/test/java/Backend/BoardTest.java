package Backend;

//import testing libraries
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @BeforeAll
    public static void before(){
        System.out.println("Beginning testing on Board:");
        //um... idk
    }

    // tests to confirm Board's returned instance data is of the right type
    @Test
    public void testInstanceType() {
        Board board = new Board();
        Space[] instances = board.getInstance();
        //System.out.println("type is... :" + instances[0].getClass().getSimpleName());
        assertEquals(instances[0].getClass().getSimpleName(), "Space");
    }


}
