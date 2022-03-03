import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelTest 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\DELL\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.manage().window().maximize();
wd.get("http://localhost:8088/SelWeb/index.html");
String expectedname="shahira";
String expectedemail="ss@g.c";
wd.findElement(By.name("user")).sendKeys(expectedname);
wd.findElement(By.name("email")).sendKeys(expectedemail);
wd.findElement(By.name("submit")).submit();
String expected="Sucessful insertion";
String actual=wd.findElement(By.name("h1")).getText();

String sql="select * from Register";
Connection con=DbUtil.dbConnection();
PreparedStatement ps=con.prepareStatement(sql);
ResultSet rs=ps.executeQuery();
String actualname="";
String actualemail="";
while(rs.next()) {
	actualname=rs.getString(1);
	actualemail=rs.getString(2);
}

if(actual.equals(expected)) {
	System.out.println("the url test case of insertion passed "+expectedname+expectedemail+"as the data");
}
if(actualname.equals(expectedname)&&actualemail.equals(expectedemail)) {
	System.out.println("db level test case is passed for "+expectedname+expectedemail+"as the data");
}

wd.close();

}
}
