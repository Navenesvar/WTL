import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ScoreServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        int score = 0;

        // Retrieve user's answers from the request
        String q1 = request.getParameter("q1").toLowerCase();
        String q2 = request.getParameter("q2").toLowerCase();

        // Retrieve answers for question 3 (checkboxes)
        String q3a = request.getParameter("q3a");
        String q3b = request.getParameter("q3b");
        String q3c = request.getParameter("q3c");
        String q3d = request.getParameter("q3d");

        // Retrieve the selected answer for question 4 (radio button)
        String q4 = request.getParameter("q4");

        String q5 = request.getParameter("q5").toLowerCase();

        // Check answers and calculate score
        if ("hyderabad".equals(q1)) {
            score++;
        }
        if ("bangalore".equals(q2)) {
            score++;
        }

        // Check answers for question 3 (checkboxes)
        if (q3a != null && q3b != null && q3c == null && q3d == null) {
            score++;
        }

        // Check answer for question 4 (radio button)
        if ("Lucknow".equals(q4)) {
            score++;
        }

        if ("punjab".equals(q5)) {
            score++;
        }

        out.println("<html><head><title>Quiz Result</title></head><body>");
        out.println("<h1>Quiz Result</h1>");
        out.println("<p>Your score is: " + score + " out of 5</p>");
        out.println("</body></html>");
    }
}
