package Backend;

import Backend.Card.CardType;
import org.jetbrains.annotations.NotNull;


public class Gameplay {

  static GameState state = GameState.getInstance();
  static Dice dice = Dice.getInstance();
  private static CommunityChest chest = new CommunityChest("Chest", 0, CardType.COMMUNITY);
  private static Chance chance = new Chance("Chance", 0, CardType.CHANCE);

  public static void reset() { // resets GameState to default
    GameState.resetState();
    state = GameState.getInstance();
  }


  public static void roll(Player player) {//rolls and handles movement
    GameState.getInstance().log(player.getName() + " has rolled.");
    int doubles = 0;
    int movement = 0;
    //checks jail, roll used to check for escape if they don't have a get out of jail free card.
    //after 3 turns, if the haven't gotten out, they pay $50 and get out automatically.
    if (player.isInJail()) {
      if (player.getOOJCards() > 0) {
        player.setInJail(false);
        player.setOOJCards(player.getOOJCards() - 1);
        GameState.getInstance()
            .log(player.getName() + " used a get out of jail free card to escape");
      } else {
        dice.roll();
        if (dice.isDouble()) {
          player.setInJail(false);
          player.setNumJailEscAttempts(0);
          GameState.getInstance().log(player.getName() + " rolled a double and escaped");
        } else {
          player.setNumJailEscAttempts(player.getNumJailEscAttempts() + 1);
          GameState.getInstance().log(player.getName() + " did not roll a double");

          if (player.getNumJailEscAttempts() == 3) {
            player.addToAccount(-50);
            player.setInJail(false);
            GameState.getInstance().log(player.getName() + " failed to escape in 3 rounds and payed 50$ bail");
          }
        }

      }
      return;
    } else {
      //standard movement logic,player is yote to jail if they get 3 doubles
      do {
        // we have to check if the player is already in jail
        dice.roll();
        movement += dice.getTotal();
        GameState.getInstance().log(
            player.getName() + " rolled a " + dice.getPrevRoll()[0] + " and a "
                + dice.getPrevRoll()[1]);
        if (dice.isDouble()) {
          doubles++;
        }
        if (doubles == 3) {
          movement = 0;
          //send player to jail here.
          player.setInJail(true);
          player.goToJail();
          return;
        }
      } while (dice.isDouble());
      if (player.getPosition() + movement > 39) {
        //this should give player 200 for passing go
        player.addToAccount(200);
        GameState.getInstance().log(player.getName()+" gets 200$ for passing go");
      }
      player.move(movement);
      state.setRolled(true);
      GameState.getInstance().log(player.getName() +" has moved "+movement+" spaces");
      checkPosition(player);
    }
  }

  /**
   * Checks player current position
   *
   * @param player Player to check position of.
   */
  private static void checkPosition(
      Player player) {//deals with reactive spaces, passing go, etc. todo should exchange all the nasty casting with proper method override stuff
    //this chunk handles rent payment
    if ((state.getBoard()[player.getPosition()]) instanceof Street
        && ((Street) state.getBoard()[player.getPosition()]).getOwner() != null
        && ((Street) state.getBoard()[player.getPosition()]).getOwner() != player) {
      ((Street) state.getBoard()[player.getPosition()]).getOwner()
          .addToAccount(((Street) state.getBoard()[player.getPosition()]).getRent());
      player.addToAccount(-1 * ((Street) state.getBoard()[player.getPosition()]).getRent());
      GameState.getInstance().log(player.getName() +" is now paying a rent of "+(((Street) state.getBoard()[player.getPosition()]).getRent())+" to "+((Street) state.getBoard()[player.getPosition()]).getOwner().getName());
    } else if ((state.getBoard()[player.getPosition()]) instanceof Property
        && ((Property) state.getBoard()[player.getPosition()]).getOwner() != null
        && ((Property) state.getBoard()[player.getPosition()]).getOwner() != player) {
      ((Property) state.getBoard()[player.getPosition()]).getOwner()
          .addToAccount(((Property) state.getBoard()[player.getPosition()]).getRent());
      player.addToAccount(-1 * ((Property) state.getBoard()[player.getPosition()]).getRent());
      GameState.getInstance().log(player.getName() +" is now paying a rent of "+(((Property) state.getBoard()[player.getPosition()]).getRent())+" to "+((Property) state.getBoard()[player.getPosition()]).getOwner().getName());
    }
    //this chunk handles all the other possible reactive spaces
    if (player.getPosition() == Constants.COMMUNITY_CHEST
        || player.getPosition() == Constants.COMMUNITY_CHEST2
        || player.getPosition() == Constants.COMMUNITY_CHEST3) {
      chest.community((int) Math.floor(Math.random() * 16));
      chest.performAction(chest.getAction(), player);
      GameState.getInstance().log(player.getName()+" has drawn a card: "+chest.getCardDesc());
    } else if (player.getPosition() == Constants.CHANCE_RED
        || player.getPosition() == Constants.CHANCE_ORANGE
        || player.getPosition() == Constants.CHANCE_BLUE) {
      chance.chance((int) Math.floor(Math.random() * 12));
      chance.performAction(chance.getAction(), player);
      GameState.getInstance().log(player.getName()+" has drawn a card: "+chance.getCardDesc());
    } else if (player.getPosition() == Constants.GOTO_JAIL) {
      if (!player.isInJail()) {
        player.goToJail();
      }
      player.goToJail();
      GameState.getInstance().log(player.getName()+" is going to Jail Baby");
    } else {
      return;
    }
  }

