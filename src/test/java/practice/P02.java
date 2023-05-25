package practice;

import org.junit.*;

public class P02 {
     @BeforeClass
    public static void beforeClass(){
         System.out.println("Before Class Çalıştırılacak");
         System.out.println("-----------------------------");
     }
     @AfterClass
    public static void afterClass(){
         System.out.println("After Class Çalıştı. Testlerin çalışması bitti.");
     }
     @Before
    public void before(){
         System.out.println("Before. Yeni bir test çalıştırlıyor");
     }
     @After
    public void after(){
         System.out.println("After. Çalıstırılan test sonlandırlıyor");
         System.out.println("---------------------------------");
     }
     @Test
    public void test01(){
         System.out.println("Test Case 01 Çalıştırıldı");
     }
    @Test
    public void test02(){
        System.out.println("Test Case 02 Çalıştırıldı");
    }
    @Test
    public void test03(){
        System.out.println("Test Case 03 Çalıştırıldı");
    }

}
