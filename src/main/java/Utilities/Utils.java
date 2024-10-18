package Utilities;

import io.cucumber.datatable.DataTable;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static Utilities.Driver.getDriver;

public class Utils {

    public static String getCurrentDateTime() {

        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy"));
    }

    public static void getElementScreenshotsAs(WebElement currentElement) {
        File screenshotAs = currentElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs, new File("screenShots/" + getCurrentDateTime() + "-screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void threadSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            Logger.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("Timeout waiting for page load. (" + 20 + "s)");
            }
        }
    }

    public static boolean isFilePresentContains(String directoryPath, String fileName) {
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(fileName)) {
                    Logger.info(MessageFormat.format("{0} Dosyası İndirilebildi", fileName));
                    return true;
                } else {
                    Logger.info("Dosyalar Kontrol Edililiyor...");
                    threadSleep(5);
                    //Logger.info(MessageFormat.format("{0} Dosyası İNDİRİLEMEDİ - {1} Dizinde Dosya Yok",fileName,directoryPath));
                }
            }
        }
        return false;
    }

    public static boolean isFilePresentEquals(String directoryPath, String fileName) {
        File directory = new File(directoryPath);

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    Logger.info(MessageFormat.format("{0} Dosyası İndirilebildi", fileName));
                    return true;
                } else {
                    threadSleep(5);
                    Logger.warn(MessageFormat.format("{0} Dosyası İNDİRİLEMEDİ - {1} Dizinde Dosya Yok", fileName, directoryPath));
                }
            }
        }
        return false;
    }

    public static void fileDelete(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                Logger.info("Dosya başarıyla silindi.");

            } else {
                Logger.warn("Dosya SİLİNEMEDİ.");
            }
        } else {
            Logger.warn("Dosya BULUNAMADI");
        }
    }

    public static String excelDosyasindeKolonAdiveDegerleriniKontrolEt(String filePath, DataTable table) throws IOException {
        List<List<String>> expectedData = table.asLists(String.class);
        StringBuilder successfulMessages = new StringBuilder();
        StringBuilder failedMessages = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

            // Read the header
            Row headerRow = sheet.getRow(0);
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue().trim().toLowerCase()); // Store headers in lower case
            }

            // Validate each entry in expectedData
            for (List<String> dataRow : expectedData) {
                if (dataRow.size() < 2) {
                    return "Invalid data format. Each row must contain at least two elements.";
                }

                String columnName = dataRow.get(0).trim().toLowerCase();
                String expectedValue = dataRow.get(1).trim();

                if (!headers.contains(columnName)) {
                    failedMessages.append("Column ").append(columnName).append(" not found in Excel.\n");
                    continue;
                }

                int columnIndex = headers.indexOf(columnName);
                boolean valueFound = false;

                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Cell cell = row.getCell(columnIndex);
                        if (cell != null && cell.getStringCellValue().trim().contains(expectedValue)) {
                            valueFound = true;
                            break;
                        }
                    }
                }

                if (valueFound) {
                    successfulMessages.append("Value containing \"").append(expectedValue).append("\" found in column ").append(columnName).append(".\n");
                } else {
                    failedMessages.append("Value containing \"").append(expectedValue).append("\" NOT found in column ").append(columnName).append(".\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading Excel file.";
        }

        if (failedMessages.length() > 0) {
            return failedMessages.toString();
        } else {
            return null;
        }
    }
    // Dosya adının bir kısmını ve klasör yolunu alarak dosya adı ve uzantısını döner
    public static String findFile(String folderPath, String fileNamePart) throws FileNotFoundException {
        File folder = new File(folderPath);

        // Eğer klasör yoksa veya geçerli bir klasör değilse, exception fırlat
        if (!folder.exists() || !folder.isDirectory()) {
            throw new FileNotFoundException("Verilen klasör yolu geçerli değil: " + folderPath);
        }

        // Klasördeki dosyaları kontrol et
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                // Eğer dosya adı verilen kısmı içeriyorsa, dosya adını ve uzantısını döner
                if (file.isFile() && file.getName().contains(fileNamePart)) {
                    return file.getName();
                }
            }
        }

        // Eğer dosya bulunamazsa exception fırlat
        throw new FileNotFoundException("Dosya bulunamadı: " + fileNamePart + " klasör: " + folderPath);
    }
}


