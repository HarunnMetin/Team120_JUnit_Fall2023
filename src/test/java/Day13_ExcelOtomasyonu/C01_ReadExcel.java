package Day13_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTestleri() throws IOException {

        String dosyaYolu = "src/test/java/Day13_ExcelOtomasyonu/dunyada_ulkeler_listesi-1121j.xls";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Dünyada Ülkeler Listesi");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(3);
        System.out.println(cell);

        //olusturdugumuz workbok online olarak excel dosyasina erismez
        //18. satirda fileInputStream kullanarak exceldeki bilgileri aldik
        //20. satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        //fiziki excel dosyasinin bir kopyasini olusturmus olduk


    }
}
