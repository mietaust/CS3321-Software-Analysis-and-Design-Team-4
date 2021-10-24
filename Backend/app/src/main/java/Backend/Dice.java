package Backend;

public class Dice {

  // singleton class dice
  private int[] die = new int[2];
  private int total;
  private static Dice diceInstance;


  /**
   * roll the dice
   * @return die (int []), a randomized array of [die 2, die 2]
   */
  public int[] roll() {
    //random int one to 6 for each die
    die[0] = (int) Math.floor(Math.random() * 6) + 1;
    die[1] = (int) Math.floor(Math.random() * 6) + 1;
    total = die[0] + die[1];
    return die;
  }

  /**
   * Total roll value.
   * @return total. (int), this is the sum of the two dice
   */
  public int getTotal() {
    return total;
  }

  /**
   * get the dice from the last dice roll
   * @return die (int[]), an array of [die 1, die 2]
   */
  public int[] getPrevRoll() {
    return die;
  }


  /**
   * determine if the dice roll is double
   * @return true if double, false otherwise (boolean)
   */
  public boolean isDouble() {
    if (die[0] == die[1]) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * On creating a new instance of Dice, roll the dice
   */
  private Dice() {
    roll();
  }

  /**
   *
   * @return this instance of Dice
   */
  public static Dice getInstance() {
    if (diceInstance == null) {
      diceInstance = new Dice();
    }
    return diceInstance;
  }


}
