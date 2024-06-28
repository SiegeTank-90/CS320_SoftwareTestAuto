import java.util.ArrayList;



public class ContactService {

	// Initialize Variables & Empty Contact
	private ArrayList<Contact> Contacts;
	private int UIDcurrent;
	private Contact MissingContact;
	// Constructor
	public ContactService(ArrayList<Contact> Contacts) {
		this.Contacts = Contacts;
		UIDcurrent = 0;
		MissingContact = new Contact("0", "0", "0", "1234567890", "0");

	}

	// TODO : Faster Database needed.

	// Finds Contacts in ArrayList, helper method, returns MissingContact or Contact
	public Contact GetContactbyID(String UID) throws NullPointerException {

		for ( int i = 0; i < Contacts.size(); i++  ) {

			if (Contacts.get(i).getContactID().equals(UID)) {
				return Contacts.get(i);
			}

		}
		// creating an empty contact to return false values
		return MissingContact;
	}
	
	// Adds Contacts to Database
	public void AddContact(String FName, String LName, String PhoneNum, String Address ) {
		
		//Search & Generate UniqueID
		String newUID =  String.valueOf(FName.charAt(0)) + String.valueOf(LName.charAt(0)) + String.valueOf(UIDcurrent);
		
		while (GetContactbyID(newUID).getContactID().equals(newUID)) {
			UIDcurrent = UIDcurrent+1;
			newUID =  String.valueOf(FName.charAt(0)) + String.valueOf(LName.charAt(0)) + String.valueOf(UIDcurrent);
		}

		//add UniqueID to Contacts 
		try {
			Contact NewContact = new Contact( newUID, FName, LName, PhoneNum, Address);
			Contacts.add(NewContact);
			UIDcurrent = 0;
			return;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	// Delete Contact by Unique ID
	public void DeleteContactbyID(String UID) {

		// verify if Contact exists if it doesn't exit. 
		if ( GetContactbyID(UID) == MissingContact) {
			System.out.println("Contact Not Found");
			return;
		} else {
			// Find location of contact in arrayList and then delete it. 
			for ( int i = 0; i < Contacts.size(); i++  ) {
				if (Contacts.get(i).getContactID().equals(UID)) {
					Contacts.remove(i);
				}
			}
		}
		
	}
	
	// Updates Contact information using field parameters and a string. 
	public void UpdateContactbyID(String UID, String FieldTitle, String UpdatedField ) throws IllegalArgumentException {
		if (GetContactbyID(UID) ==  MissingContact) {
			System.out.println("Contact Not Found");
			return;
		}
		switch (FieldTitle) {
		
		case "FirstName":
			try {
				GetContactbyID(UID).UpdateFirstName(UpdatedField);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "LastName":
			try {
				GetContactbyID(UID).UpdateLastName(UpdatedField);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "PhoneNumber":
			try {
				GetContactbyID(UID).UpdateNumber(UpdatedField);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		case "Address":
			try {
				GetContactbyID(UID).UpdateAddress(UpdatedField);
				
			} catch (Exception e) {
				System.out.println(e);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid Field");

		}
	}

}