package Backend;

import lombok.Getter;

//shell class for later
public class Board {

    // the number of spaces
    private final int numberOfSpaces = 40;

    /**
     * List of spaces on the game board
     */
    @Getter
     final Space[] spaceNames  =  {  new Space("GO", 0),
            new Street("Mediterranean Avenue", 1, Color.BROWN, 60, 2, 50, new int[]{10, 30, 90, 160, 250}),
            new CommunityChest("Community Chest 1", 2, Card.CardType.COMMUNITY),
            new Street("Baltic Avenue", 3, Color.BROWN, 60, 4, 50, new int[]{20, 60, 180, 320, 450}),
            new Space("Income Tax", 4),
            new Railroad("Reading Railroad", 5, 200, 25),
            new Street("Oriental Avenue", 6, Color.LIGHTBLUE, 100, 6, 50, new int[]{30, 90, 270, 400, 550}),
            new Chance("Chance Pink", 7, Card.CardType.CHANCE),
            new Street("Vermont Avenue", 8, Color.LIGHTBLUE, 100, 6, 50, new int[]{30, 90, 270, 400, 550}),
            new Street("Connecticut Avenue", 9, Color.LIGHTBLUE, 120, 8, 50, new int[]{40, 100, 300, 450, 600}),
            new Space("Jail", 10),
            new Street("St. Charles Place", 11, Color.PURPLE, 140, 10, 100, new int[]{50, 150, 450, 625, 750}),
            new Utility("Electric Company", 12, 150, 0),
            new Street("States Avenue", 13, Color.PURPLE, 140, 10, 100, new int[]{50, 150, 450, 625, 750}),
            new Street("Virginia Avenue", 14, Color.PURPLE, 160, 12, 100, new int[]{60, 180, 500, 700, 900}),
            new Railroad("Pennsylvania Railroad", 15, 200, 25),
            new Street("St. James Place", 16, Color.ORANGE, 180, 14, 100, new int[]{70, 200, 550, 750, 950}),
            new CommunityChest("Community Chest 2", 17, Card.CardType.COMMUNITY),
            new Street("Tennessee Avenue", 18, Color.ORANGE, 180, 14, 100, new int[]{70, 200, 550, 750, 950}),
            new Street("New York Avenue", 19, Color.ORANGE, 200, 16, 100, new int[]{80, 220, 600, 800, 1000}),
            new Space("Free Parking", 20),
            new Street("Kentucky Avenue", 21, Color.RED, 220, 18, 150, new int[]{90, 250, 700, 875, 1050}),
            new Chance("Chance Blue",22, Card.CardType.CHANCE),
            new Street("Indiana Avenue", 23, Color.RED, 220, 18, 150, new int[]{90, 225, 700, 875, 1050}),
            new Street("Illinois Avenue", 24, Color.RED, 240, 20, 150, new int[]{90, 300, 700, 875, 1050}),
            new Railroad("B&O Railroad", 25, 200, 25),
            new Street("Atlantic Avenue", 26, Color.YELLOW, 260, 22, 150, new int[]{110, 330, 800, 975, 1150}),
            new Street("Ventnor Avenue", 27, Color.YELLOW, 260, 22, 150, new int[]{110, 330, 800, 975, 1150}),
            new Utility("Water Works", 28, 150, 0 ),
            new Street("Marvin Gardens", 29, Color.YELLOW, 280, 24, 150, new int[]{120, 360, 850, 1025, 1150}),
            new Space("Go To Jail", 30),
            new Street("Pacific Avenue", 31, Color.GREEN, 300, 26, 200, new int[]{130, 390, 850, 1025, 1200}),
            new Street("North Carolina Avenue", 32, Color.GREEN, 300, 26, 200, new int[]{130, 390, 900, 1100, 1275}),
            new CommunityChest("Community Chest 3", 33, Card.CardType.COMMUNITY),
            new Street("Pennsylvania Avenue", 34, Color.GREEN, 320, 28, 200, new int[]{150, 450, 1000, 1200, 1400}),
            new Railroad("Short Line", 35, 200, 25),
            new Chance("Chance", 36, Card.CardType.CHANCE),
            new Street("Park Place", 37, Color.DARKBLUE, 350, 35, 200, new int[]{175, 500, 1100, 1300, 1500}),
            new Space("Luxury Tax", 38),
            new Street("Boardwalk", 39, Color.LIGHTBLUE, 400, 50, 200, new int[]{200, 600, 1400, 1700, 2000})};


    /**
     * Private Constructor
     */
    private Board(){

    }

    /**
     * Returns the Game Board spaces
     * @return Array of spaces
     */
    private static Space[] getInstance(){
        return new Board().getSpaceNames();
    }

    public static void main(String[] args) {
        Board board = new Board();
        Space space = Board.getInstance()[1];
        Property st = (Property) space;
        System.out.println(st.getRent(st));
    }

}
