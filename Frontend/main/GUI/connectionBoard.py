from tkinter import *
from Frontend.main.Networking.ConnectionManager import ConnectionManager
import Frontend.main.GUI.waitingRoom
import Frontend.main.GUI.debugPage
import gameBoard


class ConnectionBoard:

    def __init__(self):
        self.window = Tk()  # instantiate an instance of a window
        self.window.geometry("550x150")  # window width and height
        self.window.title("Connect")
        self.window.resizable(False, False)  # set window size resizable to false
        self.url = StringVar()  # Stores URL value from URL enrty
        self.name = StringVar() # Stores Player name from the assocaited entry
        self.connect_button = Button(self.window, text="Connect", command=self.connect, width=7,
                                     font=('Arial', 12, 'bold'))
        self.connect_button.place(x=465, y=110)
        self.window.configure(bg="#BFDBAE")
        self.reset_button = Button(self.window, text="Reset",
                                   command=self.reset, width=7,
                                   font=('Arial', 12, 'bold'))
        self.reset_button.place(x=370, y=110)

        # URL entry
        self.entry = Entry(self.window, textvariable=self.url,  # Entry
                           font=('Arial', 13, 'bold'), width=
                           40)
        self.entry.place(x=137, y=34)

        # URL label
        self.label = Label(self.window,
                           text="Server URL :",
                           font=('Arial', 13, 'bold'), bg="#BFDBAE"
                           )
        # Name Label
        self.label.place(x=10, y=30)
        self.label = Label(self.window,
                           text="Name:",
                           font=('Arial', 13, 'bold'), bg="#BFDBAE"
                           )
        self.label.place(x=10, y=60)

        # Name entry
        self.name_entry = Entry(self.window, textvariable=self.name,
                                font=('Arial', 13, 'bold'), width=
                           40)
        self.name_entry.place(x=137, y=64)

        self.window.mainloop()  # show screen

    # Function for connecting to server
    # Should display game menu if connection is successful
    def connect(self):
        newUrl = ""  # store URL
        if len(self.url.get()) <= 0:
            print("NO Url")
            self.reset()
        else:
            newUrl = self.url.get()
            print(newUrl)
            connection = ConnectionManager.get_instance(newUrl)  # create instance of connection manager
            if connection.test(newUrl) == 200 and newUrl is not None:
                print(connection.create_get_request().text)  # actually meant to pull the game menu
                self.window.destroy()
                Frontend.main.GUI.waitingRoom.WaitRoom(connection, newUrl, self.namehandler())  # Opens player waiting room

            else:
                print("Unable to connect to server")
                self.reset()

    #Returns player name
    def namehandler(self):
        retname = ""  #Store URL
        if len(self.name.get()) <= 0:
            print("Invalid Name, using default.")
            retname = "Icarus"
        else:
            retname = self.name.get()
        return retname



    # Function clears entry text
    def reset(self):
        self.entry.delete(0,END)
        self.name_entry.delete(0, END)


connect = ConnectionBoard()


