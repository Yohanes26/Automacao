package cucumber;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

	private WebDriver driver;
	public Json nw = new Json("/src/test/java/cucumber/dados.json");
	
	@Before("@start")
	public void setUp() throws IOException, ParseException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/yohan/Desktop/WorkSpace/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^que eu estou na pagina inicial da porto seguros$")
	public void abrirPaginaInicial() throws Throwable {
		driver.navigate().to("https://www.portoseguro.com.br");
	}

	@When("^eu clicar no link faca uma cotacao$")
	public void clicarLinkFacaUmaCotacao() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/nav/div[3]/a"))
				.click();
	}

	@Then("^deverei validar se estou na pagina de iniciar cotacao$")
	public void validarSeEstouNaPaginaCotacao() throws Throwable {
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL,
				"https://www.portoseguro.com.br/calcule-e-contrate");
	}

	@When("^informar um nome Válido$")
	public void informarNomeValido() throws Throwable {
		nw.LerJson("/src/test/java/cucumber/dados.json");

		driver.findElement(By.name("proponente.nomeProponente")).sendKeys(
				nw.getNome());
	}

	@And("^informar um cpf Válido$")
	public void informarCpfValido() throws Throwable {
		driver.findElement(By.name("numeroCpf")).sendKeys(nw.getCpf());
	}

	@And("^informar um email Válido$")
	public void informarEmailValido() throws IOException, ParseException {
		driver.findElement(By.name("proponente.descricaoEmailProponente"))
				.sendKeys(nw.getEmail());

	}

}