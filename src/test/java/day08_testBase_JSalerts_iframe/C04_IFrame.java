package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
    // 2 ) Bir metod olusturun: iframeTest
    //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin
    //    ve  konsolda yazdirin.
    //	- Text Box’a “Merhaba Dunya!” yazin.
    //	- TextBox’in altinda bulunan “Elemental Selenium”
    //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //    ve  konsolda yazdirin.
        WebElement iFrameyaziElementi=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        //findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameyaziElementi.isEnabled());
        System.out.println(iFrameyaziElementi.getText());
        //	- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        WebElement textBoxElementi=driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        Thread.sleep(3000);
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dünya");
        Thread.sleep(3000);
        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementSeleniumLinki=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSeleniumLinki.isDisplayed());
        System.out.println(elementSeleniumLinki.getText());
        /*
            iframe'e gecis yapilinca
            driver'i oradan cikis yaptirana kadar driver iframe'in icinde kalir

            driver.switchTo().parentFrame() : ic ice birden fazla iframe varsa, bir uste cikar
            driver.switchTo().defaultContent() : direk anasayfaya cikar
         */


    }




}
