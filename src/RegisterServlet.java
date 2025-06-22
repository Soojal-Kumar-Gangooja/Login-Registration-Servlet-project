import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterServlet extends HttpServlet {

	Connection con;
	PreparedStatement ps;

	private boolean addData(String name,String username,String password){

		try {
	
			ps.setString(1,name);
			ps.setString(2,username);
			ps.setString(3,password);

			int rowsAffected = ps.executeUpdate();

			ps.clearParameters();

			return rowsAffected > 0 ;

		} catch (Exception e){

			System.out.println(e.getMessage());
			return false;

		}

	}

    @Override
	public void init(ServletConfig config) {

		try {
			
			super.init(config);
			ServletContext context = config.getServletContext();

			String driver = context.getInitParameter("driver");
			String url = context.getInitParameter("url");
			String username = context.getInitParameter("username");
			String password = context.getInitParameter("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("insert into LoginApplicationTable values (?,?,?)");

		} catch (Exception e){

			System.out.println(e.getMessage());

		}

	}

    @Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String name = request.getParameter("name");
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if( addData(name,username,password) ){

				out.println("Registration Successfully, You can Now <a href=\"Login.html\"> Login </a>");

			} else {

				out.println("Registration Unsuccessful <br/> Please Try Again <a href=\"Register.html\"> Register </a> ");

			}

			out.close();

		} catch (Exception e){

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