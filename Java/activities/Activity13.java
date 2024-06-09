package src.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> list = new ArrayList<Integer>();
        while(scan.hasNextInt()) {
            list.add(scan.nextInt());
        }

        Random indexGen = new Random();
        Integer nums[] = list.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("index: " + index);
        System.out.println("nums: " + nums[index]);
        scan.close();

        }

}
