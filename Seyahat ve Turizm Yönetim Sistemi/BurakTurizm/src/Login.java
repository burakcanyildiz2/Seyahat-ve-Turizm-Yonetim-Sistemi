
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.ConnectionString;
import java.sql.*;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			Connection con = ConnectionString.getCon();// getting db connection
			PreparedStatement ps = con
					.prepareStatement("select name, email, mobile,password  from register where email= ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString(1);
				String emailid = rs.getString(2);
				String mobile = rs.getString(3);
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("email", emailid);
				session.setAttribute("mobile", mobile);
                                
                                // cookiler 
                                Cookie MobileCookie = new Cookie("mobile", mobile);
                                Cookie passwordCookie = new Cookie("password", password);

                                  MobileCookie.setMaxAge(1000000);
                                  passwordCookie.setMaxAge(1000000);

                                  response.addCookie(MobileCookie);          
                                  response.addCookie(passwordCookie);

                                // cookiler 
                                
				out.println("Gecerli");
			} else {
				out.println("Gecersiz kullanici adi veya sifre");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
