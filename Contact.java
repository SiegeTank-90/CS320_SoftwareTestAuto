
public class Contact {

	/*
	 * Methods Table of Contents // Get Methods public String getContactID() public
	 * String getFirstName(); public String getLastName(); public String
	 * getPhoneNumber(); public String getAddress(); //update Methods public void
	 * UpdateFirstName(String New_FName); public void UpdateLastName(String
	 * New_Lname); public void updateNumber(String New_PhoneNum); public void
	 * updateAddress(String New_Address); // Print Methods public void
	 * PrintContact(); // Validation Methods private String Validate(String
	 * Subject_String, String Options);
	 */

	// Declarations
	// initialize
	final private String Contact_ID;
	private String First_Name;
	private String Last_Name;
	private String Phone_Num;
	private String Address;

	// Constructor
	public Contact(String Contact_ID, String First_Name, String Last_Name, String Phone_Num, String Address) {
		Validate(Contact_ID, "ContactID");
		Validate(First_Name, "FirstName");
		Validate(Last_Name, "LastName");
		Validate(Phone_Num, "PhoneNumber");
		Validate(Address, "Address");

		this.Contact_ID = Contact_ID;
		this.First_Name = First_Name;
		this.Last_Name = Last_Name;
		this.Phone_Num = Phone_Num;
		this.Address = Address;

	}

	// Recieves a string to be tests, uses options select test paramaters and thows
	// matching errors and returns true if passed.
	protected Boolean Validate(String Subject_String, String Options) throws IllegalArgumentException, NullPointerException {
		switch (Options) {

		case "ContactID":
			if (Subject_String == "" || Subject_String.length() > 10 ) {
				throw new IllegalArgumentException("Invalid Contact ID");
			}
			break;
		case "FirstName":
			if (Subject_String == "" || Subject_String.length() > 10 ) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			break;
		case "LastName":
			if ( Subject_String == "" || Subject_String.length() > 10 ) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			break;
		case "PhoneNumber":
			if (Subject_String == "" || Subject_String.length() > 10 ) {
				throw new IllegalArgumentException("Invalid Phone Number");
			}
			break;
		case "Address":
			if ( Subject_String == "" || Subject_String.length() > 30) {
				throw new IllegalArgumentException("Invalid Address");
			}
			break;
		}

		return true;
	}

	// Gets Contact ID
	public String getContactID() {
		return this.Contact_ID;
	}

	// Gets First Name
	public String getFirstName() {
		return this.First_Name;
	}

	// Gets Last Name
	public String getLastName() {
		return this.Last_Name;
	}

	// Gets Phone Number
	public String getPhoneNumber() {
		return this.Phone_Num;
	}

	// Gets Address
	public String getAddress() {
		return this.Address;
	}

	// Update Methods
	// Updates First Name
	public void UpdateFirstName(String New_FName) {
		Validate(New_FName, "FirstName");
		this.First_Name = New_FName;
	}

	// Updates LastName
	public void UpdateLastName(String New_LName) {
		Validate(New_LName, "LastName");
		this.Last_Name = New_LName;
	}

	// Update Phone Number
	public void UpdateNumber(String New_PhoneNum) {
		Validate(New_PhoneNum, "PhoneNumber");
		this.Phone_Num = New_PhoneNum;
	}

	// Update Address
	public void UpdateAddress(String New_Address) {
		Validate(New_Address, "Address");
		this.Address = New_Address;

	}

}