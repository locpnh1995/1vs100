package game;


import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class MySQLUtilities {
	
	public static Connection GetMySQLConnection(String dbUsername, String dbPassword, String dbHostname, String dbName) 
			throws SQLException, ClassNotFoundException
	{
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String connectionURL="jdbc:mysql://"+dbHostname+":3306/"+dbName+"?useUnicode=yes&characterEncoding=UTF-8";
		Connection conn = DriverManager.getConnection(connectionURL,dbUsername,dbPassword);
		return conn;
		
	}
	
	public static Question SelectQuestion (int difficult, Connection conn, List<Integer> currentGame) throws SQLException{
		String query="SELECT * FROM question WHERE difficult="+difficult;
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);
		
		Question question = null;
		int questionId=-1;
		
		while(result.next()){
			
			questionId=result.getInt("questionId");
			if (Arrays.asList(currentGame).contains(result.getInt("questionId")))//nếu câu hỏi chọn từ db, đã hỏi rồi
				continue;
			else
			{
				//question = new Question(result.getString("content"),result.getString("answer"),result.getInt("correctAnswer"),result.getInt("difficult"));
				currentGame.add(questionId);
				break;			
			}			
		}
		return question;
	}
	
	public static boolean AddNewQuestions(Connection conn, Question[] questions)
	{
		String query="";
		Statement statement;
		ResultSet resultSet;
		
		try {
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		
		for (int i=0;i<questions.length;i++)
		{
			query="INSERT INTO questions (content,answer,correctAnswer,difficult) VALUES "
					+ "(\""+questions[i].GetContent()+"\",\""+questions[i].GetAnswer()+"\",\""
					+questions[i].GetCorrectAnswer()+"\",\""+questions[i].GetDifficult()+"\")";
			
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
				
				return false;
			}
		}
		
		return true;
	}
}
