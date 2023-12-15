package BridgelabzAddressBook;

import java.util.List;
import java.util.Scanner;

import static BridgelabzAddressBook.MultipleAddressBooks.AddressBookByName;
import static BridgelabzAddressBook.MultipleAddressBooks.SearchByCity;

public class AddressBook extends CRUD {

    //    @DESC : main method
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Java Functionality ");
        Scanner s = new Scanner(System.in);

        System.out.println("we have added a class where we created the details ");

//        MultipleAddressBooks AddressBooks = new MultipleAddressBooks();

         /* we are starting a while loop. it will continue till we do not want our book to end and
           will provide option everytime using switch case so that we can do different things  */
        boolean loop = true;
        while (loop) {
            System.out.println("1.Add a Address Book\n2.View a Address Book\n3.Edit a Address Book\n"
                    + "4.delete a Address Book\n5.Search Contacts by City \n6.Exit");
            int option1 = s.nextInt();

            switch (option1) {
                case 1:
                    System.out.println("Enter the name of the Address Book");
                    String AddressBookName = s.next();
                    /* Checking for the unique name of address book */
                    if (AddressBookByName.containsKey(AddressBookName)) {
                        System.out.println("Enter a unique name for Address book");
                        break;
                    }
                    setContactList(AddressBookName);
                    break;

                case 2:
                    System.out.println("Enter Name to Search");
                    String Show = s.next();
                    MultipleAddressBooks.ShowAddressBookByName(Show);
                    break;

                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Name to Search");
                    String Name = scanner.nextLine();
                    List<Contacts> book = AddressBookByName.get(Name);
                    MultipleAddressBooks.ShowAddressBookByName(Name);

                    System.out.println("Enter First Name of contact to Modify:");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter Last Name of contact to Modify:");
                    String lastName = scanner.nextLine();
                    modifyContactByName(firstName, lastName,book);
                    break;

                case 4:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Name to Search");
                    Name = sc.nextLine();
                    AddressBookByName.remove(Name);
                    break;

                case 5:
                    Scanner c = new Scanner(System.in);
                    System.out.println("Enter City to Search");
                    Name = c.nextLine();
                    List<Contacts> l1 = SearchByCity(Name);
                    for (Contacts contacts: l1 ) {
                        System.out.println(contacts.getFirstName() + " " + contacts.getLastName() + " " + contacts.getAddress()
                                + " " + contacts.getCity() + " " + contacts.getState() + " " + contacts.getZipcode() + " "
                                + contacts.getPhoneNumber() + " " + contacts.getEmail());
                    }
                    break;

                case 6:
                    loop = false;
                    break;

                default:
                    System.out.println("Please provide correct option");
                    loop = false;
                    break;
            }
        }
    }
}
