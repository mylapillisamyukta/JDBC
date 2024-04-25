package project;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginformservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginformservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		response.setContentType("text/html");
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "root");
		Statement st =conn.createStatement();
		String query="select * from login where username = '"+username+"'and password = '"+password+"'";
		ResultSet rs =st.executeQuery(query);
		if(rs.next())
		{
			System.out.print("login successfull");
		} else {
			System.out.print("fail to login");
	
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
