
/*	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 																						*
 *		Written by Ryan Dozier															*
 * 																						*
 * 		Exam  3	: 	Slot Machine 														*
 * 																						*
 *	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *																						*
 * 	Redo Aunt Vera goes to Vegas (with the following new rules)				Status:		*
 *	You need to include the following classes											*
 *		A testClass that holds main											Complete	*
 *		A Player Class (Name, DOB, moneyBalance)							Complete	*
 *		A Name Class (firstName, middleInitial, lastName, suffix)			Complete	*
 *		A Date Class (month, day, year)										Complete	*
 *																						*
 *	You are to create three different slot machines							Complete	*
 *	You are to create Aunt Vera and 49 other slot machine players.			Complete	*
 *																						*
 *	You will need a menu system.											Complete	*
 *																						*
 *	When the user goes to play a slot machine, you will allow the user 		Complete	*
 *	to select the player and the machine. During each play, you will 					*
 *	show the players beginning balance and ending balance. You will 					*
 *	display if they won, the win amount and the words JACKPOT if 						*
 *	they hit the jackpot.																*
 *																						*
 *	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
import javax.swing.JOptionPane;

public class Exam3Main {

	public static void main(String[] args) {

		//	Variables
		SlotMachine[] machines = new SlotMachine[3];
		Player[] players = new Player[50];
		int currentPlayer = 0; // Set this initially to an invalid value to test when a player has been created
		

		//	Initialize Variables for use
		players[0] = initializeVera();
		int playerCount = 1;
		initializeMachines(machines);
	
		char menuChoice = '0';

		do { //	Start Main Loop
			menuChoice = runMenu(players[currentPlayer].toString());

			switch (menuChoice) {
			case '1': //	Create a New Player
				if (playerCount < players.length) { //	if room in players array
					players[playerCount] = Player.createPlayer();
					currentPlayer = playerCount; //	sets current player to the newly created player
					playerCount++;
				}
				else
					JOptionPane.showInputDialog("Player Array Full");
				break;
			case '2': //	Select a Player
				currentPlayer = Player.selectPlayer(players, playerCount);
			case '3': //	Play a Machine
				SlotMachine.playTheSlots(machines, players[currentPlayer]);
				break;
			case '4': //	Statistics
				SlotMachine.statisticsMenu(machines);
				break;
			case 'X': //	Exit
				break;
			default:
				break;
			}

		} while (menuChoice != 'X'); //	End Main Loop

	} //	END	public static void main(String[] args)

	/* Method		 :  public static void initializeMachines(SlotMachine[] machines)
	 * Data Required :	An array of SlotMachines
	 * Data Returned :	none
	 * Purpose		 :	To initialize the SlotMachines used in this program
	 * Description	 :	We initialize the reference variables with the initial conditions for
	 * 					our three slotmachines.
	 */
	public static void initializeMachines(SlotMachine[] machines) {
		machines[0] = new SlotMachine("Lucky 777", 5000, 10000, 5000, 10, 5);
		machines[1] = new SlotMachine("Lucky Lotto", 55000, 100000, 75000, 50, 25);
		machines[2] = new SlotMachine("Purple People Eater", 1000, 50, 40, 5, 2);
	} //	END public static void initializeMachines(SlotMachine[] machines)

	/* Method		 :  private static Player initializeVera()
	 * Data Required :	none
	 * Data Returned :	A Player Variable
	 * Purpose		 :	To initialize the first Player variable
	 * Description	 :	The first Player is created.
	 */
	private static Player initializeVera() {
		Name name = new Name("Vera", 'D', "Hunchuck", "Aunt");
		Date dob = new Date(11, 5, 1955);
		int balance = 100;

		Player result = new Player(name, dob, balance);
		return result;
	} //	END	private static Player initializeVera()

	/* Method		 :  public static char runMenu()
	 * Data Required :	none
	 * Data Returned :	a character representing the user's menu choice
	 * Purpose		 :	To output the menu to the user, and receive an input
	 * Description	 :	see Purpose
	 */
	public static char runMenu() {
		char result = '0';
		String output = "\t\t\t\t\t\t\t\tMain Menu\n1.\t\tCreate New Player" + "\n2.\t\tSelect a Player"
				+ "\n3.\t\tPlay a Machine" + "\n4.\t\tView Stats" + "\nX.\t\tExit\n\nCurrent Player\nNONE";
		result = JOptionPane.showInputDialog(output, "Enter a Menu Selection").toUpperCase().charAt(0);

		return result;
	} //	END public static char runMenu()

	/* Method		 :  public static char runMenu(String playerStats)
	 * Data Required :	a String message
	 * Data Returned :	a character representing the user's menu choice
	 * Purpose		 :	To output the menu to the user, and receive an input
	 * Description	 :	The menu displays, and the stats of the current player 
	 * 					are displayed at the bottom.
	 */
	public static char runMenu(String playerStats) {
		char result = '0';
		String output = "\t\t\t\t\t\t\t\tMain Menu\n1.\t\tCreate New Player" + "\n2.\t\tSelect a Player"
				+ "\n3.\t\tPlay a Machine" + "\n4.\t\tView Stats" + "\nX.\t\tExit\n\n*\t\t\t\tCurrent Player\t\t\t\t*\n" + playerStats;
		result = JOptionPane.showInputDialog(output, "Enter a Menu Selection").toUpperCase().charAt(0);

		return result;
	} //	END	public static char runMenu(String playerStats)

} //	END public class Exam3Main