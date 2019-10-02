package contactsManager;

import java.util.Scanner;

public class contactManagerTest {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Input input = new Input();

        int userInput;
        boolean willContinue;
        do {
            appMethods.showMenu();
            userInput = input.getInt(1, 5);
            willContinue = appMethods.menuOptions(userInput);
        } while (willContinue);
    }
}
