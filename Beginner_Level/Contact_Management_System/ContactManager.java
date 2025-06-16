import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("--------------------------");
    }
}

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addContact(); break;
                case 2: viewContacts(); break;
                case 3: updateContact(); break;
                case 4: deleteContact(); break;
                case 5: System.out.println("Exiting program."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\n--- Contact List ---");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("Contact #" + (i + 1));
                contacts.get(i).display();
            }
        }
    }

    static void updateContact() {
        viewContacts();
        System.out.print("Enter contact number to update: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contacts.size()) {
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter new Email: ");
            String email = sc.nextLine();

            contacts.set(index, new Contact(name, phone, email));
            System.out.println("Contact updated!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    static void deleteContact() {
        viewContacts();
        System.out.print("Enter contact number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted!");
        } else {
            System.out.println("Invalid contact number.");
        }
    }
}
