package Backend;

import lombok.Getter;


public class Street{

    @Getter
    private int houseNumber;
    private int hotelNumber;
    @Getter
    private Color colorGroup;
    private int value;


    /**
     * Hotels range from 0 and 1
     * @return Number of hotels
     */
    public int getHotelNumber(){
        if(this.hotelNumber == 1){
            setHouseNumber(0);
        }
        return this.hotelNumber;
    }

    /**
     * Hotel Number ranges from 0 to 1
     * @param hotelNumber updates the hotel number
     */
    public void setNoOfHotel(int hotelNumber){
        if(hotelNumber != 1){
            return;
        }
        this.hotelNumber = hotelNumber;
    }

    /**
     * House Number ranges from 0 to 4
     * @param houseNumber updates the number of houses
     */
    public void setHouseNumber(int houseNumber){
        if(houseNumber > 4 || houseNumber < 0){
            return;
        }
        this.houseNumber = houseNumber;
    }

}
