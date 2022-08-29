package cdot.nccs.homepage.dto;

import java.util.List;

public class ContactListDtoWrap {
    List<ContactListDto> contacts;

    public ContactListDtoWrap(List<ContactListDto> contacts) {
        this.contacts = contacts;
    }

    public ContactListDtoWrap() {
    }

    public void addContact(ContactListDto contact){
        this.contacts.add(contact);
    }

    public List<ContactListDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactListDto> contacts) {
        this.contacts = contacts;
    }
}
