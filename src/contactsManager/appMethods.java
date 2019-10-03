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

public class appMethods extends Input {

    private static Scanner input = new Scanner(System.in);

    /// this method displays the options to the user
    public static void showMenu() {
        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option:");
    }

    public static boolean menuOptions(int userChoice) {
        boolean output = true;

        switch (userChoice) {
            case 1:
                readContacts();
                input.nextLine();
                break;
            case 2:
                addContacts();
                input.nextLine();
                break;
            case 3:
                searchContacts();
                input.nextLine();
                break;
            case 4:
                deleteContacts();
                break;
            case 5:
                System.out.println("Exiting now");
                output = false;
                break;
        }
        return output;
    }

    public static void readContacts() {
        Path contactsPath = Paths.get("data", "contacts.txt");
        List<String> contactList = new ArrayList<>();
        try {
            contactList = Files.readAllLines(contactsPath);
            System.out.println("Name\t\t\t| Phone Number |");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < contactList.size(); i += 1) {
                System.out.println(contactList.get(i));
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void addContacts() {
        System.out.println("Enter the new contact's full name: ");
        String name = input.nextLine();
        System.out.println("Enter the new contact's phone number: ");
        String number = input.nextLine();
        String contact = name + "\t| " + number + "\t| ";
        try {
            Files.write(
                    Paths.get("data", "contacts.txt"),
                    Arrays.asList(contact),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("New contact has been added!");
    }

    public static void deleteContacts() {
        System.out.println("Enter the name of the contact you would like to delete");
        String delete = input.nextLine().trim().toLowerCase();
        try {
            List<String> lines = Files.readAllLines(Paths.get("data", "contacts.txt"));
            List<String> newList = new ArrayList<>();
            for (String line : lines) {
                if (!line.toLowerCase().contains(delete)) {
                    newList.add(line);
                }
            }
            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Contact has been deleted!");
        input.nextLine();
    }

    public static void searchContacts() {
        System.out.println("Enter the name of the contact you would like to search");
        String search = input.nextLine().trim().toLowerCase();
        System.out.println("Displaying " + search + "'s contact information");
        try {
            List<String> lines = Files.readAllLines(Paths.get("data", "contacts.txt"));
            List<String> newList = new ArrayList<>();
            for (String line : lines) {
                if (line.contains(search)) {
                    System.out.println(line);
                    continue;
                }
                newList.add(line); //* Appends the specified element to the end of this list (optional operation).
            }
            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
