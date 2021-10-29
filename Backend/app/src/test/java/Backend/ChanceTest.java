package Backend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ChanceTest {

    //Community Chest Card Test

    @BeforeAll
    public static void before(){
        //uhhhh idk
    }

    //tests to make sure card responses are accurate to the numbers passed in.
    @Test
    public void boardwalk() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(0);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void go() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(1);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void illinois() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(2);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void charles() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(3);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void railroad() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(4);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void utility() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(5);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void dividend() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(6);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void goback() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(7);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void speeding() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(8);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void reading() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(9);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void elected() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(10);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void loan() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(11);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void jail() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(12);
        assertEquals(Card.CardAction.JAIL, test.getAction());
    }
    @Test
    public void jailout() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(13);
        assertEquals(Card.CardAction.JAILBREAK, test.getAction());
    }
    @Test
    public void repair() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(14);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void crossword() {
        Chance test = new Chance("testcard",(0), Card.CardType.COMMUNITY);
        test.chance(15);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
}