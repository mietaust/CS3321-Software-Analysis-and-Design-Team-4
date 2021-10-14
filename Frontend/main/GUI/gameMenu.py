import thorpy
import pynopoly
import pygame
import requests
from Frontend.main.Networking.Client import Client

pygame.init()


# launch the game using parameters from varset
def launch_game():
    global varset, e_background, e_title
    game = pynopoly.Pynopoly(player_name=varset.get_value("playername"),
                             ip_address=varset.get_value("ipaddress"),
                             port_number=varset.get_value("portnumber"),
                             )
    game.launch_game()
    game.e_background.unblit()
    game.e_background.update()
    e_background.unblit_and_reblit()


application = thorpy.Application(size=(600, 400), caption="Game Menu")

thorpy.set_theme("human")

e_title = thorpy.make_text("PYNOPOLY", font_size=20, font_color=(0, 0, 0))
e_title.center()  # center the title on the screen
e_title.set_center_pos((None, 120))  # set the y-coord at 10

varset = thorpy.VarSet()  # here we will declare options that user can set
varset.add("playername", value="Enter Your Name", text="Player name:")
varset.add("ipaddress", value=0, text="Enter ip address:")
varset.add("portnumber", value=0, text="Enter port number:")

e_play = thorpy.ParamSetterLauncher.make([varset], "Play!")
e_quit = thorpy.make_button("Quit", func=thorpy.functions.quit_menu_func)

e_background = thorpy.Background(color=(20, 200, 255), elements=[e_title, e_play, e_quit])
thorpy.store(e_background, [e_play, e_quit])

menu = thorpy.Menu([e_background, e_title])
menu.play()




