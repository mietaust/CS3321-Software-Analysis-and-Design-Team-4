import property


class Street(property):
    def __init__(self, name, location, value, rent, color, buildprice, rentlist):
        property.Property(name, location, value, rent)
        self.color = color
        self.buildPrice = buildprice
        self.rentList = rentlist

