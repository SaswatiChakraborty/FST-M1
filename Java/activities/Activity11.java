package src.activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        boolean flag = false;
        HashMap<Integer, String> colours = new HashMap<>();
        colours.put(1, "red");
        colours.put(2, "blue");
        colours.put(3, "pink");
        colours.put(4, "yellow");
        colours.put(5, "orange");

        for(Map.Entry<Integer, String> mv:colours.entrySet()){
            System.out.println(mv.getKey() + " " + mv.getValue());
        }
        System.out.println("removed a color from the map => "+colours.remove(4));

        for(Integer key : colours.keySet()) {
            if(colours.get(key).equals("green")) {
                System.out.println("green is present in the map");
                flag = true;
                break;
            }
        }

        if(!flag)
            System.out.println("green is not present in the map");

        if(colours.containsValue("green"))
            System.out.println("green is present in the map");
        else
            System.out.println("green is not present in the map");

        System.out.println("size of the map => "+colours.size());
        System.out.println("final map => "+colours);
    }
}
