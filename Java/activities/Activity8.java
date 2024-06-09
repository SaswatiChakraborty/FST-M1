package src.activities;

class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {
    public static void exceptionTest(String input) throws CustomException {
        if(input == null)
            throw new CustomException("String is null");
        else
            System.out.println(input);

    }
    public static void main(String[] args) {
        try {
            exceptionTest("Will print to console");
            exceptionTest(null);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
