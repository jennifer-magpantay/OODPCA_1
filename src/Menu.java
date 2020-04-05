import java.util.ArrayList;
import java.util.Scanner;

//this is the class the user will interact with
//each menu option has a instantiation of other class/methods that will brings the user to
public class Menu {		

	public Menu() { 
		start();
	}

	public void start() {	

		//instantiating the country classes
		CountryAbs ctr = new Country.CountryAbsBuilder().build();
		CountryDAO dao = new CountryDAOImpl();
		ArrayList<Country> list; 

		//add scanner method to read the user input
		Scanner userInput = new Scanner(System.in);
		
		String option = null; //wont allow any null value (enter)	
		
		//using the try/catch to the menu be displayed after each operation
		try {
			do {			
				System.out.println("********* MENU OPTIONS *********");
				System.out.println();			
				System.out.println("1. Display all Countries");
				System.out.println("2. Search a Country by Name");
				System.out.println("3. Search a Country by Code");				
				System.out.println("4. Add a new Country");
				System.out.println();

				option=userInput.nextLine();
				switch (option) {
				case("1"):
					System.out.println("------------------------------------------------------");
				//Display all Countries				
				list = dao.getAllCountries();
				break;

				case("2"):
					System.out.println("------------------------------------------------------");
				//Display all Countries by name	
				ctr = dao.getCountryByName();
				//Country countryCode = db.getCountryByCode(); //error to print results
				break;

				case("3"):
					System.out.println("------------------------------------------------------");
				//Search a Country by code
				ctr = dao.getCountryByCode();
				break;

				case("4"):
					System.out.println("------------------------------------------------------");
				//Search a Country by Code
				ctr = dao.addNewCountry();
				break;

				default:
					System.out.println("Error reading input. Try again ");
					System.out.println();
				}
			} while (true);
		} catch (Exception e) {System.out.println("Error reading input");}
	}

}



