package ObjectRepository;

import org.openqa.selenium.By;

public class HomePage_OR 
{
	public By txt_UserName()
	{
		return By.id("uname");
	}
	
	public By txt_Age()
	{
		return By.id("age");
	}
	public By txt_Salary()
	{
		return By.id("salary");
	}
	public By btn_Reset()
	{
		return By.xpath("//button[text()='RESET']");
	}
	public By btn_Add()
	{
		return By.xpath("//input[@value='Add']");
	}
}