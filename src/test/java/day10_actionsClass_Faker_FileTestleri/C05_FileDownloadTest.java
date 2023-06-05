package day10_actionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileDownloadTest extends TestBase {
    @Test
    public void test01() throws InterruptedException {


    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    driver.get("https://the-internet.herokuapp.com/download");
    //3. logo.png dosyasını indirelim
        WebElement fotoElementi=driver.findElement(By.linkText("foto.png"));
        fotoElementi.click();
        Thread.sleep(3000);
    //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:/Users/pc/Downloads/foto.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // Dosyayi Downloads klasorune indirecek


    }
}
