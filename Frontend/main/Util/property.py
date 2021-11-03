import space


class Property(space):
    def __init__(self, name, location, value, rent):
        space.Space.__init__(name, location)
        self.value = value
        self.rent = rent

