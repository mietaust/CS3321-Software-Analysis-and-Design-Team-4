import pygame



#Test window using pygame - builds a simple window, 800x600 gray background
#https://pygame-gui.readthedocs.io/en/latest/quick_start.html
pygame.init()

pygame.display.set_caption('Connection Window')
window_surface = pygame.display.set_mode((800,600))

background = pygame.Surface((800,600))
background.fill(pygame.Color('#808080'))

is_running = True

while is_running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            is_running = False

        window_surface.blit(background, (0,0))

        pygame.display.update()