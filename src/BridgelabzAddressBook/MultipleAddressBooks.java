package BridgelabzAddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultipleAddressBooks {
/*    Using map to store multiple address books with name(unique) as the key*/
    static HashMap<String, ArrayList<Contacts>> AddressBookByName = new HashMap<>();

    /* It is a function which is used to print the Address book from the map */
    public static void ShowAddressBookByName(String Name) {

            List<Contacts> l1 = AddressBookByName.get(Name);
        System.out.println(l1.size());
            for (Contacts contacts: l1 ) {
                System.out.println(contacts.getFirstName() + " " + contacts.getLastName() + " " + contacts.getAddress()
                        + " " + contacts.getCity() + " " + contacts.getState() + " " + contacts.getZipcode() + " "
                        + contacts.getPhoneNumber() + " " + contacts.getEmail());
            }
    }


}
