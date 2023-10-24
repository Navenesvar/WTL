import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class db1 extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn=null;
        Statement stmt=null;
        PrintWriter out = response.getWriter();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("<h1> into class</h1>");
            //create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tour","root", "");
            if(conn!=null)
            {
                out.println("<h1> No issues in Connection</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            //display all the students' marks
            sql = "SELECT * FROM tourists";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while(rs.next())
            {
                //out.println("<h1> into while loop</h1>");
                //Retrieve by column name
                String name = rs.getString("Name");
                String place = rs.getString("Place");
                String phone = rs.getString("Phone");
                
                //Display values
                out.println("<p> Name: " + name + "<br>");
                out.println("Place: " + place + "<br>");
                out.println("Phone: " + phone + "<br>");
                
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