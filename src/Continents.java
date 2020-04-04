//enum to represent the continents for the class Country

public enum Continents {
	
	//each country refers to an instance of the class
	ASIA ("Asia"), 
	EUROPE ("Europe"),
	NORTH_AMERICA ("North America"),
	AFRICA ("Africa"),
	OCEANIA ("Oceania"),
	ANTARCTICA ("Antarctica"),
	SOUTH_AMERICA ("South_America");
	
	private String contName;
	
	//private constructor - it would work without that!
	private Continents() {
		
	}
	
	Continents(String contName){ 
		this.contName = contName;				
	}
	
	public String getcontName() {
		return contName;
	}
	
	//ADDING SINGLETON PATTERN TO THE INSTANCES OF THE ENUM CLASS	
	//It would work well without it, but in this case we should get rid off of Enum myEnum = Enum.getInstance(); 
	//using instead Enum myEnum = Enum.LIST;on the Country class
	public static Continents getAsia() {
		return ASIA;
	}
	
	public static Continents getEurope() {
		return EUROPE;
	}
	
	public static Continents getNorthAm() {
		return NORTH_AMERICA;
	}
	
	public static Continents getAfrica() {
		return EUROPE;
	}
	
	public static Continents getOceania() {
		return OCEANIA;
	}
	
	public static Continents getSouthAm() {
		return SOUTH_AMERICA;
	}
	
	public static Continents getAntarctica() {
		return ANTARCTICA;
	}
}

//declaring and printing an enum:
//Continents myCont = Continents.Asia;
//System.out.println(myCont);

//Continents myCont = Continents.Asia;
//String continent = myCont.continent();

//enum - design pattern initializtion
/* public enum Class{
 * 		instance;
 * 
 * 		private Class (){
 * }
 * public static Class getInstance(){
 * 		return instance;
 * }
 * } 
 */




