
//through this class, only this one, we will be able to access the database using just one line command
//so: then client will access the menu, the menu will sent the client to this class and this class will communicate with the database
//this class also will be used to get the variables values for the dao implemented class 

public class Country extends CountryAbs{
	
	protected Country(CountryAbsBuilder builder) {
		super (builder);
	}
	
	
	
}

