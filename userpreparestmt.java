package preparedstmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class userpreparestmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			Scanner sc =new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/marks","root","root");
			System.out.print("enter id");
			int a=sc.nextInt();
			System.out.print("enter marks");
			int b=sc.nextInt();
			ps=conn.prepareStatement("insert into marks values(?,?)");
		    ps.setInt(1,a);
		    ps.setInt(2,b);
		    int i=ps.executeUpdate();
		    if(i>0) {
		    	System.out.println("success");
		    }
		    else {
		    	System.out.println("not success");
		    }
		    ps =conn.prepareStatement("select * from marks");
		    rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	System.out.println(rs.getString(1)+" "+rs.getInt(2));
		    }
		    conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
