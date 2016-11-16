package game;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/move")
public class Move extends HttpServlet {
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println
	      ("<!DOCTYPE html>"+
	      "<html><head><meta charset=\"utf-8\">"+
	      	"<title>1vs100</title>"
	      	+ "<head><body>"
	      	+ "<form action=\"read\">"
	      		+ "<input type=\"submit\">"
	      	+ "</form>");
		out.println("</body></html>");
	}
}