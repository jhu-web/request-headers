package coreservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that gives browser-specific insult. Illustrates how to use the User-Agent
 * header to tell browsers apart.
 * <p>
 * From <a href="http://courses.coreservlets.com/Course-Materials/">the coreservlets.com
 * tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */
@WebServlet("/browser-insult")
public class BrowserInsult
  extends HttpServlet {

  private static final long serialVersionUID = -4972254413943415146L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title, message;
    // Assume for simplicity that Firefox and IE are
    // the only two browsers
    String userAgent = request.getHeader("User-Agent");
    if ((userAgent != null) && (userAgent.contains("MSIE"))) {
      title = "Microsoft Minion";
      message = "Welcome, O spineless slave to the " + "mighty empire.";
    }
    else {
      title = "Hopeless Firefox Rebel";
      message = "Enjoy it while you can. " + "You <I>will</I> be assimilated!";
    }
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
    out.println(docType + "<HTML>\n"
                + "<HEAD><TITLE>"
                + title
                + "</TITLE></HEAD>\n"
                + "<BODY BGCOLOR=\"#FDF5E6\">\n"
                + "<H1 ALIGN=CENTER>"
                + title
                + "</H1>\n"
                + message
                + "\n"
                + "</BODY></HTML>");
  }
}
