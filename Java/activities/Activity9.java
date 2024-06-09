package src.activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<String>();
        myList.add("Java");
        myList.add("C");
        myList.add("C++");
        myList.add("JavaScript");
        myList.add("Python");

        for (String s : myList) {
            System.out.print(s+"  ");
        }

        System.out.println("\n3rd element: " + myList.get(2));

        System.out.println("Check if python is present: " + myList.contains("Python"));
        if (myList.contains("Python")) {
            System.out.println("value matches");
        }

        System.out.println("total elements: " + myList.size());

        System.out.println("Removed elements: " + myList.remove("C"));
        System.out.println("Size of list after element removed: " + myList.size());
    }
}
