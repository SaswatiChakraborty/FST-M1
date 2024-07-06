class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model,
        self.make = make
        self.transmission = transmission,
        self.color = color

    def accelerate(self):
        print(self.manufacturer,self.model," is moving")

    def stop(self):
        print(self.manufacturer,self.model," has stopped")

car1 = Car("Honda", "City", "2015", "Manual", "Grey")
car2 = Car("Maruti", "1000", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car2.stop()


