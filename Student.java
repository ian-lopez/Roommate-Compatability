public class Student 
{
	protected String name;
	protected char gender;
	protected Date birthdate;
	protected Preference pref;
	protected boolean match;
	
	public Student(String name, char gender, Date birthdate, Preference pref)
	{
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.pref = pref;
		match = false;
	}
	
	public String getName()
	{
		return name;
	}
	
	public char getGender()
	{
		return gender;
	}
	
	public Date getDate()
	{
		return birthdate;
	}
	
	public Preference getPref()
	{
		return pref;
	}
	
	public boolean getMatch()
	{
		return match;
	}
	
	public boolean setMatch()
	{
		this.match = true;
		
		return match;
	}
	
	public int compare(Student st)
	{
		int score = 0;
			
		if(st.getGender() != this.getGender())
			return score;
		
		else
		{
			score += Math.abs(40 - pref.compare(st.pref)) + Math.abs(60 - birthdate.compare(st.birthdate));
			
			return score;
		}		
	}
}