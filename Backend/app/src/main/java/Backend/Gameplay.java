package Backend;

import org.jetbrains.annotations.NotNull;

//shell class for now
public class Gameplay {

  static GameState state = GameState.getInstance();
  static Dice dice = Dice.getInstance();


  public static void reset() {//todo fix this shit
    GameState.resetState();
    state = GameState.getInstance();
  }


  public static void roll(Player player) {
    int doubles = 0;
    int movement = 0;

    do {
      // we have to check if the player is already in jail
      dice.roll();
      movement += dice.getTotal();
      if (dice.isDouble()) {
        doubles++;
      }
      if (doubles == 3) {
        movement = 0;
        //send player to jail here.
        player.setInJail(true);
        player.goToJail();
      }
    } while (dice.isDouble());
    player.move(movement);
    checkPosition(player);

  }

  /**
   * Checks player current position
   *
   * @param player Player to check position of.
   */
  private static void checkPosition(Player player) {
    if (player.getPosition() == Constants.GO_SPACE) {
      player.addToAccount(Constants.PASSING_GO);
    } else if (player.getPosition() == Constants.COMMUNITY_CHEST) {

    } else if (player.getPosition() == Constants.CHANCE_RED) {

    } else if (player.getPosition() == Constants.GOTO_JAIL) {
      if (!player.isInJail()) {
        player.setInJail(true);
      }
      player.move(11);

    } else if (player.getPosition() == Constants.COMMUNITY_CHEST2) {

    } else if (player.getPosition() == Constants.CHANCE_BLUE) {

    } else if (player.getPosition() == Constants.CHANCE_ORANGE) {

    } else if (player.getPosition() == Constants.COMMUNITY_CHEST3) {

    } else {
      return;
    }
  }


  public static void buy(Player player) {
    System.out.println(Space.isProperty(GameState.getBoard()[player.getPosition()]));
    if (Space.isProperty(GameState.getBoard()[player.getPosition()])) {
      //System.out.println(player.getAccountBalance()+"\n"+String.valueOf(((Property)GameState.getBoard()[player.getPosition()]).getValue())) ;
      if (player.getAccountBalance()
          > ((Property) GameState.getBoard()[player.getPosition()]).getValue()) {
        player.buy((Property) GameState.getBoard()[player.getPosition()]);
        //((Property) GameState.getBoard()[player.getPosition()]).setOwner(player);
        //player.addToAccount(-((Property) GameState.getBoard()[player.getPosition()]).getValue());

        // System.out.println(((Property) GameState.getBoard()[player.getPosition()]).getOwner().getName());
        // System.out.println(player.getPropertyOwned());

      } else {
        //player does not have enough money.
      }
    } else {
      //player is not on a purchasable location.
    }
  }

  public static void build(@NotNull Player player) {
    int location = player.getPosition();
    //check to see if the space allows building
    if (Space.isStreet(state.getBoard()[location])) {
      //check if it isn't full of houses.
      if (((Street) state.getBoard()[location]).getHouseNumber() < 4
          && ((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //check if the player can afford the house
        if (player.getAccountBalance() < ((Street) state.getBoard()[location]).getBuildPrice()) {
          ((Street) state.getBoard()[location]).setHouseNumber(((Street) state.getBoard()[location]).getHouseNumber()+1);
        } else {
          //not enough money
        }
      } else if(((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //full of houses, hotel option??
        if (player.getAccountBalance() < ((Street) state.getBoard()[location]).getBuildPrice()) {
          //build the house
        }
      }
    } else {
      //not buildable location
    }
  }


  public static void main(String[] args) {
    GameState g = GameState.getInstance();
    GameState.player1.move(1);
    buy(GameState.player1);
    GameState.player1.move(11);
    buy(GameState.player1);

  }

}
