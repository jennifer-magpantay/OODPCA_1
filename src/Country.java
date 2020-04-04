
//through this class, only this one, we will be able to access the database using just one line command
//so: then client will access the menu, the menu will sent the client to this class and this class will communicate with the database
//this class also will be used to get the variables values for the dao implemented class 

public class Country {

	//add private variables/attributes for the class country
	//abstract class has none constructors
	private String code;
	private String name;
	private String continent;  //protected static Continents continent;
	private float surfaceArea;
	private String headOfState;

	public Country(String code, String name, String continent, float surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
	}

	public Country() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public float getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	@Override
	public String toString() {
		
		return "Data collected => Code: " + getCode() + ", Country: " + getName() + ", Continent: " +
		getContinent() + ", Surface Area: " + getSurfaceArea() + ", Head of State: " + getHeadOfState();
	}
	
}

