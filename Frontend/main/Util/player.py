class Player:
    def __init__(self, name, accountbalance):
        self.name = name
        self.accountBalance = accountbalance
        self.inJail = False
        self.position = 0
        self.propertyOwned = []
