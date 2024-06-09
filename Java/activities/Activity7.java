package src.activities;

interface BicycleParts{
    int gears = 0;
    int currentSpeed = 0;
}

interface BicycleOperations{
     void applyBrake(int decrement);
     void speedUp(int increment);

}

class Bicycle implements BicycleParts, BicycleOperations {
    public int gears;
    public int currentSpeed;

    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

   public void applyBrake(int decrement){
        currentSpeed = currentSpeed - decrement;
    }

    public void speedUp(int increment){
        currentSpeed = currentSpeed + increment;
    }

    public void bicycleDesc() {
        System.out.println("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle{
    int seatHeight;
    public MountainBike(int gears, int currentSpeed, int seatHeight){
        super(gears, currentSpeed);
        this.seatHeight = seatHeight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public void bicycleDesc(){
        super.bicycleDesc();
       System.out.println("seat height is "+ seatHeight);
    }
}

public class Activity7 {
    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        mb.bicycleDesc();
        mb.speedUp(20);
        System.out.println("now speed is "+ mb.currentSpeed);
        mb.applyBrake(5);
        System.out.println("now speed is "+ mb.currentSpeed);
    }
}
