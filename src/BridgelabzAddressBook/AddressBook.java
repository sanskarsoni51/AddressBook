package BridgelabzAddressBook;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class AddressBook {


    private List<Contacts> Contactlist =new ArrayList<>();

    // addContactsFromUserInput To take a user input for contacts.

//    Created a void function which helps us in taking input details from the user.
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

//        now pushing all the data into the list we made
        Contacts newContact = new Contacts(firstName, lastName, address, city, state, zipcode, phoneNumber, email);
        addContacts(newContact);
    }
    // addContacts method to add the items in the arraylist.
    private void addContacts(Contacts contacts) {
        Contactlist.add(contacts);
    }

//    it is a void function which is created to modify the
    public void modifyContactByName(String firstName, String lastName) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int option;
        for (Contacts contact : Contactlist) {
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
                        int zip = sc.nextInt();
                        contact.setZipcode(zip);
                        break;

                    case 7:
                        System.out.println("Enter phone no to edit");
                        String phone = sc.nextLine();
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

            }
            else
            {
                System.out.println("Contact not found.");
            }
        }

    }

    //showContacts method is used to display
    private void showContacts()
    {
        for(Contacts contacts : Contactlist)
        {
            System.out.println(contacts.getFirstName()+ " "+contacts.getLastName()+" "+contacts.getAddress()+" "+contacts.getCity()+" "+contacts.getState()+" "+contacts.getZipcode()+" "+contacts.getPhoneNumber()+" "+contacts.getEmail());

        }
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to Address Book Java Functionality ");

        System.out.println("we have added a class where we created the details ");
        System.out.println("enter the details in the address book");

        AddressBook s1 = new AddressBook();
        //Called a method addContactsFromUserInput
        s1.addContactsFromUserInput();
        //called a method showContacts
        s1.showContacts();

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter First Name to Search");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name To Search:");

        String lastName = scanner.nextLine();

        s1.modifyContactByName(firstName, lastName);
    }
}
