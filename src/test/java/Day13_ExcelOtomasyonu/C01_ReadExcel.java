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



        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(2).getCell(1));

        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String birinciSatirIkinciHucre = sheet.getRow(3).getCell(1).toString();
        System.out.println(birinciSatirIkinciHucre);

        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim

        //- Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum());

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows());

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    }
}
