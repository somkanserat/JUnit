package calisma08_webTables_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Gerekli ayarlamalari yapip, ulkeler excelindeki Sayfa1’e gidin
        String dosyaYolu = "src/test/java/day11_WebTables_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1Obj = workbook.getSheet("Sayfa1");

        // 1.satirdaki 2.hucreye gidin ve yazdirin
        System.out.println(sayfa1Obj.getRow(0).getCell(1)); // Başkent (İngilizce)

        // 1.satirdaki 2.hucreyi bir string degiskene atayin
        //	 ve degerinin “Başkent (İngilizce)” oldugunu test edin

        String satir1Hucre2 = sayfa1Obj.getRow(0).getCell(1).getStringCellValue();

        String expectedHucreDegeri = "Başkent (İngilizce)";

        Assertions.assertEquals(expectedHucreDegeri,satir1Hucre2);

        // 2.satir 4.cell’in afganistan’in baskenti “Kabil” oldugunu test edin
        // Ulke sayisinin 190 oldugunu test edin
        // Fiziki olarak kullanilan satir sayisinin 191 oldugunu test edin
        // Ingilizce ismi Netherland olan ulkenin baskentinin turkce Amsterdam oldugunu test edin
        // Turkce baskent isimlerinde Ankara bulundugunu test edin


    }
}
