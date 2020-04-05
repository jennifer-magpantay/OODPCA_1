//this class it is part of the builder pattern
//all the creation of a new object of the class Country will be responsibility from now on oh the CountryAbs class
//because the constructor of the this class is protected, then, none of the other class can instantiate it
public class Country extends CountryAbs{
	
	protected Country(CountryAbsBuilder builder) {
		super (builder);
	}
	
	
	
}

