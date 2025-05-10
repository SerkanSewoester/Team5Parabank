package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        Sheet sheet=null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // tüm satırlardaki

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {  // istenen sütun sayısı kadar
                satir.add(sheet.getRow(i).getCell(j).toString());  // bu döngü ile tüm satır okundu
            }

            tablo.add(satir);
        }

        return tablo;
    }

    public static void writeToExcel(String path, String scenarioName, String testResult) {
        File file = new File(path);
        Workbook workbook;
        Sheet sheet;

        try {
            if (!file.exists()) {
                // Eğer dosya yoksa workbook ve sheet oluştur
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("TestResult");

                // Başlık satırı ekle
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Scenario Name");
                header.createCell(1).setCellValue("Test Result");
                header.createCell(2).setCellValue("Date");

            } else {
                // Eğer dosya varsa oku
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis);
                    sheet = workbook.getSheetAt(0);
                }
            }

            // Yeni satır oluştur
            int lastRowIndex = sheet.getLastRowNum() + 1;
            Row newRow = sheet.createRow(lastRowIndex);

            // Senaryo Adı hücresi
            newRow.createCell(0).setCellValue(scenarioName);

            // Test sonucu hücresi
            Cell resultCell = newRow.createCell(1);
            resultCell.setCellValue(testResult);

            // Tarih hücresi
            newRow.createCell(2).setCellValue(LocalDateTime.now().toString());

            // Test Sonucuna göre renkli stil oluştur
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex()); // Yazı rengi beyaz
            style.setFont(font);
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            if (testResult.toLowerCase().contains("pass")) {
                style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            } else if (testResult.toLowerCase().contains("fail")) {
                style.setFillForegroundColor(IndexedColors.RED.getIndex());
            } else {
                style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
            }

            resultCell.setCellStyle(style);

            // Dosyayı kaydet
            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
            workbook.close();

            System.out.println("Test sonucu yazıldı: " + scenarioName + " - " + testResult);

        } catch (Exception e) {
            System.err.println("Hata oluştu: " + e.getMessage());
        }
    }
}
