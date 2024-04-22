package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class statementconnection {

	public static void main(String[] args) {
	
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
					Statement stmt=conn.createStatement(); 
						int i =stmt.executeUpdate("update course set duration = 10 where cid=102");
								
								if(i>0)
								{
								System.out.println("insertion");
								}else 
								{System.out.println("nd");
									
								}
								
								ResultSet rs=stmt.executeQuery("select * from course where cid>3");  
								  
							 while(rs.next())
							 {
								System.out.println(rs.getInt(1)+" "+rs.getInt(2));  
								  
							
							 }
					conn.close();
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage()+e);
				}

	}

}
