package day09_switchingWindow_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWindows extends TestBase {
     /*
        driver.switchTo().newWindow() kullanarak actigimiz
        window'a driver otomatik olarak gecer
        ANCAKKKKK....
        biz newWindow() method'unu kullanmadan
        bir link tikladigimizda yeni window aciliyorsa
        driver eski window'da kalir
        Yeni window'a driver'i gecirebilmek icin
        yeni window'un WindowHandleDegerine ihtiyacimiz vardir.
     */
    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD= driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın
        WebElement openingWindowYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi=openingWindowYaziElementi.getText();
        Assert.assertEquals(actualYazi,expectedYazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        WebElement clickButonu=driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickButonu.click();
        // 38.satir itibariyle yeni window acildi
        // artik 2 window var

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> whdegerleriSet=driver.getWindowHandles();
        String ikinciWindowWHD="";

        for (String eachWhd:whdegerleriSet
             ) {
            if (!eachWhd.equals(ilkSayfaWHD)){
                ikinciWindowWHD=eachWhd;
            }
        }
        // Artik acilan 2.window'un windowHandleDegerine sahibiz
        driver.switchTo().window(ikinciWindowWHD);

        String expectedIcerik="New Window";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedIcerik,actualTitle);

        Thread.sleep(1000);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowYaziElementi=driver.findElement(By.tagName("h3"));
        expectedIcerik="New Window";
        String actualText=newWindowYaziElementi.getText();
        Assert.assertEquals(expectedIcerik,actualText);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWHD);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
