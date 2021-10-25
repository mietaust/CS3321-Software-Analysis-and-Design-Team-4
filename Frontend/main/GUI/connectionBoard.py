from tkinter import *
from Frontend.main.Networking.ConnectionManager import ConnectionManager
import waitingRoom


class ConnectionBoard:

    def __init__(self):
        self.window = Tk()  # instantiate an instance of a window
        self.window.geometry("550x150")  # window width and height
        self.window.title("Connect")
        self.window.resizable(False, False)  # set window size resizable to false
        self.url = StringVar()
        self.name = StringVar()
        self.connect_button = Button(self.window, text="Connect", command=self.connect, width=7,
                                     font=('Arial', 12, 'bold'))
        self.connect_button.place(x=465, y=110)

        self.reset_button = Button(self.window, text="Reset",
                                   command=self.reset, width=7,
                                   font=('Arial', 12, 'bold'))
        self.reset_button.place(x=370, y=110)

        self.entry = Entry(self.window, textvariable=self.url,  # Entry
                           font=('Arial', 13, 'bold'), width=
                           40)
        self.entry.place(x=137, y=34)
        self.label = Label(self.window,
                           text="Server URL :",
                           font=('Arial', 13, 'bold')
                           )
        self.label.place(x=10, y=30)
        self.label = Label(self.window,
                           text="Name:",
                           font=('Arial', 13, 'bold')
                           )
        self.label.place(x=10, y=60)

        self.entry1 = Entry(self.window, textvariable=self.name,  # Entry
                           font=('Arial', 13, 'bold'), width=
                           40)
        self.entry1.place(x=137, y=64)

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
                waitingRoom.WaitRoom(connection, newUrl, self.namehandler())

                # use to open debug page # debugPage.DebugPage(connection, newUrl)
            else:
                print("Unable to connect to server")
                self.reset()

    def namehandler(self):
        retname = ""
        if len(self.name.get()) <= 0:
            print("Invalid Name, using default.")
            retname = "Icarus"
        else:
            retname = self.name.get()
        return retname







    # Function clears entry text
    def reset(self):
        self.entry.delete(0,END)
        self.entry1.delete(0,END)
        






connect = ConnectionBoard()
