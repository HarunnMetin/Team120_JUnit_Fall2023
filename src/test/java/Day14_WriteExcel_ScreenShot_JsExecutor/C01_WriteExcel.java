package Day14_WriteExcel_ScreenShot_JsExecutor;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void excelTest() throws IOException {

        //3) Adimlari takip ederek Sayfa1’deki1.satira kadar gidelim
        String dosyaUzantisi = "src/test/java/Day14_WriteExcel_ScreenShot_JsExecutor/Proje_Yapilabilir_Tum_Ulkeler_Listesi.xls";
        FileInputStream fis = new FileInputStream(dosyaUzantisi);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        //4) 4.hucreye yeni bir cell olusturalim
        sayfa1.getRow(0).createCell(3);

        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sayfa1.getRow(0).getCell(3).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sayfa1.getRow(1).createCell(3).setCellValue("350000");
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sayfa1.getRow(9).createCell(3).setCellValue("1500000");
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sayfa1.getRow(14).createCell(3).setCellValue("556000");
        //9) Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaUzantisi);
        workbook.write(fos);
        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
    }
}
