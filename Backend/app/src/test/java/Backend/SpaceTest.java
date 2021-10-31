package Backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {

    @Test
    void isProperty() {
        Property testProperty = new Property("test", 0, 200, 30);

    }


    @Test
    void getName() {
        Space testSpace = new Space("test", 7);
        assertEquals("test", testSpace.getName());
    }

    @Test
    void getLocation() {
        Space testSpace = new Space("test", 5);
        assertEquals(5, testSpace.getLocation());
    }
}