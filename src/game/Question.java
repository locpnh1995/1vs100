package game;

public class Question {
//	private long __questionId=-1;
	private String __content="";
	private String __answer="";
	private int __correctAnswer=-1;
	private int __difficult=-1;
	
	Question (String content, String answer, int correctAnswer, int difficult){
		this.__content=content;
		this.__answer=answer;
		this.__correctAnswer=correctAnswer;
		this.__difficult=difficult;
	}
	
	Question()
	{
		
	}
	
//	public long GetQuestionID()
//	{
//		return __questionId;
//	}
	
	public String GetContent(){
		return __content;
	}
	
	public String GetAnswer(){
		return __answer;
	}
	
	public int GetCorrectAnswer(){
		return __correctAnswer;
	}
	
	public int GetDifficult(){
		return __difficult;
	}

}
