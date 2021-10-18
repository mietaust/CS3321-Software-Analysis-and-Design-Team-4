from tkinter import *
from main.Networking.ConnectionManager import ConnectionManager


class DebugPage:

    def __init__(self, cman, url):
        # window definitions
        self.window = Tk()
        self.window.geometry("500x500")
        self.window.title("Debug")
        self.window.resizable(True, True)
        self.cman = cman
        self.url = url

        # button definitions
        self.get_button = Button(self.window, text="GET", command=self.gbutton, width=10,
                                 font=('Arial', 13, 'bold')).place(x=155, y=34)

        self.post_button = Button(self.window, text="POST", command=self.pbutton, width=10,
                                  font=('Arial', 13, 'bold')).place(x=265, y=34)

        # window loop
        self.window.mainloop()

    # button functions
    def gbutton(self):
        test = "hg"
        result = self.cman.create_get_request()
        print(result)

    def pbutton(self):
        test = "hey"
        result = self.cman.create_post_request("hey")
        print(result)
