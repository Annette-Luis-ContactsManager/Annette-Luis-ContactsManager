package contactsManager;


import java.util.Scanner;

//3. Create an input validation class
//
//Create a package inside of src named util. Inside of util, create a class named Input that has a private property named scanner.
// When an instance of this object is created, the scanner property should be set to a new instance of the Scanner class.
// The class should have the following methods, all of which return command line input from the user:
//
//String getString() (my note: line 28)
//boolean yesNo() (my note: line 41)
//int getInt(int min, int max) (my note: line 70)
//int getInt() (my note: line 57)
//double getDouble(double min, double max)
//double getDouble()
//The yesNo method should return true if the user enters y, yes, or variants thereof, and false otherwise.
//
//The getInt(int min, int max) method should keep prompting the user for input until they give
// an integer within the min and max. The getDouble method should do the same thing, but with decimal numbers.
//
//Create another class named InputTest that has a static main method that uses all of the methods from the Input class.
public class Input {

    private Scanner input = new Scanner(System.in);

    //////////////////////////////////////////////////////////
    /// version 1. this method can be called without an argument and "Write something: " would print
    public String getString() {
        return getString(""); //When getString() is SOUT'd, it will return a prompt that says "write something" in which the user will input a string
    }


    // version 2. this method allows the programmer to input a unique message as a paramter
    public String getString(String msg) {
        System.out.println(msg);
        return input.nextLine().trim().toLowerCase();
    }

    /////////////////////////////////////////////////////////

    public boolean yesNo() {

        String userInput = getString("Type yes/no: "); //refers to the first getString method of this class

        if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y")) {
            return true;
        }
        return false;

    }

    //////////////////////////////////////////////////////////


    //part1
    public int getInt() {
        int number;
        try {
            number = Integer.valueOf(getString(" ")); // converts the string input from getString() to an integer
        } catch (NumberFormatException e) {
            e.printStackTrace(); //allows you to see where the errors occurred
            return getInt(); //recursion
        }
        return number;
    }

    //part 2
    public int getInt(int min, int max) {
        int num = getInt(); //uses the number passed in  the getInt() variable and once it's validated, the number is then evaluated to see if it's within range

        if (num < min || num > max) {
            System.out.println("Error: outside of the boundaries.");
            return getInt(min, max);
        }

        return num;
    }

    //////////////////////////////////////////////////////////

    //part 1

    public double getDouble(double min, double max) {
        double num = getDouble(); //calling the input from the getDouble() function

        if (num < min || num > max) {
            System.out.println("Error: outside of the boundaries.");
            return getDouble(min, max);
        }

        return num;
    }

    //Part 2

    public double getDouble() {
        double number;
        try {
            number = Double.valueOf(getString("Give me a number: ")); // converts the string input from getString() to an integer
        } catch (NumberFormatException e) {
            System.out.println("That's not a number. ಠ_ಠ");
            e.printStackTrace();
            return getDouble();
        }
        return number;
    }


    ///**** our methods catch a NumberFormatException which is an Exception that might be thrown when you try to convert a
    // String into a number, where that number might be an int, a float, or any other Java numeric type.
    //I am using it in this try-catch method so the ensuing message can be SOUTed to the user and the method can be run
    //again.


    //The java string valueOf() method converts different types of values into string.
    // By the help of string valueOf() method,
    // you can convert int to string, long to string, boolean to string, character to string,
    // float to string, double to string,
    // object to string and char array to string.

    //Using printStackTrace() is a good idea since you're dumping out where the exception
    // took place. This is often invaluable for tracking errors that are unexpected since it'll
    // give you a direct (if verbose) pointer to where exactly you ran into an error
    //**source: stackoverflow


    //bonus1
    //method to convert binary to standard
    public int getBinary() {
        int aNumber;
        try {
            aNumber = Integer.valueOf(getString("Enter a number: "), 2);
        } catch (NumberFormatException e) {
            System.out.println("That's not a number.");
            e.printStackTrace();
            return getBinary();
        }
        return aNumber;

    }


    //bonus 2
    //method to convert standard to binary

    public static String getStandard() {
        System.out.println("enter a number : ");
        Scanner input = new Scanner(System.in);
        int aNumber = input.nextInt();
        try {
            System.out.println(Integer.toBinaryString(aNumber));

        } catch (NumberFormatException e) {
            System.out.println("That's not a number.");
            e.printStackTrace();
            return getStandard();
        }
        return "All done";

    }
}
