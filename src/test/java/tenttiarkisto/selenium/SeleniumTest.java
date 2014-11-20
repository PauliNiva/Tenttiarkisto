/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenttiarkisto.selenium;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTest {
    
    private WebDriver driver;

    @Before
    public void setUp() {
        // käynnistää Spring-sovelluksen -- JSP-kirjastojen lataaminen
        // tällä hetkellä kuitenkin buginen, joten ajetaan testit 
        // manuaalisesti käynnistettyyn sovellukseen

        // SpringApplication.run(Application.class);
        this.driver = new HtmlUnitDriver();
    }

        @Test
    public void etusivuOnOlemassa() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja, esim.
        // http://localhost:8080/signup )
        driver.get("http://localhost:8080/kurssit");
        
        assertTrue(driver.getPageSource().contains("Tenttiarkisto"));
    }
    
    @Test
    public void lomakkeenTiedotLahetetaanOikein() {
        // haetaan haluttu osoite (aiemmin määritelty muuttuja, esim.
        // http://localhost:8080/signup )
        driver.get("http://localhost:8080/kurssit");
        
        Select kurssiselect = new Select(driver.findElement(By.name("kurssi")));
        kurssiselect.deselectAll();
        kurssiselect.selectByVisibleText("Ohjelmoinnin perusteet");   
        
        Select tyyppiselect = new Select(driver.findElement(By.name("tyyppi")));
        tyyppiselect.deselectAll();
        tyyppiselect.selectByVisibleText("Kurssikoe"); 
        
        Select kieliselect = new Select(driver.findElement(By.name("kieli")));
        kieliselect.deselectAll();
        kieliselect.selectByVisibleText("Englanti"); 

        // haetaan kenttä nimeltä tunnus
        WebElement kurssi = kurssiselect.getFirstSelectedOption();
        WebElement pvm = driver.findElement(By.name("pvm"));
        WebElement tyyppi = tyyppiselect.getFirstSelectedOption();
        WebElement kieli = kieliselect.getFirstSelectedOption();
        WebElement pitaja = driver.findElement(By.name("pitaja"));

        // asetetaan kenttään arvo
        pvm.sendKeys("11.11.2000");
        pitaja.sendKeys("Bob");
        
        // lähetetään lomake
        kurssi.submit();
        pvm.submit();
        tyyppi.submit();
        kieli.submit();
        pitaja.submit();
               
        assertTrue(driver.getPageSource().contains("Ohjelmoinnin perusteet"));
        assertTrue(driver.getPageSource().contains("11"));
        assertTrue(driver.getPageSource().contains("Kurssikoe"));
        assertTrue(driver.getPageSource().contains("Englanti"));
        assertTrue(driver.getPageSource().contains("Bob"));
    }
}
