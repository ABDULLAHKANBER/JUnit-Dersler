package day10_actionsClass_Faker_FileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_FakerClass extends TestBase {
    @Test
    public void test01() throws InterruptedException {
         /* Faker kutuphanesi
            feyk degerler olusturabilecegimiz bir kutuphanedir

            buradan deger uretebilmek icin
            faker class'indan bir obje olusturmaliyiz
     */
        //1- https://www.facebook.com adresine gidelim ve cookies'i kabul edelim
        driver.get("https://www.facebook.com");
        //driver.findElement(By.xpath("//button[@*='_42ft _4jy0 _al65 _4jy3 _4jy1 selected _51sy']")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@*='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(3000);
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions= new Actions(driver);
        WebElement isimKutusu=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        //(By.xpath("//*[@name='firstname']"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();


        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("11")
                .sendKeys(Keys.TAB)
                .sendKeys("Oca")
                .sendKeys(Keys.TAB)
                .sendKeys("1979")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);
    }

}
