package Backend;

import lombok.Getter;


public class Street extends Property {

  @Getter
  private int houseNumber;

  private int hotelNumber;
  @Getter
  private final Color colorGroup;
  @Getter
  private final int buildPrice;
  @Getter
  private final int[] rentList;

  /**
   * Constructor
   *
   * @param name       The name of the street
   * @param location   Position on the board
   * @param colorGroup Color Group
   * @param value      The price to purchase the Street
   * @param rent       Cost for Landing on street
   * @param rentList   The rent price depending on houses, hotels and color set
   */
  public Street(String name, int location, Color colorGroup, int value, int rent, int buildPrice,
      int[] rentList) {
    super(name, location, value, rent);
    this.colorGroup = colorGroup;
    this.buildPrice = buildPrice;
    this.rentList = rentList;
    this.setNoOfHotel(0);
    this.setHouseNumber(0);
  }

  /**
   * Hotels range from 0 and 1
   *
   * @return Number of hotels
   */
  public int getHotelNumber() {
    if (this.hotelNumber == 1) {
      setHouseNumber(0);
    }
    return this.hotelNumber;
  }

  /**
   * Hotel Number ranges from 0 to 1
   *
   * @param hotelNumber updates the hotel number
   */
  public void setNoOfHotel(int hotelNumber) {
    if (hotelNumber != 1) {
      return;
    }
    this.hotelNumber = hotelNumber;
    setHouseNumber(0);
  }

  /**
   * House Number ranges from 0 to 4
   *
   * @param houseNumber updates the number of houses
   */
  public void setHouseNumber(int houseNumber) {
    if (houseNumber > 4 || houseNumber < 0) {
      return;
    }
    this.houseNumber = houseNumber;
  }

  /**
   *
   * @return Returns rent depending on player ownership
   */
  @Override
  public int getRent() {
    if (Property.ownerIsPlayer(getOwner())) {
      if (getHouseNumber() == 0 && ((Player) getOwner()).ownAllStreetGroup(this) && getHotelNumber() ==0) {
        return rentList[0];
      } else if (getHouseNumber() == 1) {
        return rentList[1];
      } else if (getHouseNumber() == 2) {
        return rentList[2];
      } else if (getHouseNumber() == 3) {
        return rentList[3];
      } else if (getHouseNumber() == 4) {
        return rentList[4];
      } else if (getHouseNumber() == 0 && getHotelNumber() == 1) {
        return rentList[5];
      }

    }
    return super.getRent();
  }


/*
    public static void main(String[] args) {
        Property prop = new Street("Dan",3,Color.BROWN, 50, 100, 208, new int[]{9, 4, 5});
    }

 */
}
