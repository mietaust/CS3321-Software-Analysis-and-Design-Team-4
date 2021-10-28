package Backend;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CommunityChestTest {

    //Community Chest Card Test

    @BeforeAll
    public static void before(){
        //uhhhh idk
    }

    //tests to make sure card responses are accurate to the numbers passed in.
    @Test
    public void advanceGo() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(0);
        assertEquals(Card.CardAction.MOVE, test.getAction());
    }
    @Test
    public void bank() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(1);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void doctor() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(2);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void stock() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(3);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void jailOut() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(4);
        assertEquals(Card.CardAction.JAILBREAK, test.getAction());
    }
    @Test
    public void jail() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(5);
        assertEquals(Card.CardAction.JAIL, test.getAction());
    }
    @Test
    public void holiday() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(6);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void taxrefund() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(7);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void birthday() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(8);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void lifeInsurance() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(9);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void hospital() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(10);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void school() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(11);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void consultancy() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(12);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void repairs() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(13);
        assertEquals(Card.CardAction.LOSEMONEY, test.getAction());
    }
    @Test
    public void contest() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(14);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
    @Test
    public void inherit() {
        CommunityChest test = new CommunityChest("testcard",(0), Card.CardType.COMMUNITY);
        test.community(15);
        assertEquals(Card.CardAction.ADDMONEY, test.getAction());
    }
}
