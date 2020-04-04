import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CountryDAOImpl implements CountryDAO{
	//adding the database connection
		private Connection conn; 
		private Database db = new Database();//should instantiate the database db to avoid java.null message!!
	
	//add scanner method to read the user input
		Scanner userInput = new Scanner(System.in);
		
		//adding validations for get country by name, code and add new conuntry
		//the best practice is create validations using boolean methods for each type of validation you are going to use
		//follow the naming procedures
		
		//resource: https://regexr.com/	
		//validation for code: string, just letters, length = 3, upper case
		public boolean isCode(String input) {	
			Boolean isCode = input.matches("^[A-Z]{3}$"); 
			
			//adding if statement to print error message		
			if (!isCode) {
				System.out.println("Error reading input. Accepting: letters, uppercase and lenght equals to three, no longer than that. Try again");
				System.out.println();
				return false;
			}
			return isCode;	
			}		
			
		//validation for country name and head of state name: string, just letters, accepting spaces, upper case for each new word/name
		public boolean isName(String input) {
			Boolean isName = input.matches("^([A-Z][a-z]+([ ]?[a-z]?['-]?[A-Z][a-z]+)*)$");
					
			if (!isName) {
				System.out.println("Error reading input. Accepting: just letters and uppercase in each beginning of each name");
				System.out.println();
				return false;
			}
			return isName;	
			}	
		
		//validation for area: float format, just numbers and , or .
		public boolean isArea(String input) {		
			Boolean isArea = input.matches("^[+-]?([0-9]*[.])?[0-9]+$"); //regex "[0-9]+([.|,][0-9]+)?" //"^[+-]?([0-9]*[.])?[0-9]+$"
							
			//adding if statement to print error message		
			if (!isArea) {
				System.out.println("Error reading input. Accepting: just floating numbers. Try again");
				System.out.println();
				return false;
			}
			return isArea;	
			}	

	@Override
	public ArrayList<Country> getAllCountries() {
ArrayList<Country> list = new ArrayList<Country>();	
		
		String query = "SELECT Name FROM country ORDER BY Name ASC";
		conn = new Database().getConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery(); 
			System.out.println("Countries registered: ");

			//create a loop to search through the query	
			while(rs.next())  	
				System.out.println(rs.getString("Name"));
				System.out.println();

			//closing connection
			db.closingConnection();

		}catch( Exception e ){
			System.out.println( e ) ;
		}
		return null;
	}

	@Override
	public Country getCountryByName() {
		Country c = null;
		String input = "";		

		//adding validation
		do {				
			try {
				System.out.print("Which country are you looking for? ");
				input = userInput.nextLine();	
			} catch (InputMismatchException e) { }
			} while (!isName(input));
		
		//if the validation is okn, then start the query			
		String query = "SELECT * FROM country WHERE Name = ?";

		try {  
			PreparedStatement ps = conn.prepareStatement(query);
			//set the input according to the value of ID
			ps.setString(1, input);

			//executing the query select
			ResultSet rs = ps.executeQuery();
			System.out.println("Country found: ");
			System.out.println("Code"+"\t"+"Country Name"+"\t"+"Continent"+"\t"+"Surface Area"+"\t"+"Head Of State");
			while (rs.next()) {
				System.out.println(rs.getString("Code")+"\t"+rs.getString("Name")+"\t"+rs.getString("Continent")+"\t"+rs.getFloat("SurfaceArea")+"\t"+rs.getString("HeadOfState"));
			}
			System.out.println();			
			//closing connection
			db.closingConnection();
		}catch( Exception se ){
			System.out.println( se ); 
		}
		return c;			
	}

	@Override
	public Country getCountryByCode() {
		Country c = null;
		String input = "";		

		//adding validation
		do {				
			try {
				System.out.print("Which country code are you looking for? ");
				input = userInput.nextLine();	
			} catch (InputMismatchException e) { }
			} while (!isCode(input));
				
		//if the validation is okn, then start the query
		String query = "SELECT * FROM country WHERE Code = ?";

		try {  
			PreparedStatement ps = conn.prepareStatement(query);
			//set the input according to the value of ID
			ps.setString(1, input);

			//executing the query select
			ResultSet rs = ps.executeQuery();

			System.out.println("Country Code found: ");
			System.out.println("Code"+"\t"+"Country Name"+"\t"+"Continent"+"\t"+"Surface Area"+"\t"+"Head Of State");
			while (rs.next()) {
				System.out.println(rs.getString("Code")+"\t"+rs.getString("Name")+"\t"+rs.getString("Continent")+"\t"+rs.getFloat("SurfaceArea")+"\t"+rs.getString("HeadOfState"));
			}
			System.out.println();			
			//closing connection
			db.closingConnection();
		}catch( Exception se ){
			System.out.println( se ); 
		}	
		return c;
	}

	@Override
	public Country addNewCountry() {
		//adding the instance of the class
				Country myCountry= new Country();

				//adding patterns to validate the user input		
						String codePattern = "^[A-Z]{3}$"; //just accept 03 letters in Uppercase
						String namePattern ="^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"; //pattern just accept words that begins with Upercase and finishes with lowercase
						String floatPattern = "^[+-]?([0-9]*[.])?[0-9]+$";//just accept numbers

						//adding a string input to be read by the class scanner		
						String input = "";
						
						System.out.println("Which country would you like to add to the database?");
						System.out.println("Follow the required information below to add a new country");
						
						//code
						//error when using the validating methods
						//message of duplicate string '' on PRIMARY
//						try {				
//							do {
//								System.out.print("Code: ");				
//								input = userInput.nextLine();	
//								myCountry.setCode(userInput.nextLine());	
//						} while (!isCode(input));
//						} catch (InputMismatchException e) { }
						
						//after long hours trying it, I have decided to use the old method - and that works!				
						try {	
							boolean validation = false;
							do {
								System.out.print("Code: ");				
								myCountry.setCode(userInput.nextLine());
								if (myCountry.getCode().matches(codePattern)) { 
									validation = true;
								}
							} while (validation == false);
						} catch (Exception e) {System.out.println("Error reading input. Try again");}
						
									
						//country		
						try {		
							boolean validation = false;
							do {
								System.out.print("Country Name: ");
								myCountry.setName(userInput.nextLine());				
								if (myCountry.getName().matches(namePattern)) { 
									validation = true;
								}				
							} while (validation == false);
						} catch (Exception e) {System.out.println("Error reading input. Try again");}

				
				
				//continent	
				System.out.print("Choose one of the following continents: ");

				try { 						
					System.out.println();		
					System.out.println("1: Asia");
					System.out.println("2: Europe");
					System.out.println("3: North America");
					System.out.println("4: Africa");
					System.out.println("5: Oceania");
					System.out.println("6: Antarctica");
					System.out.println("7: South America");

					boolean validation = false;
					String chooseLevel;

					//declaring the class enum inside switch-case using singleton pattern
					//Enumclass instance = Enumclass.getInstance(); 
					//Enumclass instance = Enumclass.instance;

					do {			 		 
						chooseLevel = userInput.nextLine();	
						switch (chooseLevel) {
						case ("1"):
							Continents asia = Continents.getAsia(); //OR Continents.ASIA;
						myCountry.setContinent(asia.getcontName()); //has to get the name of the country as String to save into the Database
						//myCountry.setContinent(asia.getconName());
						//myCountry.setContinent(continents.getAsia());
						//myCountry.setContinent(continents.ASIA());					
						break;	

						case ("2"):	
							Continents euro = Continents.getEurope();
						myCountry.setContinent(euro.getcontName());
						break;

						case ("3"):
							Continents north = Continents.getNorthAm();
						myCountry.setContinent(north.getcontName());
						break;

						case ("4"):	
							Continents afric= Continents.getAfrica();
						myCountry.setContinent(afric.getcontName());
						break;

						case ("5"):	
							Continents ocean = Continents.getOceania();
						myCountry.setContinent(ocean.getcontName());
						break;

						case ("6"):	
							Continents antart = Continents.getAntarctica();
						myCountry.setContinent(antart.getcontName());
						break;

						case ("7"):		
							Continents south = Continents.getSouthAm();
						myCountry.setContinent(south.getcontName());
						break;

						default: 
							break;
						}
					} while (validation);
				} catch (Exception e) {System.out.println("Error reading input. Try again");}

				//surface
				try {		
					boolean validation = false;
					do {
						System.out.print("Surface Area: ");
						myCountry.setSurfaceArea(userInput.nextFloat());					
						if (Float.toString(myCountry.getSurfaceArea()).matches(floatPattern)){
							validation = true;
						}				
					} while (validation == false );
				} catch (Exception e) {System.out.println("Error reading input. Try again");}


				//UNWANTED BUG!! IS PRINTING TWICE "HEAD OF STATE"!!
				try {		
					boolean validation = false;
					do {
						System.out.print("Head of State: ");
						myCountry.setHeadOfState(userInput.nextLine());				
						if (myCountry.getHeadOfState().matches(namePattern)) { 
							validation = true;
						}				
					} while (validation == false);
				} catch (Exception e) {System.out.println("Error reading input. Try again");}		
				
				
				//UNWANTED BUG!! IS PRINTING TWICE "HEAD OF STATE"!!??
				//starting to record
				
				String query = "INSERT INTO country (Code, Name, Continent, SurfaceArea, HeadOfState) VALUES (?, ?, ?, ?, ?)";

				try {
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, myCountry.getCode());
					ps.setString(2, myCountry.getName());
					ps.setString(3, myCountry.getContinent()); //HOW SET THE ENUM INTO DATABASE RECORD - INSTEAD STRING???
					ps.setFloat(4, myCountry.getSurfaceArea());
					ps.setString(5, myCountry.getHeadOfState());

					//prepared statements use placeholders (?) instead of directly writing the values into the statements
					//The ? is a placeholder which is going to be filled later

					ps.executeUpdate();
					//ps.execute();

					System.out.println();
					//JOptionPane.showMessageDialog(f,"DATABASE CONFIRMATION: New register has been added succesfully"); 
					System.out.println(":: DATABASE CONFIRMATION: New country has been added succesfully");
					System.out.println();

					//closing connection
					db.closingConnection();
				}catch( Exception se ){
					System.out.println( se ) ;
				}

				return null;						
			}


}
