package game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/read")
public class ReadWriteFiles extends HttpServlet {
	@Override
	public void doGet (HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Question[] questions= new Question[30];
		ReadQuestionFromFile(questions);
		Connection conn=null;
		try {
			conn = MySQLUtilities.GetMySQLConnection("root", "", "localhost", "1vs100");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		MySQLUtilities.AddNewQuestions(conn, questions);
		
		
	}
	
	private void ReadQuestionFromFile (Question[] questions){
		BufferedReader br = null;
		
		int i=0;
		
		try 
		{
			String currentLine ="";
			br = new BufferedReader
				    (new InputStreamReader(new FileInputStream("F:\\cauhoi.txt"),"UTF-8"));
			while ((currentLine = br.readLine()) != null){
							
				String[] dbQuestion = currentLine.split(Pattern.quote("|"));
				
				String content=dbQuestion[0];
				String a=dbQuestion[1];
				String b=dbQuestion[2];
				String c=dbQuestion[3];
				int correctAnswer=Integer.parseInt(dbQuestion[4]);
				int difficult =Integer.parseInt(dbQuestion[5]);
				
				questions[i++]= new Question(content,a,b,c,correctAnswer,difficult);
			}
		} 
		
		catch (IOException e) {
			e.printStackTrace();

		} 
		
		finally 
		{
			try {
				if (br != null)
					br.close();
			} 
			
			catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
