package Backend;

public class Dice {

  // singleton class dice
  private int[] die = new int[2];
  private int total;
  private static Dice diceInstance;

  //random int one to 6 for each die
  public int[] roll() {
    die[0] = (int) Math.floor(Math.random() * 6) + 1;
    die[1] = (int) Math.floor(Math.random() * 6) + 1;
    total = die[0] + die[1];
    return die;
  }

  public int getTotal() {
    return total;
  }

  public int[] getPrevRoll() {
    return die;
  }


  public boolean isDouble() {
    return die[0] == die[1];
  }

  private Dice() {
    roll();
  }

  public static Dice getInstance() {
    if (diceInstance == null) {
      diceInstance = new Dice();
    }
    return diceInstance;
  }


}
