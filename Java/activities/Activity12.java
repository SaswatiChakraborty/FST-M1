package src.activities;

interface Addable{
      int add(int num1, int num2);
}

public record Activity12() {
    public static void main(String[] args) {
        int result1,result2;

        Addable ad1 = (a, b) -> (a + b);
        System.out.println(result1 = ad1.add(1, 2));

        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(result2 = ad2.add(5, 2));
    }
}
