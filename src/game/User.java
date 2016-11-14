package game;

public class User {
	private long __userId=-1;
	private String __username="";
	private String __password="";
	private boolean __gender=true;
	private int __age=0;
	private boolean __relationship=false; //tình trạng hôn nhân
	private int totalPoints=0; //tổng số tiền thưởng mà user chơi được
	private int consecutiveCorrectAnswer=0;//số tiền thưởng cao nhất mà user chơi trong 1 ván
	
	public long GetID()
	{
		return __userId;
	}
	
	public String GetUsername()
	{
		return __username;
	}
	
	public boolean GetGender()
	{
		return __gender;
	}
	
	public int GetAge()
	{
		return __age;
	}
	
	public boolean GetRelationship()
	{
		return __relationship;
	}
	

}