  /**
   * attempts to buy spot the player is on
   *
   * @param player
   */
  public static void buy(Player player) {
    System.out.println("made it to here before SHTF");
    System.out.println((state.getBoard()[player.getPosition()]) instanceof Property);
    if (state.getRolled() && (state.getBoard()[player.getPosition()]) instanceof Property) {
      //System.out.println(player.getAccountBalance()+"\n"+String.valueOf(((Property)state.getBoard()[player.getPosition()]).getValue())) ;
      if (player.getAccountBalance()
          > ((Property) state.getBoard()[player.getPosition()]).getValue()
          && ((Property) state.getBoard()[player.getPosition()]).getOwner() == null) {
        player.buy((Property) state.getBoard()[player.getPosition()]);
        GameState.getInstance().log(player.getName()+" has purchased "+state.getBoard()[player.getPosition()].getName());
        //((Property) state.getBoard()[player.getPosition()]).setOwner(player);
        //player.addToAccount(-((Property) state.getBoard()[player.getPosition()]).getValue());

        // System.out.println(((Property) state.getBoard()[player.getPosition()]).getOwner().getName());
        // System.out.println(player.getPropertyOwned());

      } else {
        //player does not have enough money or the location is owned by someone else.
      }
    } else {
      //player is not on a purchasable location.
      System.out.println("not standing on purchasable square");
    }
  }

  /**
   * attempts to build house on the player's location
   *
   * @param player
   */
  public static void buildHouse(@NotNull Player player) {
    int location = player.getPosition();
    //check to see if the space allows building
    if (state.getRolled() && (state.getBoard()[location]) instanceof Backend.Street) {
      //check if it isn't full of houses, has no hotels, and player owns it and all of it's color.
      if (((Street) state.getBoard()[location]).getHouseNumber() < 4
          && player.getPropertyOwned().contains((Street) state.getBoard()[location])
          && player.ownAllStreetGroup((Street) state.getBoard()[location])
          && ((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //check if the player can afford the house
        if (player.getAccountBalance() > ((Street) state.getBoard()[location]).getBuildPrice()) {
          ((Street) state.getBoard()[location]).setHouseNumber
              (((Street) state.getBoard()[location]).getHouseNumber() + 1);
          GameState.getInstance().log(player.getName()+" has built a house at "+state.getBoard()[player.getPosition()].getName());
        } else {
          GameState.getInstance().log(player.getName() +"Not enough money");
          //not enough money
        }
      }
    } else {
      //not buildable location
    }
  }

  /**
   * attempts to build hotel on the players location
   *
   * @param player
   */
  public static void buildHotel(Player player) {
    int location = player.getPosition();
    //check to see if the space allows building
    if (state.getRolled() && (state.getBoard()[location]) instanceof Backend.Street) {
      //check if it isn't full of houses and player owns it and all of the color.
      if (((Street) state.getBoard()[location]).getHouseNumber() == 4
          && player.getPropertyOwned().contains((Street) state.getBoard()[location])
          && player.ownAllStreetGroup((Street) state.getBoard()[location])
          && ((Street) state.getBoard()[location]).getHotelNumber() == 0) {
        //check if the player can afford the house
        if (player.getAccountBalance() > ((Street) state.getBoard()[location]).getBuildPrice()) {
          ((Street) state.getBoard()[location]).setHouseNumber(0);
          ((Street) state.getBoard()[location]).setNoOfHotel(1);
          GameState.getInstance().log(player.getName()+" has built a hotel at "+state.getBoard()[player.getPosition()].getName());

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

  /**
   * ends current players turn
   */
  public static void endTurn() {
    GameState.getInstance().log(GameState.getInstance().getTurn().getName()+" has ended their turn.");
    if (state.turn.equals(state.player1)) {
      state.setTurn(state.player2);
    } else {
      state.setTurn(state.player1);
    }
    state.setRolled(false);
    GameState.getInstance().log("It is now "+GameState.getInstance().turn.getName()+"'s turn");
  }


  public static void main(String[] args) {
    GameState g = GameState.getInstance();
    state.player1.move(1);
    buy(state.player1);
    state.player1.move(11);
    buy(state.player1);

  }

}
