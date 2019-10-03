package contactsManager;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    private Scanner input = new Scanner(System.in);

    public String getString() {
        return input.nextLine().trim().toLowerCase();
    }

    public int getInt() {
        int number;
        try {
            number = Integer.parseInt(getString());
        } catch (NumberFormatException e) {
            System.out.println("Must enter a number input");
            return getInt();
        }
        return number;
    }

    public int getInt(int min, int max) {
        int num = getInt();
        if (num < min || num > max) {
            System.out.println("Outside of boundaries");
            return getInt(min, max);
        }
        return num;
    }

    public static void main(String[] args) {
        Input input = new Input();
        input.getInt(1, 5);
    }
}
