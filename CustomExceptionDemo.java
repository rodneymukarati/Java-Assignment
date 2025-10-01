class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Main class
public class CustomExceptionDemo {
    public static void main(String[] args) {
        try {
            validateAge(-5); // This will throw an exception
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            validateAge(10); // This will not throw an exception
        } catch (InvalidAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

    // Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative: " + age);
        } else {
            System.out.println("Valid age: " + age);
        }
    }
}
