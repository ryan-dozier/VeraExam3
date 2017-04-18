import java.time.LocalDate;

import javax.swing.JOptionPane;

/*	Class SlotMachine
 * 	This class will allow the user to create SlotMachine objects which will allow the user
 * 	to simulate gambling.
 */
public class SlotMachine {
	//	Class Variables
	//	These first variables keep track of statistics for when any instance variable is used. 
	private static int totalBalance = 0;
	private static int totalPayout = 0;
	private static int allPlays = 0;
	
	//	Fields
	private String machineName;
	private int machineBalance;
	private int numJackpotsPaid;
	private int jackpotOdds;
	private int jackpotPayAmount;
	private int numRegularWinsPaid;
	private int regularWinOdds;
	private int regularPayout;
	private int totalPlays;

	//	Behaviors

	//	No-Arg Constructor
	public SlotMachine() {

	}

	//	The go-to constructor for this class. It creates SlotMachine's based off passed values
	public SlotMachine(String machineName, int machineBalance, int jackpotOdds, int jackpotPayAmount,
			int regularWinOdds, int regularPayout) {
		setMachineName(machineName);
		setMachineBalance(machineBalance);
		this.numJackpotsPaid = 0; // set to 0 this is a counter
		setJackpotOdds(jackpotOdds);
		setJackpotPayAmount(jackpotPayAmount);
		this.numRegularWinsPaid = 0; // set to 0 this is a counter
		setRegularWinOdds(regularWinOdds);
		setRegularPayout(regularPayout);
		this.totalPlays = 0; // set to 0 this is a counter

		SlotMachine.totalBalance += this.machineBalance;
	}

	//	get private static int allplays
	public static int getAllPlays() {
		return allPlays;
	}

	//	get private static int totalBalance
	public static int getTotalBalance() {
		return totalBalance;
	}

	//	get private static int totalPayout
	public static int getTotalPayout() {
		return totalPayout;
	}

	//	get this.machineName
	public String getMachineName() {
		return machineName;
	}

	//	set this.machineName
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	//	get this.machineBalance
	public int getMachineBalance() {
		return machineBalance;
	}

	//	set this.machineBalance
	public void setMachineBalance(int machineBalance) {
		while (machineBalance < 0) {
			machineBalance = Integer.parseInt(JOptionPane
					.showInputDialog("INVALID BALANCE DETECTED\nEnter a new balance", "Enter the machine's balance"));
		}

		this.machineBalance = machineBalance;
	}

	//	get this.jackpotOdds
	public int getJackpotOdds() {
		return jackpotOdds;
	}

	//	set this .jackPotOdds
	public void setJackpotOdds(int jackpotOdds) {
		this.jackpotOdds = jackpotOdds;
	}

	//	get this.jackpotPayAmount
	public int getJackpotPayAmount() {
		return jackpotPayAmount;
	}

	//	set this.jackpotPayAmount
	public void setJackpotPayAmount(int jackpotPayAmount) {
		this.jackpotPayAmount = jackpotPayAmount;
	}

	//	get this.regularWinOdds
	public int getRegularWinOdds() {
		return regularWinOdds;
	}

	//	set this.regularWinOdds
	public void setRegularWinOdds(int regularWinOdds) {
		this.regularWinOdds = regularWinOdds;
	}

	//	get this.regularWinPayout
	public int getRegularPayout() {
		return regularPayout;
	}

	//	set this.regularPayout
	public void setRegularPayout(int regularPayout) {
		this.regularPayout = regularPayout;
	}

