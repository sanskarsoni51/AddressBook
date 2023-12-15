package BridgelabzAddressBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static BridgelabzAddressBook.MultipleAddressBooks.AddressBookByName;

public class CRUD {

    // creating a list to store the contact details of a person
    private static ArrayList<Contacts> Contactlist = new ArrayList<>();

/*     addContactsFromUserInput To take a user input for contacts.
     @DESC :-Created a void function which helps us in taking input details from the user.*/
    public void addContactsFromUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        System.out.println("Enter Address:");
        String address = scanner.nextLine();

        System.out.println("Enter City:");
        String city = scanner.nextLine();

        System.out.println("Enter State:");
        String state = scanner.nextLine();

        System.out.println("Enter Email Id:");
        String email = scanner.nextLine();

        System.out.println("Enter Zip:");
        int zipcode = scanner.nextInt();

        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();

        //  now pushing all the data into the list we made
        Contacts newContact = new Contacts(firstName, lastName, address, city, state, zipcode, phoneNumber, email);
        addContacts(newContact);
    }

    //@DESC: addContacts method to add the items in the arraylist.
    private void addContacts(Contacts contacts) {
        if(Contactlist.stream().anyMatch(contacts1 -> (contacts1.getFirstName().equals(contacts.getFirstName()) && contacts1.getLastName().equals(contacts.getLastName()))))
            System.out.println("Cannot add same person in the book");
        else
            Contactlist.add(contacts);
    }

/*    @DESC: it is a void function which is created to modify the contact details
    @PARAMS: first name and last name are taken as params
    @RETURN: it does not return anything. it just updates the details   */
    public static void modifyContactByName(String firstName, String lastName,List<Contacts> list) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int option;
        for (Contacts contact : list) {
            //It will check for valid firstname and lastname
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                System.out.println("1.Edit first name\n2.Edit last name\n"
                        + "3.Edit Address\n4.Edit City\n5.Edit State\n6.Edit Zip\n7.Edit Phone no\n8.Edit email\n 9.Exit");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter first name to edit");
                        String FirstName = scanner.nextLine();
                        contact.setFirstName(FirstName);
                        break;
                    case 2:
                        System.out.println("Enter last name to edit");
                        String LastName = scanner.nextLine();
                        contact.setLastName(LastName);
                        break;
                    case 3:
                        System.out.println("Enter address to edit");
                        String address = scanner.nextLine();
                        contact.setAddress(address);
                        break;
                    case 4:
                        System.out.println("Enter city to edit");
                        String city = scanner.nextLine();
                        contact.setCity(city);
                        break;

                    case 5:
                        System.out.println("Enter state to update");
                        String state = scanner.nextLine();
                        contact.setState(state);
                        break;

                    case 6:
                        System.out.println("Enter zip code");
                        int zip = scanner.nextInt();
                        contact.setZipcode(zip);
                        break;

                    case 7:
                        System.out.println("Enter phone no to edit");
                        String phone = scanner.nextLine();
                        contact.setPhoneNumber(phone);
                        break;

                    case 8:
                        System.out.println("Enter email to edit");
                        String email = scanner.nextLine();
                        contact.setEmail(email);
                        break;
                    case 9:
                        break;

                    default:
                        System.out.println("Please provide correct option");
                        break;
                }

                System.out.println("Contact modified successfully.");
                showContacts();
                break;

            } else {
                System.out.println("Contact not found.");
            }
        }

    }

/*  @DESC: removeContacts() is used to remove from list.
    @PARAMS: it takes first name as the parameter to identify the person
    @return: does not return anything*/
    public void removeContacts(String firstName1) {
        Iterator<Contacts> iterator = Contactlist.iterator();
        while (iterator.hasNext()) {
            Contacts contact = iterator.next();
            if (contact.getFirstName().equals(firstName1)) {
                System.out.println("Contact deleted successfully");
                iterator.remove();
            } else {
                System.out.println("Contact not found");
            }
        }
    }

    //@DESC: showContacts method is used to display
    public static void showContacts() {
        for (Contacts contacts : Contactlist) {
            System.out.println(contacts.getFirstName() + " " + contacts.getLastName() + " " + contacts.getAddress() + " " + contacts.getCity() + " " + contacts.getState() + " " + contacts.getZipcode() + " " + contacts.getPhoneNumber() + " " + contacts.getEmail());

        }
    }

    public static void setContactList(String AddressBookName) {
        Scanner s = new Scanner(System.in);

        //    We are creating an object of the AddressBook class
        AddressBook s1 = new AddressBook();
//        Contactlist.clear();
        boolean b = true;
        int option;


        /* we are starting a while loop. it will continue till we do not want our book to end and
           will provide option everytime using switch case so that we can do different things  */
        while (b) {
            System.out.println("1.Add a Contact\n2.Edit a Contact\n"
                    + "3.delete a contact\n 4.Exit");
            option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println("enter the details in the address book");
                    //Called a method addContactsFromUserInput
                    s1.addContactsFromUserInput();
                    //called a method showContacts
//                    s1.showContacts();
                    break;

                case 2:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter First Name to Search");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter Last Name To Search:");

                    String lastName = scanner.nextLine();
                    //called a method modifyContacts
                    s1.modifyContactByName(firstName, lastName,Contactlist);
                    break;

                case 3:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter First Name to delete the contact");
                    String firstName1 = sc.nextLine();
                    //called a removeContacts with firstName
                    s1.removeContacts(firstName1);

                    //Displayed a contacts
                    s1.showContacts();
                    break;

                case 4:
                    b = false;
                    break;

                default:
                    System.out.println("Please provide correct option");
                    b = false;
                    break;
            }
        }
//        s1.setList(Contactlist);
//        s1 = new AddressBook(Contactlist);
//        Adding address book to the map(with each book having unique name)
        AddressBookByName.put(AddressBookName,Contactlist);
//        Printing address book by name
        MultipleAddressBooks.ShowAddressBookByName(AddressBookName);
        System.out.println("Out of Address book");
//        Contactlist.clear();
    }
}
