import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve user inputs
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (isValidUser(username, password)) {
            // If the user is valid, create a session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to the welcome page
            response.sendRedirect("WelcomeServlet");
        } else {
            
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Login Failed. Please try again.</h2>");
            out.println("</body></html>");
        }
    }

    private boolean isValidUser(String username, String password) {
        
        return username.equals("NAVENESVAR") && password.equals("navenesvar");
    }
}