	/* Method : public static String getAllMachineStats(SlotMachine[] slots)
	 * Data Required : An array of type SlotMachine 
	 * Data Returned : a String containing the stats across all machines
	 * Purpose 		: This method returns a String containing the statistics of the
	 * 						slot machines. 
	 * Description :
	 */
	public static String getCasinoStats(SlotMachine[] slots) {
		String result = "\t\tTotal Stats" + "\nTotal Balance : $" + SlotMachine.getTotalBalance();
		if (SlotMachine.getTotalPayout() > 0)
			result += "\nThe Casino has lost $" + SlotMachine.getTotalPayout();
		else
			result += "\nThe Casino has made $" + (SlotMachine.getTotalPayout() * -1);

		result += "\nMachines have been played " + SlotMachine.getAllPlays() + " times";
		return result;
	} //	END	public static String getCasinoStats(SlotMachine[] slots)

	/* Method 	: public static String getAllMachineStats(SlotMachine[] slots)
	 * Data Required 	: An array of type SlotMachine 
	 * Data Returned 	: A string containing the machine stats
	 * Purpose 	: This method returns a String containing the statistics of the
	 * 				slot machines. 
	 * Description		:
	 */
	public static String getAllMachineStats(SlotMachine[] slots) {
		String result = "";
		for (int i = 0; i < slots.length; i++)
			result += slots[i].toString() + "\n\n";
		return result;
	} //	END	public static String getAllMachineStats(SlotMachine[] slots)

	/* Method : public void playSlotMachine(Player player) 
	 * 
	 * Data Required : the player variable of type Player. Note: This method is 
	 * 					dependent on the Player Class being included in the project.
	 * 
	 * Data Returned : none
	 * 
	 * Purpose	: This method simulates playing a slot machine. The data we are modifying 
	 * 				is the player.currentBalance to simulate spending and gaining of money.
	 * 
	 * Description	: This method is called from an 
	 * 				instance variable, and is passed a variable of type Player which represents 
	 * 				the individual playing the machine.the return type is void because all 
	 * 				relevant information is passed by reference.
	 */
	public void playSlotMachine(Player player) {

		int playerBalance = player.getCurrentBalance(); //	here the users wallet is stored within the scope of the method.
		int payout = 0;
		String output = player.getName() + " is playing " + this.machineName + "\n" + "Starting Balance : $"
				+ playerBalance + "\n";

		if (this.machineBalance > this.regularPayout) {
			// This next section changes statistics relevant to each play
			playerBalance--;
			this.machineBalance++;
			SlotMachine.totalBalance++;
			SlotMachine.totalPayout--;
			this.totalPlays++;
			SlotMachine.allPlays++;

			int slotRoll = (int) (Math.random() * this.jackpotOdds) + 1; //	random number between 1 and jackPotOdds is generated 

			if (slotRoll == this.jackpotOdds) { //	jackpot win
				payout = this.jackpotPayAmount + 1;
				this.numJackpotsPaid++;
				output += "\n*******************\n* JACKPOT WON! *\n*******************\n";
			}
			else if (slotRoll % this.regularWinOdds == 0) { //	regular sin
				payout = this.regularPayout + 1;
				this.numRegularWinsPaid++;
				output += "\n**************\n* You WON! *\n**************\n";
			}
			else {
				output += "\nYou Lost Try again!\n"; //	loss
				payout = 0;
			}

			if (payout > this.machineBalance) { //	If the machine has less money than the payout the machine pays its balance
				output += "\nSORRY, The machine only has $" + this.machineBalance + "\nWinnings will be "
						+ this.machineBalance + "\n";
				payout = this.machineBalance;
			}

			playerBalance += payout; //	This will be positive when they win and 0 when they lose

			player.setCurrentBalance(playerBalance); //	This updates the balance with the balance after 
														//	using the slotMachine

			output += "\nCurrent Balance : $" + player.getCurrentBalance();

			//	The next two lines adjust the SlotMachines balances. 
			this.machineBalance -= payout;
			SlotMachine.totalBalance -= payout;

			JOptionPane.showMessageDialog(null, output); // output the results of the play to the user.
		}

	} //	END	public void playSlotMachine(Player player)

