from tkinter import *
import json
from types import SimpleNamespace
import time
from threading import Thread

#position = 0  # temp variable for moving the token 1
#player2_position = 0  # temp variable for moving the token 2
#house_num = 0
#hotel_num = 1  # temp hotel num


class GameBoard:

    def __init__(self, cman, player):
        self.player = player
        self.cman = cman
        self.window = Tk()
        self.window.title("MonopolyLite")
        self.window.geometry("1374x770")
        self.window.resizable(False, False)
        self.initialize_spaces()  # Creates board spaces
        self.deactivate_space_button()  # Deactivates spaces, so they can't be clicked
        self.create_player_token()  # Creates all player token
        self.initialize_houses()  # Initializes house labels
        self.initialize_hotels()  # Initializes hotel labels
        self.window.config(bg="#BFDBAE")
        self.server_update()  # Updates game log
        self.create_player_one_display() # Updates Player 1 info
        self.create_player_two_display() # Updates Player 2 info

        self.thread = Thread(target=self.main_update_loop())
        self.thread.start()
        # self.window.update()

        # self.get_board_update_loop()

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
        self.purchase_button = Button(self.window, text="Buy Property", command=self.button_purchase,
                                      font=("arial", 12, 'bold'), width=15)
        self.purchase_button.place(x=140, y=120)
        self.build_house_button = Button(self.window, text="Build House", command=self.button_house,
                                         font=("arial", 12, 'bold'), width=15)
        self.build_house_button.place(x=310, y=120)
        self.build_hotel_button = Button(self.window, text="Build Hotel", command=self.button_hotel,
                                         font=("arial", 12, 'bold'), width=15)
        self.build_hotel_button.place(x=480, y=120)

        self.roll_button = Button(self.window, text="Roll Dice", command=self.button_roll,
                                  font=("arial", 12, 'bold'), width=15)
        self.roll_button.place(x=310, y=600)

        self.endTurn_button = Button(self.window, text="End Turn", command=self.button_end_turn,
                                     font=("arial", 12, 'bold'), width=15)
        self.endTurn_button.place(x=310, y=520)
    
     # Initialize Server Update Scroller Window

    def server_update(self):

        self.update_frame = Frame(self.window)
        # Create scrollbar
        self.scroll_bar = Scrollbar(self.update_frame, orient="vertical")
        self.scroll_bar.pack(side=RIGHT, fill=Y)

        self.game_log_list = Listbox(self.update_frame, width=97, height=23, yscrollcommand=self.scroll_bar.set,
                                     font=("Times", 10))

        self.game_log_list.configure(exportselection=False)
        self.game_log_list.pack(side=LEFT, fill=Y)

        self.scroll_bar.config(command=self.game_log_list.yview)

        self.update_frame.place(x=773, y=0)

        for x in range(100):
            self.game_log_list.insert(END, x)

        # Initializes Player One display

    def create_player_one_display(self):
        ## Player 1 Information
        self.label_frame = LabelFrame(self.window, text="Player Information", width=70)  # Create Frame frame for labels
        self.label_frame.place(x=773, y=374)  # Filling window
        self.label_frame.config(bg="light blue")  # Set background window background color

        # Create and position labels and text boxes for Player One
        self.player_one_label = Label(self.label_frame, text="Player 1: ", relief=RIDGE, font=("Arial", 10, "bold"))
        self.player_one_label.grid(row=0, column=0, padx=10, pady=10, sticky=NW)

        self.player_one_name = Entry(self.label_frame, text="Enter Name", width=12, relief=SUNKEN, font=("Arial", 10))
        self.player_one_name.grid(row=0, column=1, padx=0, pady=10, sticky=NW)

        self.player_one_cash_amount = Label(self.label_frame, text="", width=7, relief=SUNKEN, font=("Arial", 10),
                                            bg='yellow')
        self.player_one_cash_amount.grid(row=0, column=4, padx=0, pady=10, sticky=NW)

        self.player_one_cash_label = Label(self.label_frame, text="$:", font=("Arial", 10), bg="light blue")
        self.player_one_cash_label.grid(row=0, column=3, padx=0, pady=10, sticky=E)

        # self.root.Separator(self.root, orient=HORIZONTAL).grid(columnspan=5, row=1, sticky='ew')

        self.player_one_property_header = Label(self.label_frame, text="Player Properties", relief=RIDGE,
                                                font=("Arial", 10, "bold"))
        self.player_one_property_header.grid(row=2, column=1, padx=0, pady=20, sticky=N)

        self.player_one_property_label = Label(self.label_frame, height=292, width=48, font=("Arial", 8), relief=SUNKEN,
                                               bg="white")
        self.player_one_property_label.grid(columnspan=5, row=3, sticky="wens")

        # Initializes Player Two display

    def create_player_two_display(self):
        ## Player 2 Information
        self.label_frame2 = LabelFrame(self.window, text="Player Information",
                                       width=75)  # Create Frame frame for labels
        self.label_frame2.place(x=1072, y=374)  # Filling window
        self.label_frame2.config(bg="light green")  # Set background window background color

        # Create and position labels and text boxes for Player Two
        self.player_two_label = Label(self.label_frame2, text="Player 2: ", relief=RIDGE, font=("Arial", 10, "bold"))
        self.player_two_label.grid(row=0, column=0, padx=10, pady=10, sticky=NW)

        self.player_two_name = Entry(self.label_frame2, text="Enter Name", width=12, relief=SUNKEN, font=("Arial", 10))
        self.player_two_name.grid(row=0, column=1, padx=0, pady=10, sticky=NW)

        self.player_two_cash_amount = Label(self.label_frame2, text="", width=7, relief=SUNKEN, font=("Arial", 10),
                                            bg='yellow')
        self.player_two_cash_amount.grid(row=0, column=4, padx=0, pady=10, sticky=NW)

        self.player_two_cash_label = Label(self.label_frame2, text="$:", font=("Arial", 10), bg="light green")
        self.player_two_cash_label.grid(row=0, column=3, padx=0, pady=10, sticky=E)

        # self.root.Separator(self.label_frame, orient=HORIZONTAL).grid(columnspan=5, row=1, sticky='ew')

        self.player_two_property_header = Label(self.label_frame2, text="Player Properties", relief=RIDGE,
                                                font=("Arial", 10, "bold"))
        self.player_two_property_header.grid(row=2, column=1, padx=0, pady=20, sticky=N)

        self.player_two_property_label = Label(self.label_frame2, height=292, width=49, font=("Arial", 8),
                                               relief=SUNKEN,
                                               bg="white")
        self.player_two_property_label.grid(columnspan=5, row=3, sticky="wens")
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

    # Initializes houses
    def initialize_houses(self):

        # house image
        self.house_img = PhotoImage(file='Resources/house.png')
        ##Houses
        #  Mediterranean house label
        self.brown_mediterranean_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.brown_mediterranean_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.brown_mediterranean_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.brown_mediterranean_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Baltic avenue house label
        self.baltic_avenue_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.baltic_avenue_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.baltic_avenue_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.baltic_avenue_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Oriental avenue house label
        self.oriental_Avenue_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.oriental_Avenue_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.oriental_Avenue_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.oriental_Avenue_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Vermont house  label
        self.vermont_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.vermont_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.vermont_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.vermont_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Connecticut house label
        self.connecticut_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.connecticut_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.connecticut_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.connecticut_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # ST Charles house label
        self.st_charles_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_charles_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_charles_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_charles_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # States house label
        self.states_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.states_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.states_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.states_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Virginia house label
        self.virginia_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.virginia_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.virginia_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.virginia_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # ST James house label
        self.st_james_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_james_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_james_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.st_james_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Tennessee house label
        self.tennessee_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.tennessee_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.tennessee_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.tennessee_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # New York house label
        self.new_york_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.new_york_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.new_york_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.new_york_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # kentucky house label
        self.kentucky_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.kentucky_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.kentucky_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.kentucky_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Indiana house label
        self.indiana_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.indiana_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.indiana_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.indiana_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Illnois house label
        self.illnois_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.illnois_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.illnois_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.illnois_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Atlantic house label
        self.atlantic_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.atlantic_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.atlantic_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.atlantic_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Ventor house label
        self.ventnor_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.ventnor_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.ventnor_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.ventnor_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Marvin house label
        self.marvin_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.marvin_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.marvin_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.marvin_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Pacific house label
        self.pacific_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pacific_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pacific_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pacific_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # North Carolina house label
        self.north_carolina_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.north_carolina_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.north_carolina_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.north_carolina_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Pennsylvania house label
        self.pennsylvania_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pennsylvania_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pennsylvania_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.pennsylvania_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Park house label
        self.park_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.park_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.park_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.park_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

        # Broadwalk house label
        self.broadwalk_house_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.broadwalk_house2_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.broadwalk_house3_label = Label(self.window, image=self.house_img, bg="#90EE90")
        self.broadwalk_house4_label = Label(self.window, image=self.house_img, bg="#90EE90")

    # Initializes hotels
    def initialize_hotels(self):
        # Hotel image
        self.hotel_img = PhotoImage(file='Resources/hotel.png')
        self.hotel_img2 = PhotoImage(file='Resources/hotel1.png')

        ## Hotel label
        self.brown_mediterranean_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.baltic_avenue_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.oriental_Avenue_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.vermont_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.connecticut_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.st_charles_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.states_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.virginia_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.st_james_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.tennessee_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.new_york_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.kentucky_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.indiana_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.illnois_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.atlantic_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.ventnor_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.marvin_hotel_label = Label(self.window, image=self.hotel_img, bg="#FF0000")
        self.pacific_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.north_carolina_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.pennsylvania_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.park_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")
        self.broadwalk_hotel_label = Label(self.window, image=self.hotel_img2, bg="#FF0000")

    # Moves player one position
    # param Player one index
    def player_one_position(self, position):
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
    def player_two_position(self, player2_position):
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

    def create_hotel(self, location, hotel_number):
        if location == 1:
            if hotel_number == 1:
                ## Forget houses
                self.brown_mediterranean_house_label.place_forget()
                self.brown_mediterranean_house2_label.place_forget()
                self.brown_mediterranean_house3_label.place_forget()
                self.brown_mediterranean_house4_label.place_forget()

                ## Create hotel
                self.brown_mediterranean_hotel_label.place(x=78, y=628)

        elif location == 3:
            if hotel_number == 1:
                ## Forget houses
                self.baltic_avenue_house_label.place_forget()
                self.baltic_avenue_house2_label.place_forget()
                self.baltic_avenue_house3_label.place_forget()
                self.baltic_avenue_house4_label.place_forget()

                ## Create hotel
                self.baltic_avenue_hotel_label.place(x=78, y=500)

        elif location == 6:
            if hotel_number == 1:
                ## Forget houses
                self.oriental_Avenue_house_label.place_forget()
                self.oriental_Avenue_house2_label.place_forget()
                self.oriental_Avenue_house3_label.place_forget()
                self.oriental_Avenue_house4_label.place_forget()

                ## Create hotel
                self.oriental_Avenue_hotel_label.place(x=78, y=308)
        elif location == 8:
            if hotel_number == 1:
                ## Forget houses
                self.vermont_house_label.place_forget()
                self.vermont_house2_label.place_forget()
                self.vermont_house3_label.place_forget()
                self.vermont_house4_label.place_forget()

                ## Create hotel
                self.vermont_hotel_label.place(x=78, y=180)

        elif location == 9:
            if hotel_number == 1:
                ## Forget houses
                self.connecticut_house_label.place_forget()
                self.connecticut_house2_label.place_forget()
                self.connecticut_house3_label.place_forget()
                self.connecticut_house4_label.place_forget()

                ## Create hotel
                self.connecticut_hotel_label.place(x=78, y=116)

        elif location == 11:
            if hotel_number == 1:
                ## Forget houses
                self.st_charles_house_label.place_forget()
                self.st_charles_house2_label.place_forget()
                self.st_charles_house3_label.place_forget()
                self.st_charles_house4_label.place_forget()

                ## Create hotel
                self.st_charles_hotel_label.place(x=116, y=78)
        elif location == 13:
            if hotel_number == 1:
                ## Forget houses
                self.states_house_label.place_forget()
                self.states_house2_label.place_forget()
                self.states_house3_label.place_forget()
                self.states_house4_label.place_forget()

                ## Create hotel
                self.states_hotel_label.place(x=242, y=78)

        elif location == 14:
            if hotel_number == 1:
                ## Forget houses
                self.virginia_house_label.place_forget()
                self.virginia_house2_label.place_forget()
                self.virginia_house3_label.place_forget()
                self.virginia_house4_label.place_forget()

                ##Create hotel
                self.virginia_hotel_label.place(x=307, y=79)

        elif location == 16:
            if hotel_number == 1:
                ## Forget houses
                self.st_james_house_label.place_forget()
                self.st_james_house2_label.place_forget()
                self.st_james_house3_label.place_forget()
                self.st_james_house4_label.place_forget()

                ##Create hotel
                self.st_james_hotel_label.place(x=435, y=78)
        elif location == 18:
            if hotel_number == 1:
                ## Forget houses
                self.tennessee_house_label.place_forget()
                self.tennessee_house2_label.place_forget()
                self.tennessee_house3_label.place_forget()
                self.tennessee_house4_label.place_forget()

                ##Create hotel
                self.tennessee_hotel_label.place(x=563, y=78)
        elif location == 19:
            if hotel_number == 1:
                ## Forget houses
                self.new_york_house_label.place_forget()
                self.new_york_house2_label.place_forget()
                self.new_york_house3_label.place_forget()
                self.new_york_house4_label.place_forget()

                ##Create hotel
                self.new_york_hotel_label.place(x=627, y=78)
        elif location == 21:
            if hotel_number == 1:
                ## Forget houses
                self.kentucky_house_label.place_forget()
                self.kentucky_house2_label.place_forget()
                self.kentucky_house3_label.place_forget()
                self.kentucky_house4_label.place_forget()

                ##Create hotel
                self.kentucky_hotel_label.place(x=677, y=117)
        elif location == 23:
            if hotel_number == 1:
                ## Forget houses
                self.indiana_house_label.place_forget()
                self.indiana_house2_label.place_forget()
                self.indiana_house3_label.place_forget()
                self.indiana_house4_label.place_forget()

                ##Create hotel
                self.indiana_hotel_label.place(x=677, y=238)
        elif location == 24:
            if hotel_number == 1:
                ## Forget houses
                self.illnois_house_label.place_forget()
                self.illnois_house2_label.place_forget()
                self.illnois_house3_label.place_forget()
                self.illnois_house4_label.place_forget()

                ##Create hotel
                self.illnois_hotel_label.place(x=677, y=305)

        elif location == 26:
            if hotel_number == 1:
                ## Forget houses
                self.atlantic_house_label.place_forget()
                self.atlantic_house2_label.place_forget()
                self.atlantic_house3_label.place_forget()
                self.atlantic_house4_label.place_forget()

                # Create hotel
                self.atlantic_hotel_label.place(x=677, y=433)
        elif location == 27:
            if hotel_number == 1:
                ## Forget houses
                self.ventnor_house_label.place_forget()
                self.ventnor_house2_label.place_forget()
                self.ventnor_house3_label.place_forget()
                self.ventnor_house4_label.place_forget()

                ##Create hotel
                self.ventnor_hotel_label.place(x=677, y=497)
        elif location == 29:
            if hotel_number == 1:
                ## Forget houses
                self.marvin_house_label.place_forget()
                self.marvin_house2_label.place_forget()
                self.marvin_house3_label.place_forget()
                self.marvin_house4_label.place_forget()
                ##Create hotel
                self.marvin_hotel_label.place(x=677, y=625)
        elif location == 31:
            if hotel_number == 1:
                ## Forget houses
                self.pacific_house_label.place_forget()
                self.pacific_house2_label.place_forget()
                self.pacific_house3_label.place_forget()
                self.pacific_house4_label.place_forget()

                ##Create hotel
                self.pacific_hotel_label.place(x=629, y=675)
        elif location == 32:
            if hotel_number == 1:
                ## Forget houses
                self.north_carolina_house_label.place_forget()
                self.north_carolina_house2_label.place_forget()
                self.north_carolina_house3_label.place_forget()
                self.north_carolina_house4_label.place_forget()

                ##Create hotel
                self.north_carolina_hotel_label.place(x=565, y=675)
        elif location == 34:
            if hotel_number == 1:
                ## Forget houses
                self.pennsylvania_house_label.place_forget()
                self.pennsylvania_house2_label.place_forget()
                self.pennsylvania_house3_label.place_forget()
                self.pennsylvania_house4_label.place_forget()

                ##Create hotel
                self.pennsylvania_hotel_label.place(x=435, y=675)
        elif location == 37:
            if hotel_number == 1:
                ## Forget houses
                self.park_house_label.place_forget()
                self.park_house2_label.place_forget()
                self.park_house3_label.place_forget()
                self.park_house4_label.place_forget()

                ##Create hotel
                self.park_hotel_label.place(x=243, y=675)
        elif location == 39:
            if hotel_number == 1:
                ## Forget houses
                self.broadwalk_house_label.place_forget()
                self.broadwalk_house2_label.place_forget()
                self.broadwalk_house3_label.place_forget()
                self.broadwalk_house4_label.place_forget()

                ##Create hotel
                self.broadwalk_hotel_label.place(x=118, y=675)

    # Builds the player house
    # Player position && Number of Houses
    def create_house(self, space_position, house_no):

        if space_position == 1:
            if house_no == 1:
                self.brown_mediterranean_house_label.place(x=85, y=658)
            elif house_no == 2:
                self.brown_mediterranean_house2_label.place(x=85, y=643)
            elif house_no == 3:
                self.brown_mediterranean_house3_label.place(x=85, y=628)
            elif house_no == 4:
                self.brown_mediterranean_house4_label.place(x=85, y=613)

        elif space_position == 3:
            if house_no == 1:
                self.baltic_avenue_house_label.place(x=85, y=530)
            elif house_no == 2:
                self.baltic_avenue_house2_label.place(x=85, y=515)
            elif house_no == 3:
                self.baltic_avenue_house3_label.place(x=85, y=500)
            elif house_no == 4:
                self.baltic_avenue_house4_label.place(x=85, y=485)

        elif space_position == 6:
            if house_no == 1:
                self.oriental_Avenue_house_label.place(x=85, y=338)
            elif house_no == 2:
                self.oriental_Avenue_house2_label.place(x=85, y=323)
            elif house_no == 3:
                self.oriental_Avenue_house3_label.place(x=85, y=308)
            elif house_no == 4:
                self.oriental_Avenue_house4_label.place(x=85, y=293)

        elif space_position == 8:
            if house_no == 1:
                self.vermont_house_label.place(x=85, y=210)
            elif house_no == 2:
                self.vermont_house2_label.place(x=85, y=195)
            elif house_no == 3:
                self.vermont_house3_label.place(x=85, y=180)
            elif house_no == 4:
                self.vermont_house4_label.place(x=85, y=165)

        elif space_position == 9:
            if house_no == 1:
                self.connecticut_house_label.place(x=85, y=146)
            elif house_no == 2:
                self.connecticut_house2_label.place(x=85, y=131)
            elif house_no == 3:
                self.connecticut_house3_label.place(x=85, y=116)
            elif house_no == 4:
                self.connecticut_house4_label.place(x=85, y=101)

        elif space_position == 11:
            if house_no == 1:
                self.st_charles_house_label.place(x=101, y=80)
            elif house_no == 2:
                self.st_charles_house2_label.place(x=116, y=80)
            elif house_no == 3:
                self.st_charles_house3_label.place(x=131, y=80)
            elif house_no == 4:
                self.st_charles_house4_label.place(x=146, y=80)

        elif space_position == 13:
            if house_no == 1:
                self.states_house_label.place(x=227, y=80)
            elif house_no == 2:
                self.states_house2_label.place(x=242, y=80)
            elif house_no == 3:
                self.states_house3_label.place(x=257, y=80)
            elif house_no == 4:
                self.states_house4_label.place(x=273, y=80)

        elif space_position == 14:
            if house_no == 1:
                self.virginia_house_label.place(x=291, y=80)
            elif house_no == 2:
                self.virginia_house2_label.place(x=307, y=80)
            elif house_no == 3:
                self.virginia_house3_label.place(x=322, y=80)
            elif house_no == 4:
                self.virginia_house4_label.place(x=337, y=80)

        elif space_position == 16:
            if house_no == 1:
                self.st_james_house_label.place(x=420, y=80)
            elif house_no == 2:
                self.st_james_house2_label.place(x=435, y=80)
            elif house_no == 3:
                self.st_james_house3_label.place(x=450, y=80)
            elif house_no == 4:
                self.st_james_house4_label.place(x=465, y=80)

        elif space_position == 18:
            if house_no == 1:
                self.tennessee_house_label.place(x=548, y=80)
            elif house_no == 2:
                self.tennessee_house2_label.place(x=563, y=80)
            elif house_no == 3:
                self.tennessee_house3_label.place(x=578, y=80)
            elif house_no == 4:
                self.tennessee_house4_label.place(x=593, y=80)

        elif space_position == 19:
            if house_no == 1:
                self.new_york_house_label.place(x=612, y=80)
            elif house_no == 2:
                self.new_york_house2_label.place(x=627, y=80)
            elif house_no == 3:
                self.new_york_house3_label.place(x=642, y=80)
            elif house_no == 4:
                self.new_york_house4_label.place(x=657, y=80)

        elif space_position == 21:
            if house_no == 1:
                self.kentucky_house_label.place(x=677, y=102)
            elif house_no == 2:
                self.kentucky_house2_label.place(x=677, y=117)
            elif house_no == 3:
                self.kentucky_house3_label.place(x=677, y=132)
            elif house_no == 4:
                self.kentucky_house4_label.place(x=677, y=147)

        elif space_position == 23:
            if house_no == 1:
                self.indiana_house_label.place(x=677, y=225)
            elif house_no == 2:
                self.indiana_house2_label.place(x=677, y=238)
            elif house_no == 3:
                self.indiana_house3_label.place(x=677, y=253)
            elif house_no == 4:
                self.indiana_house4_label.place(x=677, y=268)

        elif space_position == 24:
            if house_no == 1:
                self.illnois_house_label.place(x=677, y=290)
            elif house_no == 2:
                self.illnois_house2_label.place(x=677, y=305)
            elif house_no == 3:
                self.illnois_house3_label.place(x=677, y=320)
            elif house_no == 4:
                self.illnois_house4_label.place(x=677, y=335)

        elif space_position == 26:
            if house_no == 1:
                self.atlantic_house_label.place(x=677, y=418)
            elif house_no == 2:
                self.atlantic_house2_label.place(x=677, y=433)
            elif house_no == 3:
                self.atlantic_house_label.place(x=677, y=448)
            elif house_no == 4:
                self.atlantic_house_label.place(x=677, y=463)

        elif space_position == 27:
            if house_no == 1:
                self.ventnor_house_label.place(x=677, y=482)
            elif house_no == 2:
                self.ventnor_house2_label.place(x=677, y=497)
            elif house_no == 3:
                self.ventnor_house3_label.place(x=677, y=512)
            elif house_no == 4:
                self.ventnor_house4_label.place(x=677, y=527)

        elif space_position == 29:
            if house_no == 1:
                self.marvin_house_label.place(x=677, y=610)
            elif house_no == 2:
                self.marvin_house2_label.place(x=677, y=625)
            elif house_no == 3:
                self.marvin_house3_label.place(x=677, y=640)
            elif house_no == 4:
                self.marvin_house4_label.place(x=677, y=655)

        elif space_position == 31:
            if house_no == 1:
                self.pacific_house_label.place(x=614, y=677)
            elif house_no == 2:
                self.pacific_house2_label.place(x=629, y=677)
            elif house_no == 3:
                self.pacific_house3_label.place(x=644, y=677)
            elif house_no == 4:
                self.pacific_house4_label.place(x=659, y=677)

        elif space_position == 32:
            if house_no == 1:
                self.north_carolina_house_label.place(x=550, y=677)
            elif house_no == 2:
                self.north_carolina_house2_label.place(x=565, y=677)
            elif house_no == 3:
                self.north_carolina_house3_label.place(x=580, y=677)
            elif house_no == 4:
                self.north_carolina_house4_label.place(x=595, y=677)

        elif space_position == 34:
            if house_no == 1:
                self.pennsylvania_house_label.place(x=420, y=677)
            elif house_no == 2:
                self.pennsylvania_house2_label.place(x=435, y=677)
            elif house_no == 3:
                self.pennsylvania_house3_label.place(x=450, y=677)
            elif house_no == 4:
                self.pennsylvania_house4_label.place(x=465, y=677)

        elif space_position == 37:
            if house_no == 1:
                self.park_house_label.place(x=228, y=677)
            elif house_no == 2:
                self.park_house2_label.place(x=243, y=677)
            elif house_no == 3:
                self.park_house3_label.place(x=258, y=677)
            elif house_no == 4:
                self.park_house4_label.place(x=273, y=677)

        elif space_position == 39:
            if house_no == 1:
                self.broadwalk_house_label.place(x=103, y=677)
            elif house_no == 2:
                self.broadwalk_house2_label.place(x=118, y=677)
            elif house_no == 3:
                self.broadwalk_house3_label.place(x=133, y=677)
            elif house_no == 4:
                self.broadwalk_house4_label.place(x=148, y=677)

    def deactivate_space_button(self):
        self.space_button_list = [self.go_button, self.brown_mediterranean_button, self.community_chest_button,
                                  self.baltic_avenue_button, self.income_tax_button
            , self.reading_railroad_button, self.oriental_Avenue__button, self.pink_chance_button, self.vermont_button,
                                  self.connecticut_button
            , self.jail_button, self.charles_button, self.electric_button, self.states_button, self.virginia_button,
                                  self.penn_railroad_button, self.james_button
            , self.community_chest_2_button, self.tennessee_button, self.new_york_button, self.parking_button,
                                  self.kentucky_button, self.chance_button
            , self.indiana_button, self.illnois_button, self.b_o_railroad_button, self.atlantic_button,
                                  self.ventnor_button, self.water_works_button,
                                  self.marvin_button
            , self.go_to_jail_button, self.broadwalk_button, self.luxury_tax_button, self.park_place_button,
                                  self.orange_chance_button, self.short_line_button
            , self.pennsylvania_button, self.community_chest_3_button, self.north_carolina_button, self.pacific_button]

        for i in range(len(self.space_button_list)):
            self.space_button_list[i]['command'] = 1
            self.space_button_list[i]['relief'] = 'sunken'

    # gameplay buttons

    # post request to /api/roll
    def button_roll(self):
        response = self.cman.create_post_request(self.player.uuid, "/api/roll")
        self.get_board_update_single()

    # post request to /api/purchase
    def button_purchase(self):
        response = self.cman.create_post_request(self.player.uuid, "/api/purchase/property")
        self.get_board_update_single()

    # post request to /api/build/house
    def button_house(self):
        # Temp method to make player buy house
        # global position, house_num
        # self.create_house(position, house_num + 1)
        # house_num = (house_num + 1) % 5
        response = self.cman.create_post_request(self.player.uuid, "/api/purchase/house")
        self.get_board_update_single()

    # post request to /api/build/house
    def button_hotel(self):
        # global position, hotel_num
        # self.create_hotel(position, hotel_num)
        # test = "test"
        response = self.cman.create_post_request(self.player.uuid, "/api/purchase/hotel")
        self.get_board_update_single()

    def button_end_turn(self):
        response = self.cman.create_post_request(self.player.uuid, "/api/end")
        self.get_board_update_single()

    # Utility Functions

    def get_board_update_single(self):
        response = self.cman.create_get_request("/api/update")
        outputgs = json.loads(response.content, object_hook=lambda d: SimpleNamespace(**d))

        # update all relevant board info TODO devise a way to draw the other necessary board information
        self.player_one_position(outputgs.player1.position)
        self.player_two_position(outputgs.player2.position)
        for l in outputgs.board:

            if l.location == 1 or l.location == 3 or l.location == 6 or \
                    l.location == 8 or l.location == 9 or l.location == 11 \
                    or l.location == 13 or l.location == 14 or l.location == 16 or \
                    l.location == 18 or l.location == 19 or l.location == 21 \
                    or l.location == 23 or l.location == 24 or l.location == 26 \
                    or l.location == 27 or l.location == 29 or l.location == 31 \
                    or l.location == 32 or l.location == 34 or l.location == 37 \
                    or l.location == 39:
                numhouses = l.houseNumber
                numhotels = l.hotelNumber
                location = l.location
                self.create_house(location, numhouses)
                self.create_hotel(location, numhotels)

        self.window.update()
        print("Board Updated From Server!")

    # main update loop for drawing window and updating gameboard
    def main_update_loop(self):
        i = 69
        while i <= 70:
            # submit a get request to the server
            self.get_board_update_single()
            # we wait before looping again for another server update,
            # drawing the window regularly while not spamming requests to the server
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
            time.sleep(.25)
            self.window.update()
