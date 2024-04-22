package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class connectioncheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			
			if(conn !=null)
			{
				System.out.println("successfully connected.");
			}
			else
			{
				System.out.println("failed to connect.");
			}
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+e);
		}

	}


}

