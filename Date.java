public class Date 
{
	protected int year;
	protected int month;
	protected int day;
	
	//Birthday for the student
	public Date(int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	//Compares the two birthdays
	public int compare(Date dt)
	{
		int yearsDifferentInDays = (Math.abs(dt.getYear() - this.getYear()) * 365);
		int daysDifference = Math.abs(dayOfYear() - dt.dayOfYear());
		int totalDifference = Math.abs(yearsDifferentInDays - daysDifference);
		int monthsDifference = (totalDifference / 30);
		
		if(monthsDifference > 60)
			return 60;
		else
			return monthsDifference;
	}
	
	public int dayOfYear() 
	{
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}
}