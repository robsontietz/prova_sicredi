package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Desafio1 {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException  {
		//1. Acesse a página https://www.grocerycrud.com/demo/bootstrap_theme
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
        Thread.sleep(5000);   
        driver.manage().window().maximize();
		//2. Mude o valor da combo Select version para "Bootstrap V4 Theme"
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]")));
		select.selectByIndex(1);
		//3. Clique no botão Add Customer		
		WebElement addcustomer = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a"));
		addcustomer.click();
		Thread.sleep(5000);
		//4. Preencha os campos do formulário com as seguintes informações:		
		//4.1 Name: Teste Sicredi
		WebElement name = driver.findElement(By.xpath("//*[@id=\"field-customerName\"]"));
		name.sendKeys("Teste Sicredi");					        
		//4.2 Last name: Teste
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\"field-contactLastName\"]"));
		lastname.sendKeys("Teste");	
		//4.3 ContactFirstName: seu nome
		WebElement contactfirstname = driver.findElement(By.xpath("//*[@id=\"field-contactFirstName\"]"));
		contactfirstname.sendKeys("seu nome");	
		//4.4 Phone: 51 9999-9999
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"field-phone\"]"));
		phone.sendKeys("51 9999-9999");	
		//4.5 AddressLine1: Av Assis Brasil, 3970
		WebElement addressline1 = driver.findElement(By.xpath("//*[@id=\"field-addressLine1\"]"));
		addressline1.sendKeys("Av Assis Brasil, 3970");	
		//4.6 AddressLine2: Torre D
		WebElement addressline2 = driver.findElement(By.xpath("//*[@id=\"field-addressLine2\"]"));
		addressline2.sendKeys("Torre D");	
		//4.7 City: Porto Alegre
		WebElement city = driver.findElement(By.xpath("//*[@id=\"field-city\"]"));
		city.sendKeys("Porto Alegre");	
		//4.8 State: RS
		WebElement state = driver.findElement(By.xpath("//*[@id=\"field-state\"]"));
		state.sendKeys("RS");	
		//4.9 PostalCode: 91000-000
		WebElement postalcode = driver.findElement(By.xpath("//*[@id=\"field-postalCode\"]"));
		postalcode.sendKeys("91000-000");	
		//4.10 Country: Brasil
		WebElement country = driver.findElement(By.xpath("//*[@id=\"field-country\"]"));
		country.sendKeys("Brasil");	
		//4.11 from Employeer: Fixter		
		WebElement employeerchoose = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span"));
		employeerchoose.click();
		Thread.sleep(1000);
		WebElement employeerchoose2 = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
		employeerchoose2.sendKeys("Fixter");
		Thread.sleep(1000);
		WebElement employeerchoose3 = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/ul/li[1]"));
		employeerchoose3.click();
		//select.selectByIndex(0);
		//4.12 CreditLimit: 200	
		WebElement creditlimit = driver.findElement(By.xpath("//*[@id=\"field-creditLimit\"]"));
		creditlimit.sendKeys("200");	
		//5. Clique no botão Save
		WebElement save = driver.findElement(By.xpath("//*[@id=\"form-button-save\"]"));
		save.click();
		Thread.sleep(5000);
		//6. Validar a mensagem "Your data has been successfully stored into the database." através de uma asserção
		WebElement resultado = driver.findElement(By.xpath("//*[@id=\"crudForm\"]/div[14]"));
		assertTrue(resultado.getText().contentEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list"));
		Thread.sleep(5000);
	}

}
