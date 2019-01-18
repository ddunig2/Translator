import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register {
	Connection con;
	Statement st;
	String url;
	//dfgkl
	
	public Register() {
		connectToDatabase(); 
	}

	public void connectToDatabase() {
		try {
			url = "jdbc:mysql://localhost:3306/idlu7";
			con = DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean logIn(String userName, String password) {
		try {
			String query = "SELECT password FROM accounts WHERE username = '" + userName+"'";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			if (password.equals(rs.getString(1))) {
				 return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
