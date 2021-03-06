import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//this class is in charge to open the connection with the database
//the getConnection method is part of the java interface
//one you have this class, then it will be easy to get connection from other classes
//the singleton DP was used on this class to avoid other class to instantiate it. the globally access would be made using the getInstace method

//research source: https://www.caelum.com.br/apostila-java-web/bancos-de-dados-e-jdbc
public class Database {

	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;

	private static final Database instance = new Database();

	private Database() {} //adding a private constructor to avoit any class to instantiate 

	public static Database getInstance() {		
		return instance;

	}

	//use the sql.connection java tool
	//then call the method getConnection() to return the connection of the Database	
	public Connection getConnection() {

		try {			
			return DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?user=cctstudent&password=Pass1234!"); //&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		//now, to get connection with the database just use: Connection conn = new ConnectionFactory().getConnection();
	}	

	//part of the Database class, we will set a closeConnection method, that will be in charge to close the communication with the Database	
	public void closeConnection() {
		//System.out.println("Closing message");
		if (conn != null) {
			try {					
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) { e.printStackTrace();	}
		}
	}
	//another way to code that
	//public void closeConnection(PreperadStatment ps, ResultSet rs, Connection conn){ }
	//db.closeConnection(ps, rs, conn);

}
