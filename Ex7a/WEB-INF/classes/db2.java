import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class db2 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        String place = request.getParameter("place");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root", "");
            stmt = conn.createStatement();
            String sql;
            //select data from table where dept matches the value given by user in form
            sql = "SELECT * FROM tourists where Place = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, place);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set
            while(rs.next())
            {
            //Retrieve by column name
            String name = rs.getString("Name");
            String phone = rs.getString("Phone");
            //Display values
            out.println("Name: " + name + "<br>");
            out.println("<p> Phone: " + phone + "<br>");
           
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.print("Do not connect to DB - Error:"+e);
        }
    }
}