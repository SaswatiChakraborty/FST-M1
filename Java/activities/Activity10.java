package src.activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(4);
        hs.add(5);
        hs.add(6);

        System.out.println("added elements in hashset: " + hs);
        System.out.println("size of hashset: " + hs.size());
        System.out.println("removed element in hashset: " + hs.remove(5));
        System.out.println("removed an elements which is not present in hashset: " + hs.remove(9));
        System.out.println("checking elements in hashset: " + hs.contains(4));

        System.out.println("hash set after removal");
        for(int i:hs)
            System.out.print(i+" ");

    }
}
