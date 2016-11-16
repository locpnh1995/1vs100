package game;

public class Question {
	private long __questionId=-1;
	private String __content="";
	private String __a="";
	private String __b="";
	private String __c="";
	private int __correctAnswer=-1;
	private int __difficult=-1;
	
	Question (String content, String a, String b, String c, int correctAnswer, int difficult){
		this.__content=content;
		this.__a=a;
		this.__b=b;
		this.__c=c;
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
		return __a+"|"+__b+"|"+__c;
	}
	
	public int GetCorrectAnswer(){
		return __correctAnswer;
	}
	
	public int GetDifficult(){
		return __difficult;
	}

}
