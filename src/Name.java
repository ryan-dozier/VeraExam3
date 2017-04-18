import javax.swing.JOptionPane;

/* Name Class
 * This class will allow for the creation of Name objects.
 */
public class Name {
	//	Fields
	private String firstName;
	private char middleInitial;
	private String lastName;
	private String suffix = null;

	//	Behaviors
	//	No arg Constructor
	public Name() {

	}

	//	All field Constructor
	public Name(String firstName, char middleInitial, String lastName, String suffix) {
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
		setSuffix(suffix);
	}

	//	returns the firstName of the current Name
	public String getFirstName() {
		return firstName;
	}

	//	sets the firstName of the current Name
	public void setFirstName(String firstName) {
		firstName.toUpperCase().charAt(0);
		this.firstName = firstName;
	}

	//	returns the middleInitial of the current Name
	public char getMiddleInitial() {
		return middleInitial;
	}

	//	sets the middleInitial of the current Name
	public void setMiddleInitial(char middleInitial) {

		if (middleInitial != ' ')
			while (!(Character.isAlphabetic(middleInitial))) {
				middleInitial = JOptionPane.showInputDialog(
						"Invalid Middle Initial Detected" + "\nEnter a Middle Initial", "Enter a Letter").charAt(0);
			}

		this.middleInitial = middleInitial;
	}

	//	returns the lastName of the current Name
	public String getLastName() {
		return lastName;
	}

	//	sets the lastName of the current Name
	public void setLastName(String lastName) {
		lastName.toUpperCase().charAt(0);
		this.lastName = lastName;
	}

	//	returns the suffix of the current Name
	public String getSuffix() {
		return suffix;
	}

	//	sets the suffix of the current Name
	public void setSuffix(String suffix) {
		if (suffix.toUpperCase().equals("NONE"))
			suffix = "NONE";
		suffix.toUpperCase().charAt(0);
		this.suffix = suffix;
	}

	/* Method		 :  public static Name createName()
	 * Data Required : 	none
	 * Data Returned :	a type Name variable
	 * Purpose		 :	To create, new Name objects using the user's input
	 * Description	 :	This method prompts the user to fill the fields of a Name
	 */
	public static Name createName() {
		String firstName;
		String middle;
		char middleInitial;
		String lastName;
		String suffix = null;

		firstName = JOptionPane.showInputDialog("Enter First Name");
		middle = JOptionPane.showInputDialog("Enter Middle Initial");
		if (!middle.isEmpty())
			middleInitial = middle.charAt(0);
		else
			middleInitial = ' ';
		lastName = JOptionPane.showInputDialog("Enter Last Name");
		suffix = JOptionPane.showInputDialog("Enter Suffix, if N/A Enter NONE");

		Name result = new Name(firstName, middleInitial, lastName, suffix);

		return result;
	} //	public static Name createName()

	//	toSting() returns a string containing the relevant information of a Name
	public String toString() {
		String output = "";

		if (!this.suffix.equals("NONE"))
			output += this.suffix + ". ";

		output += this.firstName + " ";
		if (this.middleInitial != ' ')
			output += this.middleInitial + ". ";
		output += this.lastName;
		return output;
	}

} //	END	public class Name