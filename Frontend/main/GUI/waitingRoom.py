from tkinter import *
from Frontend.main.Networking.ConnectionManager import ConnectionManager


class WaitRoom:

    def __init__(self, cman, url, name):
        # window definitions
        self.window = Tk()
        self.window.geometry("500x500")
        self.window.title("Waiting")
        self.window.resizable(False, False)
        self.cman = cman
        self.url = url
        self.name = name

        print("Waiting for server to start the game.")

        # window contents
        self.label = Label(self.window,
                           text="Welcome, " + self.name + "! Please wait for the game to start.",
                           font=('Arial', 13, 'bold')
                           )
        self.label.place(x=10, y=60)

        # button definitions
        self.quit_button = Button(self.window, text="QUIT", command=self.quitbutton, width=10,
                                 font=('Arial', 13, 'bold')).place(x=10, y=10)

        # TODO |Overview for wait logic. At this point the game has introduced itself to the server,
        # TODO |exchanged unique identifiers, and is capable of passing information back and forth. When
        # TODO |the server sends the go-ahead to the clients to begin the game, we will launch the gameboard.

        # window loop
        self.window.mainloop()

    # button functions
    def quitbutton(self):
        self.window.destroy()
        # handle quit logic. TODO - negotiate quitting with the server.
        # Send a quit command, server removes player from queue.

