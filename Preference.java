public class Preference 
{
	protected int quietTime;
	protected int music;
	protected int reading;
	protected int chatting;
	
	public Preference(int quietTime, int music, int reading, int chatting)
	{
		this.quietTime = quietTime;
		this.music = music;
		this.reading = reading;
		this.chatting = chatting;
	}
	
	public int getQuietTime()
	{
		return quietTime;
	}
	
	public int getMusic()
	{
		return music;
	}
	
	public int getReading()
	{
		return reading;
	}
	
	public int getChatting()
	{
		return chatting;
	}
	
	public int compare(Preference pref)
	{
		int prefTotal = (Math.abs(this.quietTime - pref.getQuietTime()) + Math.abs(this.music - pref.getMusic()) 
			+ Math.abs(this.reading - pref.getReading()) + Math.abs(this.chatting - pref.getChatting()));
		
		return prefTotal;
	}
}