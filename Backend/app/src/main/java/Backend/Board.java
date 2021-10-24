package Backend;

//shell class for later
public class Board {

    /**
     * List of space names on the game board
     */
    final String[] spaceNames = {"GO", "MEDITERRANEAN AVENUE", "COMMUNITY CHEST_1", "BALTIC AVENUE",
            "INCOME TAX", "READING RAILROAD", "ORIENTAL AVENUE", "CHANCE_PINK",
            "VERMONT AVENUE", "CONNECTICUT AVENUE", "JAIL", "ST.CHARLES PLACE", "ELECTRIC COMPANY", "STATES AVENUE", "VIRGINIA AVENUE",
            "PENNSYLVANIA RAILROAD", "ST.JAMES PLACE", "COMMUNITY CHEST_2", "TENNESSEE AVENUE", "NEW YORK AVENUE", "FREE PARKING",
            "KENTUCKY AVENUE", "CHANCE_BLUE", "INDIANA AVENUE", "ILLINOIS AVENUE", "B&O RAILROAD", "ATLANTIC AVENUE", "VENTNOR AVENUE",
            " WATER WORKS", "MARVIN GARDENS", "GO TO JAIL", "PACIFIC AVENUE", "NORTH CAROLINA AVENUE", "COMMUNITY CHEST_3", "PENNSYLVANIA AVENUE",
            "SHORT LINE", "CHANCE", "PARK PLACE", "LUXURY TAX", "BOARDWALK"};

    /**
     * Constructor
     */
    public Board() {

    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.spaceNames.length);
    }
}
