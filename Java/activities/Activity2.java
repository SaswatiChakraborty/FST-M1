package src.activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr = {10, 77, 10, 54, -11, 10};

        int expectedValue = 30;
        int sum = 0;

        int size = arr.length;

        for (int i = 0; i < size; i++) {
            if(arr[i] == 10) {
                sum += arr[i];
            }
        }

        if(sum == expectedValue)
            System.out.println(" both are equal");
            else
                System.out.println(" both are not equal");


    }
}
