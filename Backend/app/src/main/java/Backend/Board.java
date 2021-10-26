package Backend;

//shell class for later
public class Board {

    private int i = 0;

    // the number of spaces
    private int numberOfSpaces = 39;

    /**
     * List of spaces on the game board
     */
    final Object[] spaceNames = {
                                "GO",
                                new Street("Mediterranean Avenue", i, Color.BROWN, 60, 2, 50, new int[]{10, 30, 90, 160, 250}),
                                new CommunityChest("Community Chest 1", i, Card.CardType.COMMUNITY),
                                new Street("Baltic Avenue", i, Color.BROWN, 60, 4, 50, new int[]{20, 60, 180, 320, 450}),
                                "INCOME TAX",
                                new Railroad("Reading Railroad", i, 200, 25),
                                new Street("Oriental Avenue", i, Color.LIGHTBLUE, 100, 6, 50, new int[]{30, 90, 270, 400, 550}),
                                new Chance("Chance Pink", i, Card.CardType.CHANCE),
                                new Street("Vermont Avenue", i, Color.LIGHTBLUE, 100, 6, 50, new int[]{30, 90, 270, 400, 550}),
                                new Street("Connecticut Avenue", i, Color.LIGHTBLUE, 120, 8, 50, new int[]{40, 100, 300, 450, 600}),
                                "JAIL",
                                new Street("St. Charles Place", i, Color.PURPLE, 140, 10, 100, new int[]{50, 150, 450, 625, 750}),
                                new Utility("Electric Company", i, 150, 0),
                                new Street("States Avenue", i, Color.PURPLE, 140, 10, 100, new int[]{50, 150, 450, 625, 750}),
                                new Street("Virginia Avenue", i, Color.PURPLE, 160, 12, 100, new int[]{60, 180, 500, 700, 900}),
                                new Railroad("Pensylvania Railroad", i, 200, 25),
                                new Street("St. James Place", i, Color.ORANGE, 180, 14, 100, new int[]{70, 200, 550, 750, 950}),
                                new CommunityChest("Community Chest 2", i, Card.CardType.COMMUNITY),
                                new Street("Tennessee Avenue", i, Color.ORANGE, 180, 14, 100, new int[]{70, 200, 550, 750, 950}),
                                new Street("New York Avenue", i, Color.ORANGE, 200, 16, 100, new int[]{80, 220, 600, 800, 1000}),
                                "FREE PARKING",
                                new Street("Kentucky Avenue", i, Color.RED, 220, 18, 150, new int[]{90, 250, 700, 875, 1050}),
                                new Chance("Chance Blue", i, Card.CardType.CHANCE),
                                new Street("Indiana Avenue", i, Color.RED, 220, 18, 150, new int[]{90, 225, 700, 875, 1050}),
                                new Street("Illinois Avenue", i, Color.RED, 240, 20, 150, new int[]{90, 300, 700, 875, 1050}),
                                new Railroad("B&O Railroad", i, 200, 25),
                                new Street("Atlantic Avenue", i, Color.YELLOW, 260, 22, 150, new int[]{110, 330, 800, 975, 1150}),
                                new Street("Ventnor Avenue", i, Color.YELLOW, 260, 22, 150, new int[]{110, 330, 800, 975, 1150}),
                                new Utility("Water Works", i, 150, 0 ),
                                new Street("Marvin Gardens", i, Color.YELLOW, 280, 24, 150, new int[]{120, 360, 850, 1025, 1150}),
                                "GO TO JAIL",
                                new Street("Pacific Avenue", i, Color.GREEN, 300, 26, 200, new int[]{130, 390, 850, 1025, 1200}),
                                new Street("North Carolina Avenue", i, Color.GREEN, 300, 26, 200, new int[]{130, 390, 900, 1100, 1275}),
                                new CommunityChest("Community Chest 3", i, Card.CardType.COMMUNITY),
                                new Street("Pennsylvania Avenue", i, Color.GREEN, 320, 28, 200, new int[]{150, 450, 1000, 1200, 1400}),
                                new Railroad("Short Line", i, 200, 25),
                                new Chance("Chance", i, Card.CardType.CHANCE),
                                new Street("Park Place", i, Color.DARKBLUE, 350, 35, 200, new int[]{175, 500, 1100, 1300, 1500}),
                                "LUXURY TAX",
                                new Street("Boardwalk", i, Color.LIGHTBLUE, 400, 50, 200, new int[]{200, 600, 1400, 1700, 2000})};

    /**
     * Constructor
     */
    public Board()
    {
        for(int position = 0; position < numberOfSpaces; position++)
        {
            // build all the instances in the array
            Object street = spaceNames[position];
            i++;
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.spaceNames.length);
    }
}
