package day13_excelOtomasyonu_ScreenShoot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
        //
        //
        String dosyaYolu=System.getProperty("user.dir")+"/src/test/java/day12/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String actualIsim= workbook
                .getSheet("Sayfa 1")
                .getRow(15)
                .getCell(2)
                .toString();
        String expectedIsim="Barbados";
        Assert.assertEquals(expectedIsim,actualIsim);
        //
        //
        int sonSatirIndexi=workbook.getSheet("Sayfa 1").getLastRowNum();


        System.out.println(sonSatirIndexi);
        boolean beninVarmi = false;

        for (int i =1; i<= sonSatirIndexi; i++){
            actualIsim = workbook
                    .getSheet("Sayfa 1")
                    .getRow(i)
                    .getCell(0)
                    .toString();

            if (actualIsim.equalsIgnoreCase("Benin")){
                 beninVarmi = true;
                break;
            }
        }
        Assert.assertTrue(beninVarmi);


    }
}
