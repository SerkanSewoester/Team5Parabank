package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ExcelUtility {

    private static final Logger logger = LoggerFactory.getLogger(ExcelUtility.class);

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        Sheet sheet = null;

        try (FileInputStream inputStream = new FileInputStream(path)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
            logger.info("Excel dosyası başarıyla okundu: {} | Sayfa: {}", path, sheetName);
        } catch (Exception ex) {
            logger.error("Excel verileri okunurken hata oluştu. Dosya: {}, Sayfa: {} | Hata: {}", path, sheetName, ex.getMessage());
            return tablo;
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {
                Cell cell = sheet.getRow(i).getCell(j);
                satir.add(cell != null ? cell.toString() : "");
            }
            tablo.add(satir);
        }

        logger.debug("Toplam {} satır veri başarıyla okundu.", tablo.size());
        return tablo;
    }

    public static void writeToExcel(String path, String scenarioName, String testResult) {
        File file = new File(path);
        Workbook workbook;
        Sheet sheet;

        try {
            if (!file.exists()) {
                logger.warn("Excel dosyası bulunamadı. Yeni dosya oluşturuluyor: {}", path);
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("TestResult");

                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Scenario Name");
                header.createCell(1).setCellValue("Test Result");
                header.createCell(2).setCellValue("Date");
            } else {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = WorkbookFactory.create(fis);
                    sheet = workbook.getSheetAt(0);
                    logger.info("Mevcut Excel dosyası açıldı: {}", path);
                }
            }

            int lastRowIndex = sheet.getLastRowNum() + 1;
            Row newRow = sheet.createRow(lastRowIndex);
            newRow.createCell(0).setCellValue(scenarioName);
            Cell resultCell = newRow.createCell(1);
            resultCell.setCellValue(testResult);
            newRow.createCell(2).setCellValue(LocalDateTime.now().toString());


            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
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

            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }

            workbook.close();
            logger.info("Test sonucu başarıyla Excel dosyasına yazıldı: {} | Sonuç: {}", scenarioName, testResult);

        } catch (Exception e) {
            logger.error("Excel'e yazma işlemi sırasında hata oluştu. Dosya: {} | Hata: {}", path, e.getMessage());
        }
    }
}
