import tkinter
from tkinter import *
import gameBoard
import Frontend.main.GUI.newPlayer
import json


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
                           font=('Arial', 13, 'bold'), bg="#BFDBAE"
                           )
        self.label.place(x=10, y=60)
        self.window.configure(bg="#BFDBAE")

        # button definitions
        self.quit_button = Button(self.window, text="QUIT", command=self.quitbutton, width=10,
                                  font=('Arial', 13, 'bold'))
        self.quit_button.place(x=10, y=10)

        self.test_button = Button(self.window, text="Play Game", command=self.open_game,
                                  width=10, font=('Arial', 13, 'bold'))
        self.test_button.place(x=365, y=435)

        self.handshake_button = Button(self.window, text="introduce to server", command=self.introduce,
                                  width=16, font=('Arial', 13, 'bold'))
        self.handshake_button.place(x=185, y=435)

        # TODO |Overview for wait logic. At this point the game has introduced itself to the server,
        # TODO |exchanged unique identifiers, and is capable of passing information back and forth. When
        # TODO |the server sends the go-ahead to the clients to begin the game, we will launch the Resources.

        # window loop
        self.window.mainloop()

    # button functions
    def quitbutton(self):
        self.window.destroy()  # Closes waiting room
        # handle quit logic. TODO - negotiate quitting with the server.
        # Send a quit command, server removes player from queue.

    def open_game(self):
        self.window.destroy()  # Closes waiting room
        gameBoard.GameBoard()  # Opens GameBoard

    def introduce(self):
        p = Frontend.main.GUI.newPlayer.NewPlayer(self.name)
        transmit = json.dumps(p.__dict__)
        l = self.cman.create_post_request(transmit, "/api/join")




