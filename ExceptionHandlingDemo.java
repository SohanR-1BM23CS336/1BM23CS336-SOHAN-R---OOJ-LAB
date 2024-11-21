import java.util.Scanner;

class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class Father {
    int fatherAge;

    public Father(int fatherAge) throws WrongAgeException {
        if (fatherAge < 0) {
            throw new WrongAgeException("Father's age cannot be negative.");
        }
        this.fatherAge = fatherAge;
    }
}

class Son extends Father {
    int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge);
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative.");
        }
        this.sonAge = sonAge;
    }
}

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Father's age: ");
            int fatherAge = scanner.nextInt();

            Father father = new Father(fatherAge);
            System.out.println("Father created with age: " + father.fatherAge);

            System.out.print("Enter Son's age: ");
            int sonAge = scanner.nextInt();

            Son son = new Son(fatherAge, sonAge);
            System.out.println("Son created with age: " + son.sonAge);
        } catch (WrongAgeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid integers for ages.");
        }
        scanner.close();
    }
}
