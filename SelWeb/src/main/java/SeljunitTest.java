import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeljunitTest {

	
	static WebDriver wd=null;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://localhost:8088/SelWeb/index.html");
	}
	
	
	public static String seleCode(String name,String email) {
		wd.findElement(By.name("user")).sendKeys(name);
		wd.findElement(By.name("email")).sendKeys(email);
		wd.findElement(By.name("submit")).submit();
		return wd.findElement(By.name("h1")).getText();
	}
	
	
	
	@Test
	public void test1() {
		
		String actualresult=seleCode("suban","suban@c.c");
		String expectedresult="Sucessful insertion";
		assertEquals(expectedresult,actualresult);
	}

	
	@Test
	public void test2() {
		String actualresult=seleCode("smom","smom@c.c");
		String expectedresult="Sucessful insertion";
		assertEquals(expectedresult,actualresult);
	}
	
	@After
	public void closebroswer() {
		wd.close();
	}
	
	}
