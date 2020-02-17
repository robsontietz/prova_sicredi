package tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Desafio2 {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//PR�-CONDI��O EXECUTE TODOS OS PASSOS DO DESAFIO 1
		System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		//1. Acesse a p�gina https://www.grocerycrud.com/demo/bootstrap_theme
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
        Thread.sleep(5000);   
        driver.manage().window().maximize();

        //2. Mude o valor da combo Select version para "Bootstrap V4 Theme"
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]")));
		select.selectByIndex(1);		
		//3. Clique no bot�o Add Customer		
		WebElement addcustomer = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a"));
		addcustomer.click();
		Thread.sleep(5000);
		//4. Preencha os campos do formul�rio com as seguintes informa��es:		
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
		//5. Clique no bot�o Save
		WebElement save = driver.findElement(By.xpath("//*[@id=\"form-button-save\"]"));
		save.click();
		Thread.sleep(5000);
		//6. Validar a mensagem "Your data has been successfully stored into the database." atrav�s de uma asser��o
		WebElement resultado = driver.findElement(By.xpath("//*[@id=\"crudForm\"]/div[14]"));
		assertTrue(resultado.getText().contentEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list"));
		Thread.sleep(5000);

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException  {		
		//INICIO DO DESAFIO 2

		//1. Clique no link Go back to list
		WebElement goback = driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]"));
		goback.click();		
		Thread.sleep(5000);

		//2. Clique no �cone da lupa (pesquisa) e digite o conte�do do Name (Teste Sicredi)
		WebElement lupa = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]"));
		lupa.click();
		Thread.sleep(5000);
		WebElement creditlimit1 = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input"));
		creditlimit1.sendKeys("Teste Sicredi");		
		Thread.sleep(5000);
		WebElement lupa2 = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/i[1]"));
		lupa2.click();
		Thread.sleep(5000);
		//3. Clicar no checkbox abaixo da palavra Actions
		WebElement check = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/tbody/tr[1]/td[1]/input"));
		check.click();		
		Thread.sleep(10000);
		//4. Clicar no bot�o Delete
		WebElement delete = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]"));
		delete.click();		
		Thread.sleep(5000);
		//5. Validar o texto "Are you sure that you want to delete this 1 item?" atrav�s de uma asser��o para a popup que ser� apresentada
		WebElement resultado1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]"));
		assertTrue(resultado1.getText().contentEquals("Are you sure that you want to delete this 1 item?"));
		Thread.sleep(5000);
		//6. Clicar no bot�o Delete da popup
		WebElement deleteconfirm = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]"));
		deleteconfirm.click();					
		Thread.sleep(5000);
		//7. Aparecer� uma mensagem dentro de um box verde na parte superior direito da tela. 
		//Adicione uma asser��o na mensagem "Your data has been successfully deleted from 
		//the database."
		WebElement deleteconfirm1 = driver.findElement(By.xpath("/html/body/div[3]/span[3]/p"));
		deleteconfirm1.click();			
	}

}
