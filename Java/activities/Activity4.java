package src.activities;

public class Activity4 {
    public static void main(String[] args) {
        int[] arr = {10,7,3,1,5,9,4,8,6,2};

        System.out.println("unsorted array");
        for (int i:arr)
            System.out.print(i+ " ");

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("\nsorted array");
        for (int i:arr)
            System.out.print(i+ " ");
    }
}
