package adminServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionString;
import java.sql.*;
/**
 * Servlet implementation class Food
 */
@WebServlet("/Food")
public class Food extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String foodName = request.getParameter("foodName");
		String foodCost = request.getParameter("foodCost");
		PrintWriter out = response.getWriter();
		
		try{
			Connection con=ConnectionString.getCon();//getting db connection
			PreparedStatement ps = con.prepareStatement("select foodName from food where foodtype ='"+type +"' and foodname='"+foodName+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				out.println( foodName +" zaten var. Lutfen baska bir yemek girin");
				
			}else if(type.equals("")||foodName.equals("")||foodCost.equals("")){
				out.println("Gecersiz Ayrintilar");
				
			}else{
				PreparedStatement p = con.prepareStatement("insert into food value(?,?,?)");
				p.setString(1, type);
				p.setString(2, foodName);
				p.setString(3, foodCost);
				p.executeUpdate();
				out.print(foodName+" Basariyla Eklendi");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
