package practice;

import org.junit.*;

public class P01 {

    /*
    @BeforeClass  // sadece 1 kere çalısıyor
    @Before // her testten çnce 1 kere çalısır
    @AfterClass // tüm testlerden sonra 1 kere çalısır
    @After //her testten sonra 1 kere çalısır.
    @Test // yapacacağımız test kodlarının yer aldığı kısım
    */
    @Test
    public void Ahmet(){
        System.out.println("Ahmet");
    }

    @Test
    public void Berk(){
        System.out.println("Berk");
    }

    @Test
    public void Cemil(){
        System.out.println("Cemil");
    }


}