	/* Method : public static void playTheSlots(SlotMachine[] slots, Player currentPlayer) 
	 * Data Required : 	1) an array of type SlotMachine,
	 * 					2) a player of type Player
	 * Data Returned : none
	 * Purpose	  :	This is the SlotMachine menu. it will output a list of available slot machines, and 
	 * 				allow the user to select one to play.
	 * Description :	create a string which will contain the list of slot machine names, output that to the
	 * 					user in the form of a numbered list, then take user input to determine the machine they selected.
	 */
	public static void playTheSlots(SlotMachine[] slots, Player currentPlayer) {
		String output;
		int slotNum;
		boolean continueSlots = true;

		do { // Start Loop
			continueSlots = validPlayer(currentPlayer);
			if (continueSlots) { //	if the Player has money
				output = "\tSlot Machines";
				for (int i = 0; i < slots.length; i++)
					output += "\n" + (i + 1) + ".\t" + slots[i].getMachineName();
				output += "\n 0. Leave Slots";

				slotNum = Integer.parseInt(JOptionPane.showInputDialog(output, "Choose a Slot to play"));
				if (slotNum > 0 && slotNum <= slots.length)
					slots[slotNum - 1].playSlotMachine(currentPlayer);
				else
					continueSlots = false;
			}
		} while (continueSlots); //	While the player keeps playing slots

	} //	END public static void playTheSlots(SlotMachine[] slots, Player currentPlayer)

	/* Method :  public static void statisticsMenu(SlotMachine[] slots)
	 * Data Required : 	an array of type SlotMachine
	 * Data Returned : none
	 * Purpose :	to allow the user to view statistics about the SlotMachines
	 * Description :	output menu choices to the user, then take input of which option they wish to view
	 */
	public static void statisticsMenu(SlotMachine[] slots) {
		int userChoice;
		String output = "\t\tStatistics Menu";

		for (int i = 0; i < slots.length; i++)
			output += "\n" + (i + 1) + ". " + slots[i].getMachineName();
		output += "\n4.\tView all Machines" + "\n5.\tView Total Stats" + "\nX.\tExit";

		userChoice = Integer.parseInt(JOptionPane.showInputDialog(output));

		if (userChoice > 0 && userChoice <= slots.length)
			JOptionPane.showMessageDialog(null, slots[userChoice - 1].toString());
		else if (userChoice == slots.length + 1)
			JOptionPane.showMessageDialog(null, SlotMachine.getAllMachineStats(slots));
		else if (userChoice == slots.length + 2)
			JOptionPane.showMessageDialog(null, SlotMachine.getCasinoStats(slots));
	} //	END	public static void statisticsMenu(SlotMachine[] slots)

	/* Method : public static boolean validPlayer(Player person) 
	 * Data Required :  A variable of type person 
	 * Data Returned : a boolean value Purpose : This method tests whether or not the player is old enough to gamble, and if
	 * 					the player has a non-zero balance 
	 * Description 	: Returns true when the player is able to play, false if not.
	 */
	public static boolean validPlayer(Player person) {
		boolean result = true;
		int yearToGamble = LocalDate.now().getYear() - 18;
		if (person.getCurrentBalance() < 1) { //	test for zero/negative balance
			result = false;
			JOptionPane.showMessageDialog(null, "Invalid Funds\nBalance : $" + person.getCurrentBalance());
		}
		if (person.getDob().getYear() > yearToGamble) { //	test if the user is old enough to gamble
			result = false;
			JOptionPane.showMessageDialog(null, "This player is too young to gamble.");
		}

		return result;
	} //	END	public static boolean validPlayer(Player person)

	//	toString() returns a string of relevant information for the user
	public String toString() {
		return "\t\tSlotMachine\nName : " + machineName + "\nBalance $" + machineBalance + "\nJackpots Paid : "
				+ numJackpotsPaid + "\nJackpot Amount $" + jackpotPayAmount + "\nRegular Wins : " + numRegularWinsPaid
				+ "\nRegular Payout $" + regularPayout + "\nThis machine has been played " + totalPlays + " times.";
	} //	END	public String toString()

} //	END	public class SlotMachine