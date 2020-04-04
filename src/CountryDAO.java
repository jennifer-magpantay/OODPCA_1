import java.util.ArrayList;

//Data Access Object Interface
//it holds the operations to be performed on a model object(s)
//an interface class has none constructor, just methods/operations

public interface CountryDAO {
	
	public ArrayList<Country> getAllCountries();
	public Country getCountryByName();
	public Country getCountryByCode();
	public Country addNewCountry();
}
