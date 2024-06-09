package src.activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Harry Potter");
        plane.onboard("James Brown");
        plane.onboard("Clara Smith");
        plane.onboard("Jerry Thomas");
        plane.onboard("Tom Riddle");
        plane.onboard("Ron Wisely");
        plane.onboard("Emma Watson");
        plane.onboard("Daniel Radcliffe");
        plane.onboard("Hermione Granger");
        plane.onboard("Rupert Grint");

        System.out.println("Take off time of the plane => "+plane.takeOff());
        System.out.println("Passengers present in the plane\n" + plane.getPassengers());
        Thread.sleep(5000);
        System.out.println("land the plane");
        plane.land();
        System.out.println("last time landed => "+plane.getLastTimeLanded());
    }
}
