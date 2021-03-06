package connection;
import java.sql.*;
import static connection.Provider.*;

public class ConnectionString {
	static Connection con=null;
	//single connection object for whole application since we used static
	static{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			//we can use provider object properties because we statically imported Provider object
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","1234");
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	//returns already existing connection object
	public static Connection getCon(){
		return con;
	}
}
