
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ContactTests {

	@Test
	void Sucessful_ContactTest() {
		// Expected To Pass Testing.
		Contact NewContact = new Contact("MB567", "Mike", "Brooks", "1234567890", "69 Goblin Lane");
		assertTrue(NewContact.getContactID().equals("MB567"));
		assertTrue(NewContact.getFirstName().equals("Mike"));
		assertTrue(NewContact.getLastName().equals("Brooks"));
		assertTrue(NewContact.getPhoneNumber().equals("1234567890"));
		assertTrue(NewContact.getAddress().equals("69 Goblin Lane"));
	}

	@Test
	void ContactTest_NoEmptyStrings() {
		// Expected To Fail Tests because the strings are empty
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Unique ID Empty
					new Contact("", "Mike", "Brooks", "1234567890", "69 Goblin Lane");
				});
					
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// First Name Test
				new Contact("MB567", "", "Brooks", "1234567890", "69 Goblin Lane");
				});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Last Name Test
				new Contact("MB567", "Mike", "", "1234567890", "69 Goblin Lane");
				});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Phone Number Test
				new Contact("MB567", "Mike", "Brooks", "", "69 Goblin Lane");
				});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Address Test
				new Contact("MB567", "Mike", "Brooks", "1234567890", "");
				});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Multiple empty string Test
				new Contact("", "Mike", "Brooks", "1234567890", "");
				});
		}
	
	@Test 
	void Contact_TestNull() {
		// Expected To Fail Tests when assigning null to Contact. 
		Assertions.assertThrows(NullPointerException.class, () -> {
		/// Unique ID null
				new Contact(null, "Mike", "Brooks", "1234567890", "69 Goblin Lane");
				});
			
		Assertions.assertThrows(NullPointerException.class, () -> {
			/// First Name null
					new Contact("MB567", null, "Brooks", "1234567890", "69 Goblin Lane");
					});
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			/// Last Name null
					new Contact("MB567", "Mike", null, "1234567890", "69 Goblin Lane");
					});
		Assertions.assertThrows(NullPointerException.class, () -> {
			/// Phone Number null
					new Contact("MB567", "Mike", "Brooks", null, "69 Goblin Lane");
					});
		Assertions.assertThrows(NullPointerException.class, () -> {
			/// Address null
					new Contact("MB567", "Mike", "Brooks", "1234567890", null);
					});
		Assertions.assertThrows(NullPointerException.class, () -> {
			/// multiple nulls
					new Contact(null, "Mike", "Brooks", "1234567890", null);
					});
		}

	@Test
	void ContactTest_StringsTooLong() {
		// Expected To Fail Tests when assigning null to Contact. 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		/// Unique ID Toolong
				new Contact("MB01010101010101010", "Mike", "Brooks", "1234567890", "69 Goblin Lane");
				});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// First Name too long
					new Contact("MB567", "GeorgianBullDog", "Brooks", "1234567890", "69 Goblin Lane");
					});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Last Name too long
					new Contact("MB567", "Mike", "FrenchTerrirWinner", "1234567890", "69 Goblin Lane");
					});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Phone Number too long
					new Contact("MB567", "Mike", "Brooks", "010100101010100001", "69 Goblin Lane");
					});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// Address too long
					new Contact("MB567", "Mike", "Brooks", "1234567890", "65423 Sillylandia Freedom Fighters Never give up they fight until the end of time");
					});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			/// multiple too long
					new Contact("MB010101110101011", "Mike", "Brooks", "0101010101011234567890", "69 Goblin Lane" );
					});
		}
}
