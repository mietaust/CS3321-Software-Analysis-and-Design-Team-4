import threading
import tkinter
from tkinter import *
import gameBoard
import Frontend.main.GUI.newPlayer
import Frontend.main.GUI.gameBoard
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

        self.newplayer = self.introduce()

        print("Waiting for server to start the game.")

        # window contents
        self.label = Label(self.window,
                           text="Welcome, " + self.newplayer.name + "! Please wait for the game to start. \r\n" + "UUID: " + self.newplayer.uuid + ".",
                           font=('Arial', 13, 'bold'), bg="#BFDBAE"
                           )
        self.label.place(x=10, y=60)
        self.window.configure(bg="#BFDBAE")

        # button definitions
        self.quit_button = Button(self.window, text="QUIT", command=self.wait_loop(), width=10,
                                  font=('Arial', 13, 'bold'))
        self.quit_button.place(x=230, y=10)

        # self.test_button = Button(self.window, text="Play Game", command=self.open_game,
        #                           width=10, font=('Arial', 13, 'bold'))
        # self.test_button.place(x=365, y=435)

        # self.handshake_button = Button(self.window, text="introduce to server", command=self.introduce,
        #                         width=16, font=('Arial', 13, 'bold'))
        # self.handshake_button.place(x=185, y=435)

        # TODO |Overview for wait logic. At this point the game has introduced itself to the server,
        # TODO |exchanged unique identifiers, and is capable of passing information back and forth. When
        # TODO |the server sends the go-ahead to the clients to begin the game, we will launch the Resources.

        t2 = Thread(self.wait_loop())
        t2.start()

    # button functions
    def quit_button(self):
        self.window.destroy()  # Closes waiting room
        # handle quit logic. TODO - negotiate quitting with the server.
        # Send a quit command, server removes player from queue.

    def open_game(self):
        self.window.destroy()  # Closes waiting room
        gameBoard.GameBoard()  # Opens GameBoard

    def introduce(self):
        l = self.cman.create_post_request(self.name, "/api/join")
        modifiedString = str(l.content)
        d = modifiedString.lstrip('b')
        print("Received UUID " + d + ".")
        return Frontend.main.GUI.player.NewPlayer(self.name, d)

    def draw_window(self):
        self.window.update()

    def wait_loop(self):
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
                print(str(outputgs.gamestart))