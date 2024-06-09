package src.activities;

public class Activity3 {
    public static void main(String[] args) {
        double earth_Orbit_period = 365.25;
        double earth_seconds = earth_Orbit_period*24*3600;
        System.out.println(earth_seconds);

        double mercury_earth_Seconds = 0.2408467;
        double venus_earth_Seconds = 0.61519726;
        double mars_earth_Seconds = 1.8808158;
        double jupiter_earth_Seconds = 11.862615;
        double saturn_earth_Seconds = 29.447498;
        double uranus_earth_Seconds = 84.016846;
        double neptune_earth_Seconds = 164.79132;

        double person_age_seconds = 1000000000;

        System.out.println("persons age on earth: " + person_age_seconds/earth_seconds);
        System.out.println("persons age on mercury: " + calculate_age(mercury_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on venus: " + calculate_age(venus_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on mars: " + calculate_age(mars_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on jupiter: " + calculate_age(jupiter_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on saturn: " + calculate_age(saturn_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on uranus: " + calculate_age(uranus_earth_Seconds,person_age_seconds,earth_seconds));
        System.out.println("persons age on neptune: " + calculate_age(neptune_earth_Seconds,person_age_seconds,earth_seconds));
    }

    static double calculate_age(double planetAge, double personsAge, double earthSeconds){
            return personsAge/earthSeconds/planetAge;
    }
}
