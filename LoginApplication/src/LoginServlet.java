import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {

	Connection con;
	PreparedStatement ps;

	private boolean checkLogin(String username,String password){

		try {

			ps.setString(1,username);
			ps.setString(2,password);
		
			ResultSet rs = ps.executeQuery();

			ps.clearParameters();

			return rs.next();
		
		} catch (Exception e){

			System.out.println(e.getMessage());	
			return false;

		}

	}

    @Override
	public void init(ServletConfig config){

		try {

			super.init(config);
			ServletContext context = config.getServletContext();

			String driver = context.getInitParameter("driver");
			String url = context.getInitParameter("url");
			String username = context.getInitParameter("username");
			String password = context.getInitParameter("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("select * from LoginApplicationTable where username = ? and password = ?");

		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}

	}

    @Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response){

		try{

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if( checkLogin(username,password) ){

				out.println("Login Successfully");

			}else {

				out.println("Login Unsuccessful <br/> Try Again <a href=\"Login.html\"> Login </a> ");

			}

			out.close();

		}catch(Exception e){

			System.out.println(e.getMessage());

		}

	}

    @Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) {

		doGet(request,response);
		
	}

    @Override
	public void destroy(){

		try {

			ps.close();
			con.close();

		}catch(Exception e){

			System.out.println(e.getMessage());

		} 

	}


}