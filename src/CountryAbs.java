//this class also will be used to get the variables values for the dao implemented class to create a new object of the class country
//builder pattern is applied to this class
//what is in here: all attributes and getters and setters
//also includes the builder class (CountryAbsBuilder)

public abstract class CountryAbs {
	//add private variables/attributes for the class country
	//abstract class has none constructors
	protected String code;
	protected String name;
	protected String continent;  //protected static Continents continent;
	protected float surfaceArea;
	protected String headOfState;
	
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
	
	protected CountryAbs(CountryAbsBuilder builder) {
		this.code = builder.code;
		this.name = builder.name;
		this.continent = builder.continent;
		this.surfaceArea = builder.surfaceArea;
		this.headOfState = builder.headOfState;
	}
	
	//so far, everything from the CountryAbs is protected
	//from here, the only public clas/method is the inner/builder class CountryAbsBuilder
	
	
	public static class CountryAbsBuilder{
		String code;
		String name;
		String continent;  //protected static Continents continent;
		float surfaceArea;
		String headOfState;	
	
		
		
	public CountryAbsBuilder(String code, String name, String continent, float surfaceArea, String headOfState) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surfaceArea = surfaceArea;
		this.headOfState = headOfState;
		
	}
		
	public CountryAbsBuilder() {
		
	}

	public CountryAbs build() {
		return new Country(this); 
	}
	}

}
