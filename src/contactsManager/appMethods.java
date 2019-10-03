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
                "Enter an option (1, 2, 3, 4 or 5):");
    }

    public static boolean menuOptions(int userChoice) {
        boolean output = true;

        switch (userChoice) {
            case 1:
                readContacts();
                break;
            case 2:
                addContacts();
                break;
            case 3:
                System.out.println("Enter the name of the contact you would like to search");
                String search = input.nextLine().trim().toLowerCase();
                searchContacts(search,"data", "contacts.txt");
                break;
            case 4:
                System.out.println("Enter the name of the contact you would like to delete");
                String delete = input.nextLine().trim().toLowerCase();
                deleteContacts(delete, "data", "contacts.txt");
                break;
            case 5:
                System.out.println("Exit");
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
            for (int i = 0; i < contactList.size(); i += 1) {
                System.out.println(contactList.get(i));
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void addContacts() {
        System.out.println("Enter the new contact's first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter the new contact's last name: ");
        String lastName = input.nextLine();
        String fullName = firstName + " " + lastName;
        System.out.println("Enter your Phone Number: ");
        String num = input.nextLine();
        String contact = fullName + "\t| " + num + "\t| ";
        try {
            Files.write(
                    Paths.get("data", "contacts.txt"),
                     Arrays.asList(contact),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteContacts(String contact, String directory, String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(directory, filename));
            List<String> newList = new ArrayList<>();
            for (String line : lines) {
                if (line.contains(contact)) {
                    continue;
                }
                newList.add(line);
            }
            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchContacts(String contact, String directory, String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(directory, filename));
            List<String> newList = new ArrayList<>();
            for (String line : lines) {
                if (line.contains(contact)) {
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
