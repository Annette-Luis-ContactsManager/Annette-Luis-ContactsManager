package contactsManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class appMethods {

    public static void main(String [] args){

        Input input = new Input();

        int userInput;
        boolean willContinue;
        do {
            showMenu();
            userInput = input.getInt(1, 5);
            willContinue = menuOptions(userInput);

        } while(willContinue);


    }

    private Scanner scanner;

    public  void appMethods(){
        this.scanner = new Scanner(System.in);

    }


    /// this method displays the options to the user

    public static void showMenu()
        {

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        }






    public static boolean menuOptions(int userChoice) {

        boolean output = true;

        switch (userChoice) {
            case 1:
                System.out.println("option 1");

                break;
            case 2:
                System.out.println("option 2");
                break;
            case 3:
                System.out.println("option 3");
                break;
            case 4:
                System.out.println("option 4");
                break;
            case 5:
                System.out.println("See Ya!");
                output = false; //breaks you out of the loop
                break;
        }

        return output;

    }






}
