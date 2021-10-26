import tkinter
from tkinter import *
import random


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

        self.move_button = Button(self.window, text="move", command=self.move_token_1,
                                  font=('Arial', 12, 'bold'), width=7)
        self.move_button.place(x=1000, y=700)

    # Initializes player tokens
    def create_player_token(self):

        ## Player horse token
        self.horse = PhotoImage(file='Resources/horse.png')
        self.horse_label = Label(self.window, image=self.horse, bg="#BFDBAE")
        self.horse_label.place(x=7, y=725)

    # Moves player position
    # param Player index
    def move_token_1(self):
        position = random.randint(0, 39)
        if position == 0:
            self.horse_label.place(x=7, y=725)
        elif position == 1:
            self.horse_label.place(x=7, y=639)
        elif position == 2:
            self.horse_label.place(x=7, y=570)
        elif position == 3:
            self.horse_label.place(x=7, y=505)
        elif position == 4:
            self.horse_label.place(x=7, y=449)
        elif position == 5:
            self.horse_label.place(x=7, y=385)
        elif position == 6:
            self.horse_label.place(x=7, y=320)
        elif position == 7:
            self.horse_label.place(x=7, y=257)
        elif position == 8:
            self.horse_label.place(x=7, y=190)
        elif position == 9:
            self.horse_label.place(x=7, y=130)
        elif position == 10:
            self.horse_label.place(x=7, y=65)
        elif position == 11:
            self.horse_label.place(x=108, y=7)
        elif position == 12:
            self.horse_label.place(x=175, y=7)
        elif position == 13:
            self.horse_label.place(x=240, y=7)
        elif position == 14:
            self.horse_label.place(x=300, y=7)
        elif position == 15:
            self.horse_label.place(x=370, y=7)
        elif position == 16:
            self.horse_label.place(x=430, y=7)
        elif position == 17:
            self.horse_label.place(x=490, y=7)
        elif position == 18:
            self.horse_label.place(x=562, y=7)
        elif position == 19:
            self.horse_label.place(x=626, y=7)
        elif position == 20:
            self.horse_label.place(x=745, y=7)
        elif position == 21:
            self.horse_label.place(x=745, y=115)
        elif position == 22:
            self.horse_label.place(x=745, y=184)
        elif position == 23:
            self.horse_label.place(x=745, y=244)
        elif position == 24:
            self.horse_label.place(x=745, y=310)
        elif position == 25:
            self.horse_label.place(x=745, y=374)
        elif position == 26:
            self.horse_label.place(x=745, y=438)
        elif position == 27:
            self.horse_label.place(x=745, y=504)
        elif position == 28:
            self.horse_label.place(x=745, y=567)
        elif position == 29:
            self.horse_label.place(x=745, y=632)
        elif position == 30:
            self.horse_label.place(x=745, y=732)
        elif position == 31:
            self.horse_label.place(x=635, y=732)
        elif position == 32:
            self.horse_label.place(x=571, y=732)
        elif position == 33:
            self.horse_label.place(x=507, y=732)
        elif position == 34:
            self.horse_label.place(x=434, y=732)
        elif position == 35:
            self.horse_label.place(x=369, y=732)
        elif position == 36:
            self.horse_label.place(x=305, y=732)
        elif position == 37:
            self.horse_label.place(x=241, y=732)
        elif position == 38:
            self.horse_label.place(x=177, y=732)
        elif position == 39:
            self.horse_label.place(x=113, y=732)
