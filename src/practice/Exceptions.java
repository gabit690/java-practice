package practice;

import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String username = input.nextLine();

        try {

            showGreeting(username);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public static void showGreeting(String username) throws EmptyStringException {

        if(username.length() == 0) {

            throw new EmptyStringException("Name mustn't be empty");
        }

        System.out.println("Hello ".concat(username));
    }
}

class EmptyStringException extends Exception {

    public EmptyStringException() {};

    public EmptyStringException(String message) {

        super(message);
    }
}