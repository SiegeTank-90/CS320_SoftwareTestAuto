import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	//Expected Successful Tests
	@Test
	void ContactServiceTest() {
	// populate with junk data
	ArrayList<Contact> Contacts = new ArrayList<Contact>();
	ContactService ContactsService = new ContactService(Contacts);
	//Test Add Contact
	ContactsService.AddContact("Mike", "Brooks", "1234567890", "69 Goblin Lane");
	ContactsService.AddContact("Robin", "Boutaud", "1234567890", "70 Goblin Lane");
	ContactsService.AddContact("Tony", "Hoang", "1234567890", "71 Goblin Lane");
	ContactsService.AddContact("CJ", "Cline", "1234567890", "72 Goblin Lane");
	ContactsService.AddContact("Charles", "Classmate", "1234567890", "70 Goblin Lane");
	ContactsService.AddContact("Cody", "Coolguy", "1234567890", "69 Goblin Lane");
	

	
	// Testing Access to Contacts
	assertTrue(ContactsService.GetContactbyID("MB0").getFirstName().equals("Mike"));
	assertTrue(ContactsService.GetContactbyID("MB0").getLastName().equals("Brooks"));
	assertTrue(ContactsService.GetContactbyID("CC0").getFirstName().equals("CJ"));
	assertTrue(ContactsService.GetContactbyID("CC1").getFirstName().equals("Charles"));
	assertTrue(ContactsService.GetContactbyID("CC2").getFirstName().equals("Cody"));
	
	// Testing Delete Contacts
	ContactsService.DeleteContactbyID("CC0");
	// When searching for a contact not in the contacts, returns a junk missing Contact
	// If Missing contact = 0 it is not int he contacts.
	assertTrue(ContactsService.GetContactbyID("CC0").getContactID().equals("0"));
	
	//Testing updating feature by field
	// Validate True Before Changes
	assertTrue(ContactsService.GetContactbyID("CC1").getFirstName().equals("Charles"));
	assertTrue(ContactsService.GetContactbyID("CC1").getLastName().equals("Classmate"));
	assertTrue(ContactsService.GetContactbyID("CC1").getPhoneNumber().equals("1234567890"));
	assertTrue(ContactsService.GetContactbyID("CC1").getAddress().equals("70 Goblin Lane"));
	
	// Make Changes
	ContactsService.UpdateContactbyID("CC1", "FirstName", "CJ");
	ContactsService.UpdateContactbyID("CC1", "LastName", "Cline");
	ContactsService.UpdateContactbyID("CC1", "PhoneNumber", "5555555555");
	ContactsService.UpdateContactbyID("CC1", "Address", "123 Baker Street");
	
	// Validate True After Changes
	assertTrue(ContactsService.GetContactbyID("CC1").getFirstName().equals("CJ"));
	assertTrue(ContactsService.GetContactbyID("CC1").getLastName().equals("Cline"));
	assertTrue(ContactsService.GetContactbyID("CC1").getPhoneNumber().equals("5555555555"));
	assertTrue(ContactsService.GetContactbyID("CC1").getAddress().equals("123 Baker Street"));
	
	// Clear Test Data for Next Round of Tests.
	Contacts.clear();
	
	}

		
}
