package preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class preparestmtconnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement ps=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/marks","root","root");
			ps=conn.prepareStatement("insert into marks values(?,?)");
		    ps.setInt(1,100);
		    ps.setInt(2,900);
		    int i=ps.executeUpdate();
		    if(i>0) {
		    	System.out.println("inserted successfully");
		    }
		    	else
		    	{
		    		System.out.println("not inserted");
		    	}
		    conn.close();
		}
		    catch(Exception e)
		{
		    	System.out.println(e.getMessage()+e);
		}
	}
}

