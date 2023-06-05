package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    /*
    Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    a. Verilen web sayfasına gidin.
    https://facebook.com
b. Cookies’i kabul edin
c. Create an account buton’una basin
d. Radio button elementlerini locate edin ve size uygun olani secin
e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
     */
    WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        driver.close();
    }
       // @Test
    @Test
            public void radioButtonTest() throws InterruptedException {
        //  a. Verilen web sayfasına gidin.
        //       https://facebook.com
        driver.get("https://facebook.com");
        //  b. Cookies’i kabul edin
        //driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
        //driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
        //  c. Create an account buton’una basin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //driver.findElement(By.xpath("(//*[@id=\"u_0_0_fj\"])")).click();
        //driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        //  d. Radio button elementlerini locate edin ve size uygun olani secin
        Thread.sleep(3000);
        WebElement maleButtonElementi=driver.findElement(By.xpath("(//*[@class='_8esa'])[2]"));
        //------------------//*[@id='u_d_5_QU']
        Thread.sleep(3000);
        WebElement femaleButtonElementi=driver.findElement(By.xpath("(//*[@class='_8esa'])[1]"));
        Thread.sleep(3000);
        WebElement customButtonElementi=driver.findElement(By.xpath("(//*[@class='_8esa'])[3]"));

        maleButtonElementi.click();

        //  e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(maleButtonElementi.isSelected());
        Assert.assertFalse(femaleButtonElementi.isSelected());
        Assert.assertFalse(customButtonElementi.isSelected());
    }


}
