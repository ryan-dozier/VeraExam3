import java.time.LocalDate;
import javax.swing.JOptionPane;

/*	Date Class
 * 	This class will allow for the creation of Date objects.
 */
public class Date {
	//	Fields
	private int month;
	private int day;
	private int year;

	//	Behaviors
	//	No arg Constructor
	public Date() {

	}

	//	The all date constructor
	public Date(int month, int day, int year) {
		setMonth(month);
		setYear(year);
		setDay(day);
	}

	//	The pre-set year constructor
	public Date(int month, int day) {
		setMonth(month);
		this.year = 2017;
		setDay(day);
	}

	//	returns the month of the current Date
	public int getMonth() {
		return month;
	}

	//	sets the month of the current Date
	public void setMonth(int month) {
		String input;
		while (month < 0 || month > 12) {
			input = JOptionPane.showInputDialog(
					"Invalid month Detected\nRecieved Value : " + month + "\n\nEnter a new month",
					"Enter an Integer (1-12)");
			month = Integer.parseInt(input);
		}
		this.month = month;
	}

	//	returns the day of the current Date
	public int getDay() {
		return day;
	}

	//	sets the day of the current Date
	public void setDay(int day) {
		String input;
		int maxDay = 0;

		if (this.month == 2) {
			if (this.year % 4 == 0) //	tests if leap year
				maxDay = 29;
			else
				maxDay = 28;
		}
		else {
			if (this.month < 8) { //	for the first 7 months
				if (this.month % 2 == 0) // even is 30 days
					maxDay = 30;
				else
					maxDay = 31; // odd is 31 days
			}
			else { //	rest of the months
				if (this.month % 2 == 0)
					maxDay = 31; //	even is 31 days
				else
					maxDay = 30; //	odd is 30 days
			}
		}

		while (day < 1 || day > maxDay) {
			input = JOptionPane.showInputDialog("Invalid Day Detected" + "\nRecieved Value : " + day + "\nMost Days in "
					+ this.month + " : " + maxDay + "\n\nEnter a new day", "Enter an Integer (1-" + maxDay + ")");
			day = Integer.parseInt(input);
		}
		this.day = day;
	}

	//	returns the year of the current Date
	public int getYear() {
		return year;
	}

	//	sets the year of the current Date
	public void setYear(int year) {
		String input;
		while (year < LocalDate.now().getYear() - 150 || year > LocalDate.now().getYear()) {
			input = JOptionPane.showInputDialog(
					"Invalid year Detected\nRecieved Value : " + year + "\n\nEnter a new year", "Enter a 4 digit year");
			month = Integer.parseInt(input);
		}
		this.year = year;
	}

	/* Method		 :  public static Date createDate()
	 * Data Required : 	none
	 * Data Returned :	a type Date variable
	 * Purpose		 :	To create, new Date objects using the user's input
	 * Description	 :	This method prompts the user to fill the fields of a Date
	 */
	public static Date createDate() {
		int month = Integer.parseInt(JOptionPane.showInputDialog("\nmonth/day/year\n" + "Enter the Month"));
		int day = Integer.parseInt(JOptionPane.showInputDialog("\n" + month + "/day/year\n" + "Enter the Day"));
		int year = Integer
				.parseInt(JOptionPane.showInputDialog("\n" + month + "/" + day + "/year\n" + "Enter the Year"));

		Date temp = new Date(month, day, year);
		return temp;
	} //	END	public static Date createDate() 

	/* Method		 :  public static Date createDate(String messege)
	 * Data Required : 	a String messege
	 * Data Returned :	a type Date variable
	 * Purpose		 :	To create, new Date objects using the user's input
	 * Description	 :	This method outputs a messege to the user then prompts the user to fill the fields of a Date
	 */
	public static Date createDate(String messege) {
		int month = Integer.parseInt(JOptionPane.showInputDialog(messege + "\nmonth/day/year\n" + "Enter the Month"));
		int day = Integer
				.parseInt(JOptionPane.showInputDialog(messege + "\n" + month + "/day/year\n" + "Enter the Day"));
		int year = Integer.parseInt(
				JOptionPane.showInputDialog(messege + "\n" + month + "/" + day + "/year\n" + "Enter the Year"));

		Date temp = new Date(month, day, year);
		return temp;
	} //	END	public static Date createDate(String messege)

	//	toString() returns the relevant data of the Date type
	public String toString() {
		return month + "/" + day + "/" + year;
	}

} //	END	public class Date