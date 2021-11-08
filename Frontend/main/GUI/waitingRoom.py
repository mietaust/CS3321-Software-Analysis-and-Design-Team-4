import threading
import tkinter
from tkinter import *
import gameBoard
import main.GUI.player
import main.GUI.gameBoard
import json
from types import SimpleNamespace
import time
from threading import Thread


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

        self.newPlayer = self.introduce()

        print("Waiting for server to start the game.")

        # window contents
        self.label = Label(self.window,
                           text="Welcome, " + self.newPlayer.name + "! Please wait for the game to start. \r\n" + "UUID: " + self.newPlayer.uuid + ".",
                           font=('Arial', 13, 'bold'), bg="#BFDBAE"
                           )
        self.label.place(x=10, y=60)
        self.window.configure(bg="#BFDBAE")

        # button definitions
        self.quit_button = Button(self.window, text="QUIT", command=self.show_game, width=10,
                                  font=('Arial', 13, 'bold'))
        self.quit_button.place(x=230, y=10)

        # TODO |Overview for wait logic. At this point the game has introduced itself to the server,
        # TODO |exchanged unique identifiers, and is capable of passing information back and forth. When
        # TODO |the server sends the go-ahead to the clients to begin the game, we will launch the Resources.

        self.t2 = Thread(target=self.show_game())
        self.t2.start()

    # button functions
    def quit_button(self):
        self.window.destroy()  # Closes waiting room
        # handle quit logic. TODO - negotiate quitting with the server.
        # Send a quit command, server removes player from queue.

    # Sends player name to server
    # Creates Player
    def introduce(self):
        l = self.cman.create_post_request(self.name, "/api/join")
        modifiedString = str(l.content)
        d = modifiedString.lstrip('b')
        print("Received UUID " + d + ".")
        return main.GUI.player.NewPlayer(self.name, d)

    def draw_window(self):
        self.window.update()

    # Checks if two players are
    # ready before starting game
    def show_game(self):
        i = 68
        while i <= 69:
            self.window.update()
            response = self.cman.create_get_request("/api/update")
            outputgs = json.loads(response.content, object_hook=lambda d: SimpleNamespace(**d))

            if outputgs.gameStart:
                # we open up the gameboard passing relevant info
                self.window.destroy()
                gameBoard.GameBoard(self.cman, self.newPlayer)
            else:
                # we wait before looping again
                time.sleep(.3)
                self.window.update()


"""def wait_loop(self):
     i = 68
     while i <= 69:
         self.window.update()
         l = self.cman.create_get_request("/api/update")
         outputgs = json.loads(l.content, object_hook=lambda d: SimpleNamespace(**d))

         if outputgs.gamestart == True:
             # we open up the gameboard passing relevant info
             self.window.destroy()
             gameBoard.GameBoard(self.cman, self.newplayer)
         else:
             # we wait before looping again
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             time.sleep(.5)
             self.window.update()
             print(str(outputgs.gamestart))"""
