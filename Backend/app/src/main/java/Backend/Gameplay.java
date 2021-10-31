package Backend;

import Backend.Card.CardType;
import org.jetbrains.annotations.NotNull;


public class Gameplay {

  static GameState state = GameState.getInstance();
  static Dice dice = Dice.getInstance();
  private static CommunityChest chest = new CommunityChest("Chest", 0, CardType.COMMUNITY);
  private static Chance chance = new Chance("Chance",0,CardType.CHANCE);
  public static void reset() { // resets GameState to default
    GameState.resetState();
    state = GameState.getInstance();
  }


  public static void roll(Player player) {//rolls and handles movement
    int doubles = 0;
    int movement = 0;
    //checks jail, roll used to check for escape if they don't have a get out of jail free card.
    //after 3 turns, if the haven't gotten out, they pay $50 and get out automatically.
    if (player.isInJail()) {
      if (player.getOOJCards() > 0) {
        player.setInJail(false);
        player.setOOJCards(player.getOOJCards() - 1);
      } else {
        dice.roll();
        if (dice.isDouble()) {
          player.setInJail(false);
          player.setNumJailEscAttempts(0);
        } else {
          player.setNumJailEscAttempts(player.getNumJailEscAttempts() + 1);
          if (player.getNumJailEscAttempts() == 3) {
            player.addToAccount(-50);
            player.setInJail(false);
          }
        }

      }
    }
    //standard movement logic,player is yote to jail if they get 3 doubles
    do {
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
    if (player.getPosition() + movement > 39) {
      //this should give player 200 for passing go
      player.addToAccount(200);
    }
    player.move(movement);

    checkPosition(player);

  }

  /**
   * Checks player current position
   *
   * @param player Player to check position of.
   */
  private static void checkPosition(
      Player player) {//deals with reactive spaces, passing go, etc. todo should exchange all the nasty casting with proper method override stuff
    //this chunk handles rent payment
    if ((GameState.getBoard()[player.getPosition()]) instanceof Street
        && ((Street) GameState.getBoard()[player.getPosition()]).getOwner() != null
        && ((Street) GameState.getBoard()[player.getPosition()]).getOwner() != player) {
      ((Street) GameState.getBoard()[player.getPosition()]).getOwner()
          .addToAccount(((Street) GameState.getBoard()[player.getPosition()]).getRent());
      player.addToAccount(-1 * ((Street) GameState.getBoard()[player.getPosition()]).getRent());
    } else if ((GameState.getBoard()[player.getPosition()]) instanceof Property
        && ((Property) GameState.getBoard()[player.getPosition()]).getOwner() != null
        && ((Property) GameState.getBoard()[player.getPosition()]).getOwner() != player) {
      ((Property) GameState.getBoard()[player.getPosition()]).getOwner()
          .addToAccount(((Property) GameState.getBoard()[player.getPosition()]).getRent());
      player.addToAccount(-1 * ((Property) GameState.getBoard()[player.getPosition()]).getRent());
    }
    //this chunk handles all the other possible reactive spaces
    if (player.getPosition() == Constants.GO_SPACE) {
      player.addToAccount(Constants.PASSING_GO);
    } else if (player.getPosition() == Constants.COMMUNITY_CHEST
        || player.getPosition() == Constants.COMMUNITY_CHEST2
        || player.getPosition() == Constants.COMMUNITY_CHEST3) {
      chest.community((int) Math.floor(Math.random() * 16));
      chest.performAction(chest.getAction(), player);
    } else if (player.getPosition() == Constants.CHANCE_RED
        || player.getPosition() == Constants.CHANCE_ORANGE
        || player.getPosition() == Constants.CHANCE_BLUE) {
      chance.chance((int) Math.floor(Math.random() * 12));
      chance.performAction(chance.getAction(),player);
    } else if (player.getPosition() == Constants.GOTO_JAIL) {
      if (!player.isInJail()) {
        player.goToJail();
      }
      player.goToJail();
    } else {
      return;
    }
  }

  /**
   * attempts to buy spot the player is on
   * @param player
   */
  public static void buy(Player player) {
    System.out.println((GameState.getBoard()[player.getPosition()]) instanceof Property);
    if ((GameState.getBoard()[player.getPosition()]) instanceof Property) {
      //System.out.println(player.getAccountBalance()+"\n"+String.valueOf(((Property)GameState.getBoard()[player.getPosition()]).getValue())) ;
      if (player.getAccountBalance()
          > ((Property) GameState.getBoard()[player.getPosition()]).getValue()
          && ((Property) GameState.getBoard()[player.getPosition()]).getOwner() == null) {
        player.buy((Property) GameState.getBoard()[player.getPosition()]);
        //((Property) GameState.getBoard()[player.getPosition()]).setOwner(player);
        //player.addToAccount(-((Property) GameState.getBoard()[player.getPosition()]).getValue());

        // System.out.println(((Property) GameState.getBoard()[player.getPosition()]).getOwner().getName());
        // System.out.println(player.getPropertyOwned());

      } else {
        //player does not have enough money or the location is owned by someone else.
      }
    } else {
      //player is not on a purchasable location.
    }
  }

  /**
   * attempts to build house on the player's location
   * @param player
   */
  public static void buildHouse(@NotNull Player player) {
    int location = player.getPosition();
    //check to see if the space allows building
    if ((state.getBoard()[location]) instanceof Street) {
      //check if it isn't full of houses, has no hotels, and player owns it and all of it's color.
      if (((Street) state.getBoard()[location]).getHouseNumber() < 4
          && player.getPropertyOwned().contains((Street) state.getBoard()[location])
          && player.ownAllStreetGroup((Street) state.getBoard()[location])
          && ((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //check if the player can afford the house
        if (player.getAccountBalance() < ((Street) state.getBoard()[location]).getBuildPrice()) {
          ((Street) state.getBoard()[location]).setHouseNumber
              (((Street) state.getBoard()[location]).getHouseNumber() + 1);
        } else {
          //not enough money
        }
      }
    } else {
      //not buildable location
    }
  }

  /**
   * attempts to build hotel on the players location
   * @param player
   */
  public static void buildHotel(Player player) {
    int location = player.getPosition();
    //check to see if the space allows building
    if ((state.getBoard()[location]) instanceof Street) {
      //check if it isn't full of houses and player owns it and all of the color.
      if (((Street) state.getBoard()[location]).getHouseNumber() == 4
          && player.getPropertyOwned().contains((Street) state.getBoard()[location])
          && player.ownAllStreetGroup((Street) state.getBoard()[location])
          && ((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //check if the player can afford the house
        if (player.getAccountBalance() < ((Street) state.getBoard()[location]).getBuildPrice()) {
          ((Street) state.getBoard()[location]).setHouseNumber(0);
          ((Street) state.getBoard()[location]).setNoOfHotel(1);
        } else {
          //not enough money
        }
      } else if (((Street) state.getBoard()[location]).getHotelNumber() == 0) {
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
