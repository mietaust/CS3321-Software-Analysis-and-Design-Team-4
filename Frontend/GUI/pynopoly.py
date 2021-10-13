# ThorPy Pynopoly game:
import thorpy, pygame

pygame.init()

class Pynopoly(object):

    def __init__(self, player_name, ip_address, port_number):
        # stating player specific parameters
        self.reac_insert_func = None
        self.player_name = player_name  # the player's name to be used
        self.ip_address = ip_address  # the ip address to be used
        self.port_number = port_number  # the port number to be used

        # stating quit function
        self.e_quit = thorpy.make_button("Quit", func=thorpy.functions.quit_menu_func)
        # stating ghost to store quit function
        self.e_group_menu = thorpy.make_group([self.e_quit])

        self.e_background = thorpy.Background(color=(20, 200, 255), elements=[self.e_group_menu])
        thorpy.store(self.e_background, gap=20)
        # reaction called each time the player has inserted something
        reaction_insert = thorpy.ConstantReaction(
            reacts_to=thorpy.constants.THORPY_EVENT,
            reac_func=self.reac_insert_func)

    def restart(self):
        self.e_background.unblit()
        self.e_background.update()
        self.__init__(self.player_name, self.ip_address, self.port_number)

    def launch_game(self):
        pygame.display.set_caption('Connection Window') #CANT GET THIS TO WORK
        menu = thorpy.Menu(self.e_background)  # create and launch the menu
        menu.play()
