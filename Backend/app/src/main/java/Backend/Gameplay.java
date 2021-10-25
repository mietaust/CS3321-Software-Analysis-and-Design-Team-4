package Backend;

//shell class for now
public class Gameplay {

  static Dice dice = Dice.getInstance();

  public static void roll() {
    int doubles = 0;
    int movement = 0;

    do {
      dice.roll();
      movement += dice.getTotal();
      if (dice.isDouble()) {
        doubles++;
      }
      if (doubles == 3) {
        movement = 0;
        //send player to jail here.
      }
    } while (dice.isDouble());

    //find return based on where the player lands here

  }


}
