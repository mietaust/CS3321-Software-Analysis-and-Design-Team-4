import tkinter
from tkinter import *
import random

position = 0  # temp variable for moving the token 1
player2_position = 0  # temp variable for moving the token 2


class GameBoard:

    def __init__(self):
        self.window = Tk()
        self.window.title("MonopolyLite")
        self.window.geometry("1300x770")
        self.window.resizable(False, False)
        self.initialize_spaces()
        self.create_player_token()
        self.window.config(bg="#BFDBAE")

        self.window.mainloop()

    # Initializes board spaces with images
    def initialize_spaces(self):
        # Go-space space
        # Coordinates (x=0, y=670)

        self.go = PhotoImage(file='Resources\go.png')
        self.go_button = Button(self.window, image=self.go, bg="#BFDBAE")
        self.go_button.place(x=0, y=670)

        # Brown Mediterranean space
        # Coordinates (x=0, y=606)

        self.mediterranean = PhotoImage(file='Resources/Brown_Mediterranean_1.png')
        self.brown_mediterranean_button = Button(self.window, image=self.mediterranean, bg="#BFDBAE")
        self.brown_mediterranean_button.place(x=0, y=606)

        # Community Chest space
        # Coordinates (x=0, y=542)
        self.community_chest_img = PhotoImage(file='Resources/Community Chest_1.png')
        self.community_chest_button = Button(self.window, image=self.community_chest_img, bg="#BFDBAE")
        self.community_chest_button.place(x=0, y=542)

        # baltic_avenue space
        # Coordinates (x=0, y=478)
        self.baltic_avenue_img = PhotoImage(file='Resources/Brown_Baltic_1.png')
        self.baltic_avenue_button = Button(self.window, image=self.baltic_avenue_img, bg="#BFDBAE")
        self.baltic_avenue_button.place(x=0, y=478)

        # income_tax space
        # Coordinates (x=0, y=414)
        self.income_tax_img = PhotoImage(file='Resources/Income Tax_1.png')
        self.income_tax_button = Button(self.window, image=self.income_tax_img, bg="#BFDBAE")
        self.income_tax_button.place(x=0, y=414)

        # reading_railroad space
        # Coordinates (x=0, y=350)
        self.reading_railroad_img = PhotoImage(file='Resources/Reading Railroad_1.png')
        self.reading_railroad_button = Button(self.window, image=self.reading_railroad_img, bg="#BFDBAE")
        self.reading_railroad_button.place(x=0, y=350)

        # Community Chest
        # Coordinates (x=0, y=286)
        self.oriental_Avenue_img = PhotoImage(file='Resources/SkyBlue_Oriental_1.png')
        self.oriental_Avenue__button = Button(self.window, image=self.oriental_Avenue_img, bg="#BFDBAE")
        self.oriental_Avenue__button.place(x=0, y=286)

        # chance space
        # Coordinates (x=0, y=222)
        self.pink_chance_img = PhotoImage(file='Resources/pinkChance_1.png')
        self.pink_chance_button = Button(self.window, image=self.pink_chance_img, bg="#BFDBAE")
        self.pink_chance_button.place(x=0, y=222)

        # vermont space
        # Coordinates (x=0, y=158)
        self.vermont_img = PhotoImage(file='Resources/SkyBlue_Vermont_1.png')
        self.vermont_button = Button(self.window, image=self.vermont_img, bg="#BFDBAE")
        self.vermont_button.place(x=0, y=158)

        # connecticut space
        # Coordinates (x=0, y=94)
        self.connecticut_img = PhotoImage(file='Resources/SkyBlue_Connecticut_1.png')
        self.connecticut_button = Button(self.window, image=self.connecticut_img, bg="#BFDBAE")
        self.connecticut_button.place(x=0, y=94)

        # Jail space
        # Coordinates (x=0, y=0)
        self.jail_img = PhotoImage(file='Resources/jail.png')
        self.jail_button = Button(self.window, image=self.jail_img, bg="#BFDBAE")
        self.jail_button.place(x=0, y=0)

        # ST. Charles space
        # Coordinates (x=99, y=0)
        self.charles_img = PhotoImage(file='Resources/Purple_ST.Charles_1.png')
        self.charles_button = Button(self.window, image=self.charles_img, bg="#BFDBAE")
        self.charles_button.place(x=99, y=0)

        # Electric space
        # Coordinates (x=160, y=0)
        self.electric_img = PhotoImage(file='Resources/Electric company_1.png')
        self.electric_button = Button(self.window, image=self.electric_img, bg="#BFDBAE")
        self.electric_button.place(x=160, y=0)

        # States Avenue space
        # Coordinates (x=224, y=0)
        self.states_img = PhotoImage(file='Resources/purpleStates_1.png')
        self.states_button = Button(self.window, image=self.states_img, bg="#BFDBAE")
        self.states_button.place(x=224, y=0)

        # Virginia space
        # Coordinates (x=287, y=0)
        self.virginia_img = PhotoImage(file='Resources/Purple_Virginia_1.png')
        self.virginia_button = Button(self.window, image=self.virginia_img, bg="#BFDBAE")
        self.virginia_button.place(x=287, y=0)

        # Pennsylvania railroad space
        # Coordinates (x=352, y=0)
        self.penn_railroad_img = PhotoImage(file='Resources/Pennsylvania_1.png')
        self.penn_railroad_button = Button(self.window, image=self.penn_railroad_img, bg="#BFDBAE")
        self.penn_railroad_button.place(x=352, y=0)

        # Orange_ST.James_1 space
        # Coordinates (x=416, y=0)
        self.james_img = PhotoImage(file='Resources/Orange_ST.James_1.png')
        self.james_button = Button(self.window, image=self.james_img, bg="#BFDBAE")
        self.james_button.place(x=416, y=0)

        # Community Chest_2 space
        # Coordinates (x=480, y=0)
        self.community_chest_2_img = PhotoImage(file='Resources/Community Chest_2.png')
        self.community_chest_2_button = Button(self.window, image=self.community_chest_2_img, bg="#BFDBAE")
        self.community_chest_2_button.place(x=480, y=0)

        # Pennsylvania railroad space
        # Coordinates (x=544, y=0)
        self.tennessee_img = PhotoImage(file='Resources/Orange_Tennessee_1.png')
        self.tennessee_button = Button(self.window, image=self.tennessee_img, bg="#BFDBAE")
        self.tennessee_button.place(x=544, y=0)

        # Orange_New York_1 space
        # Coordinates (x=608, y=0)
        self.new_york_img = PhotoImage(file='Resources/Orange_New York_1.png')
        self.new_york_button = Button(self.window, image=self.new_york_img, bg="#BFDBAE")
        self.new_york_button.place(x=608, y=0)

        # Parking space
        # Coordinates (x=672, y=0)
        self.parking_img = PhotoImage(file='Resources/parking.png')
        self.parking_button = Button(self.window, image=self.parking_img, bg="#BFDBAE")
        self.parking_button.place(x=672, y=0)

        # kentucky space
        # Coordinates (x=672, y=99)
        self.kentucky_img = PhotoImage(file='Resources/Red_Kenteucky_1.png')
        self.kentucky_button = Button(self.window, image=self.kentucky_img, bg="#BFDBAE")
        self.kentucky_button.place(x=672, y=99)

        # Chance space
        # Coordinates(x=672, y=158)
        self.chance_img = PhotoImage(file='Resources/CHANCE_1.png')
        self.chance_button = Button(self.window, image=self.chance_img, bg="#BFDBAE")
        self.chance_button.place(x=672, y=158)

        # Indiana space
        # Coordinates (x=672, y=222)
        self.indiana_img = PhotoImage(file='Resources/Red_Indiana_1.png')
        self.indiana_button = Button(self.window, image=self.indiana_img, bg="#BFDBAE")
        self.indiana_button.place(x=672, y=222)

        # Illinois space
        # Coordinates (x=672, y=286)
        self.illnois_img = PhotoImage(file='Resources/Red_Illinois_1.png')
        self.illnois_button = Button(self.window, image=self.illnois_img, bg="#BFDBAE")
        self.illnois_button.place(x=672, y=286)

        # B&O railroads space
        # Coordinates (x=672, y=350)
        self.b_o_railroad_img = PhotoImage(file='Resources/RailRoad_1.png')
        self.b_o_railroad_button = Button(self.window, image=self.b_o_railroad_img, bg="#BFDBAE")
        self.b_o_railroad_button.place(x=672, y=350)

        # Atlantic space
        # Coordinates (x=672, y=414)
        self.atlantic_img = PhotoImage(file='Resources/Yellow_Atlantic_1.png')
        self.atlantic_button = Button(self.window, image=self.atlantic_img, bg="#BFDBAE")
        self.atlantic_button.place(x=672, y=414)

        # Ventnor space
        # Coordinates (x=672, y=478)
        self.ventnor_img = PhotoImage(file='Resources/Yellow_Ventnor_1.png')
        self.ventnor_button = Button(self.window, image=self.ventnor_img, bg="#BFDBAE")
        self.ventnor_button.place(x=672, y=478)

        # water_works space
        # Coordinates (x=545, y=670)
        self.water_works_img = PhotoImage(file='Resources/water works_1.png')
        self.water_works_button = Button(self.window, image=self.water_works_img, bg="#BFDBAE")
        self.water_works_button.place(x=672, y=542)

        # marvin space
        # Coordinates (x=672, y=606)
        self.marvin_img = PhotoImage(file='Resources/Yellow_Marvin_1.png')
        self.marvin_button = Button(self.window, image=self.marvin_img, bg="#BFDBAE")
        self.marvin_button.place(x=672, y=606)

        # go_to_jail space
        # Coordinates (x=672, y=670)
        self.go_to_jail_img = PhotoImage(file='Resources/gotojail.png')
        self.go_to_jail_button = Button(self.window, image=self.go_to_jail_img, bg="#BFDBAE")
        self.go_to_jail_button.place(x=672, y=670)

        # broadwalk space
        # Coordinates (x=99, y=670)
        self.broadwalk_img = PhotoImage(file='Resources/Dark-Blue_Broadwalk_1.png')
        self.broadwalk_button = Button(self.window, image=self.broadwalk_img, bg="#BFDBAE")
        self.broadwalk_button.place(x=99, y=670)

        # luxury_tax space
        # Coordinates (x=160, y=670)
        self.luxury_tax_img = PhotoImage(file='Resources/Luxury Tax_1.png')
        self.luxury_tax_button = Button(self.window, image=self.luxury_tax_img, bg="#BFDBAE")
        self.luxury_tax_button.place(x=160, y=670)

        # luxury_tax space
        # Coordinates (x=224, y=670)
        self.park_place_img = PhotoImage(file='Resources/DarkBlue_Park_1.png')
        self.park_place_button = Button(self.window, image=self.park_place_img, bg="#BFDBAE")
        self.park_place_button.place(x=224, y=670)

        # orange_chance space
        # Coordinates (x=287, y=670)
        self.orange_chance_img = PhotoImage(file='Resources/orangeChance_1.png')
        self.orange_chance_button = Button(self.window, image=self.orange_chance_img, bg="#BFDBAE")
        self.orange_chance_button.place(x=287, y=670)

        # short_line space
        # Coordinates (x=352, y=670)
        self.short_line_img = PhotoImage(file='Resources/Short Line_1.png')
        self.short_line_button = Button(self.window, image=self.short_line_img, bg="#BFDBAE")
        self.short_line_button.place(x=352, y=670)

        # Pennsylvania_street space
        # Coordinates (x=416, y=670)
        self.pennsylvania_img = PhotoImage(file='Resources/Green_Pennsylvania_1.png')
        self.pennsylvania_button = Button(self.window, image=self.pennsylvania_img, bg="#BFDBAE")
        self.pennsylvania_button.place(x=416, y=670)

        # community_chest space
        # Coordinates (x=480, y=670)
        self.community_chest_3_img = PhotoImage(file='Resources/Community Chest_3.png')
        self.community_chest_3_button = Button(self.window, image=self.community_chest_3_img, bg="#BFDBAE")
        self.community_chest_3_button.place(x=480, y=670)

        # north_carolina_street space
        # Coordinates (x=545, y=670)
        self.north_carolina_img = PhotoImage(file='Resources/Green_North Carolina_1.png')
        self.north_carolina_button = Button(self.window, image=self.north_carolina_img, bg="#BFDBAE")
        self.north_carolina_button.place(x=545, y=670)

        # pacific_street space
        # Coordinates (x=608, y=670)
        self.pacific_img = PhotoImage(file='Resources/Green_Pacific_1.png')
        self.pacific_button = Button(self.window, image=self.pacific_img, bg="#BFDBAE")
        self.pacific_button.place(x=608, y=670)

        # Buttons
        self.move_button = Button(self.window, text="Player 1", command=self.player_one_position,
                                  font=('Arial', 12, 'bold'), width=7)
        self.move_button.place(x=1000, y=700)

        self.new_button = Button(self.window, text="Player 2", command=self.player_two_position,
                                 font=('Arial', 12, 'bold'), width=7)
        self.new_button.place(x=1100, y=700)

        self.purchase_button = Button(self.window, text="Buy Property", command=self.button_purchase(),
                                      font=("arial", 12, 'bold'), width=15)
        self.purchase_button.place(x=140, y=120)
        self.build_house_button = Button(self.window, text="Build House", command=self.button_house(),
                                      font=("arial", 12, 'bold'), width=15)
        self.build_house_button.place(x=310, y=120)
        self.build_hotel_button = Button(self.window, text="Build Hotel", command=self.button_hotel(),
                                         font=("arial", 12, 'bold'), width=15)
        self.build_hotel_button.place(x=480, y=120)

        self.roll_button = Button(self.window, text="Roll Dice", command=self.button_roll(),
                                         font=("arial", 12, 'bold'), width=15)
        self.roll_button.place(x=310, y=600)

    # Initializes player tokens
    def create_player_token(self):
        ## Player 1 token
        self.player_one_img = PhotoImage(file='Resources/one.png')
        self.player_one_label = Label(self.window, image=self.player_one_img, bg="#33CCFF")
        self.player_one_label.place(x=7, y=725)

        ## Player 2 token
        self.player_two_img = PhotoImage(file='Resources/two.png')
        self.player_two_label = Label(self.window, image=self.player_two_img, bg="#FF0000")
        self.player_two_label.place(x=35, y=725)

    # Moves player one position
    # param Player one index
    def player_one_position(self):
        global position
        position = (position + 1) % 40

        if position == 0:
            self.player_one_label.place(x=5, y=725)
        elif position == 1:
            self.player_one_label.place(x=5, y=639)
        elif position == 2:
            self.player_one_label.place(x=5, y=570)
        elif position == 3:
            self.player_one_label.place(x=5, y=505)
        elif position == 4:
            self.player_one_label.place(x=5, y=449)
        elif position == 5:
            self.player_one_label.place(x=5, y=385)
        elif position == 6:
            self.player_one_label.place(x=5, y=320)
        elif position == 7:
            self.player_one_label.place(x=5, y=257)
        elif position == 8:
            self.player_one_label.place(x=5, y=190)
        elif position == 9:
            self.player_one_label.place(x=5, y=130)
        elif position == 10:
            self.player_one_label.place(x=7, y=65)
        elif position == 11:
            self.player_one_label.place(x=108, y=7)
        elif position == 12:
            self.player_one_label.place(x=175, y=7)
        elif position == 13:
            self.player_one_label.place(x=240, y=7)
        elif position == 14:
            self.player_one_label.place(x=300, y=7)
        elif position == 15:
            self.player_one_label.place(x=370, y=7)
        elif position == 16:
            self.player_one_label.place(x=430, y=7)
        elif position == 17:
            self.player_one_label.place(x=490, y=7)
        elif position == 18:
            self.player_one_label.place(x=562, y=7)
        elif position == 19:
            self.player_one_label.place(x=626, y=7)
        elif position == 20:
            self.player_one_label.place(x=740, y=7)
        elif position == 21:
            self.player_one_label.place(x=740, y=115)
        elif position == 22:
            self.player_one_label.place(x=740, y=184)
        elif position == 23:
            self.player_one_label.place(x=740, y=244)
        elif position == 24:
            self.player_one_label.place(x=740, y=310)
        elif position == 25:
            self.player_one_label.place(x=740, y=374)
        elif position == 26:
            self.player_one_label.place(x=740, y=438)
        elif position == 27:
            self.player_one_label.place(x=740, y=504)
        elif position == 28:
            self.player_one_label.place(x=740, y=567)
        elif position == 29:
            self.player_one_label.place(x=740, y=632)
        elif position == 30:
            self.player_one_label.place(x=740, y=732)
        elif position == 31:
            self.player_one_label.place(x=635, y=738)
        elif position == 32:
            self.player_one_label.place(x=571, y=738)
        elif position == 33:
            self.player_one_label.place(x=507, y=738)
        elif position == 34:
            self.player_one_label.place(x=434, y=738)
        elif position == 35:
            self.player_one_label.place(x=369, y=738)
        elif position == 36:
            self.player_one_label.place(x=305, y=738)
        elif position == 37:
            self.player_one_label.place(x=241, y=738)
        elif position == 38:
            self.player_one_label.place(x=177, y=738)
        elif position == 39:
            self.player_one_label.place(x=113, y=738)

    # Moves Player two token
    # param Player two index
    def player_two_position(self):
        global player2_position
        player2_position = (player2_position + 1) % 40

        if player2_position == 0:
            self.player_two_label.place(x=35, y=725)
        elif player2_position == 1:
            self.player_two_label.place(x=35, y=639)
        elif player2_position == 2:
            self.player_two_label.place(x=35, y=570)
        elif player2_position == 3:
            self.player_two_label.place(x=35, y=505)
        elif player2_position == 4:
            self.player_two_label.place(x=35, y=449)
        elif player2_position == 5:
            self.player_two_label.place(x=35, y=385)
        elif player2_position == 6:
            self.player_two_label.place(x=35, y=320)
        elif player2_position == 7:
            self.player_two_label.place(x=35, y=257)
        elif player2_position == 8:
            self.player_two_label.place(x=35, y=190)
        elif player2_position == 9:
            self.player_two_label.place(x=35, y=130)
        elif player2_position == 10:
            self.player_two_label.place(x=37, y=65)
        elif player2_position == 11:
            self.player_two_label.place(x=108, y=37)
        elif player2_position == 12:
            self.player_two_label.place(x=175, y=37)
        elif player2_position == 13:
            self.player_two_label.place(x=240, y=37)
        elif player2_position == 14:
            self.player_two_label.place(x=300, y=37)
        elif player2_position == 15:
            self.player_two_label.place(x=370, y=37)
        elif player2_position == 16:
            self.player_two_label.place(x=430, y=37)
        elif player2_position == 17:
            self.player_two_label.place(x=490, y=37)
        elif player2_position == 18:
            self.player_two_label.place(x=562, y=37)
        elif player2_position == 19:
            self.player_two_label.place(x=626, y=37)
        elif player2_position == 20:
            self.player_two_label.place(x=740, y=37)
        elif player2_position == 21:
            self.player_two_label.place(x=710, y=115)
        elif player2_position == 22:
            self.player_two_label.place(x=710, y=184)
        elif player2_position == 23:
            self.player_two_label.place(x=710, y=244)
        elif player2_position == 24:
            self.player_two_label.place(x=710, y=310)
        elif player2_position == 25:
            self.player_two_label.place(x=710, y=374)
        elif player2_position == 26:
            self.player_two_label.place(x=710, y=438)
        elif player2_position == 27:
            self.player_two_label.place(x=710, y=504)
        elif player2_position == 28:
            self.player_two_label.place(x=710, y=567)
        elif player2_position == 29:
            self.player_two_label.place(x=710, y=632)
        elif player2_position == 30:
            self.player_two_label.place(x=710, y=732)
        elif player2_position == 31:
            self.player_two_label.place(x=635, y=708)
        elif player2_position == 32:
            self.player_two_label.place(x=571, y=708)
        elif player2_position == 33:
            self.player_two_label.place(x=507, y=708)
        elif player2_position == 34:
            self.player_two_label.place(x=434, y=708)
        elif player2_position == 35:
            self.player_two_label.place(x=369, y=708)
        elif player2_position == 36:
            self.player_two_label.place(x=305, y=708)
        elif player2_position == 37:
            self.player_two_label.place(x=241, y=708)
        elif player2_position == 38:
            self.player_two_label.place(x=177, y=708)
        elif player2_position == 39:
            self.player_two_label.place(x=113, y=708)

    # get request to /api/roll
    def button_roll(self):
        test = "test"

    # get request to /api/purchase
    def button_purchase(self):
        test = "test"

    # get request to /api/build/house
    def button_house(self):
        test = "test"

    # get request to /api/build/house
    def button_hotel(self):
        test = "test"

    # submit a get request to /api/update, receive the board update object through json, apply to the current gameboard.
    def get_board_update(self):
        test="test"

board = GameBoard()