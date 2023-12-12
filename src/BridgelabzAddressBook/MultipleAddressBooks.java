package BridgelabzAddressBook;

import java.util.HashMap;
import java.util.Map;

import static BridgelabzAddressBook.CRUD.showContacts;

public class MultipleAddressBooks {
/*    Using map to store multiple address books with name(unique) as the key*/
    static Map<String, AddressBook> AddressBookByName = new HashMap<>();

    /* It is a function which is used to print the Address book from the map */
    public static void ShowAddressBookByName(String Name) {

        for (String key : AddressBookByName.keySet()) {
            AddressBook book = AddressBookByName.get(Name);
            book.showContacts();
        }
    }


}
