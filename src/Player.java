import javax.swing.JOptionPane;

/*	Player Class
 * 	This class will allow for the creation of Date objects.
 */
public class Player {
	//	Fields
	private Name name;
	private Date dob;
	private int currentBalance;

	//	Behaviors
	//	No arg Constructor
	public Player() {

	}

	//	All field Constructor
	public Player(Name name, Date dob, int currentBalance) {
		setName(name);
		setDob(dob);
		setCurrentBalance(currentBalance);
	}

	//	returns the Name of the Player
	public Name getName() {
		return name;
	}

	//	sets the Name of the Player
	public void setName(Name name) {
		this.name = name;
	}

	//	returns the dob of the Player
	public Date getDob() {
		return dob;
	}

	//	sets the dob of the Player
	public void setDob(Date dob) {
		this.dob = dob;
	}

	//	returns the currentBalance of the Player
	public int getCurrentBalance() {
		return currentBalance;
	}

	//	sets the currentBalance of the Player 
	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	/* Method		 :  public static Player createPlayer()
	 * Data Required : 	none
	 * Data Returned :	a type Player variable
	 * Purpose		 :	To create, new player objects using the user's input
	 * Description	 :	This method prompts the user to fill the fields of a Player
	 */
	public static Player createPlayer() {
		Name name = Name.createName();
		Date dob = Date.createDate("Enter Date of Birth");
		int currentBalance = Integer
				.parseInt(JOptionPane.showInputDialog("Enter Starting Casino Balance", "Enter a whole dollar amount"));

		Player temp = new Player(name, dob, currentBalance);
		JOptionPane.showMessageDialog(null, "New Player\t\t:\n" + temp.toString());
		return temp;
	} //	END	public static Player createPlayer()

	/* Method		:  public static void statisticsMenu(SlotMachine[] slots)
	 * Data Required : 	1) An array of type Player
	 * 					2) The effective size of the array
	 * Data Returned :	The index of the selected player
	 * Purpose		 :	To output a numbered list of the players, and allow the user to
	 * 					select a player.
	 * Description	 :	
	 */
	public static int selectPlayer(Player[] players, int playerCount) {
		int result;
		String output;
		do {
			output = "Players";
			for (int i = 0; i < playerCount; i++)
				output += "\n" + (i + 1) + ". " + players[i].name + " Balance: $" + players[i].currentBalance;

			result = Integer.parseInt(JOptionPane.showInputDialog(output, "Enter a Number"));
		} while (result > playerCount || result < 0);

		result--;	//	Sets result to an index starting at 0 instead of 1

		return result;
	} //	END	public static int selectPlayer(Player[] players, int playerCount)

	//	toString() returns a String containing the relevant information a Player Contains
	public String toString() {
		return "Name : " + name + "\nDate of Birth : " + dob + "\nBalance $" + currentBalance;
	}

} //	END	public class Player