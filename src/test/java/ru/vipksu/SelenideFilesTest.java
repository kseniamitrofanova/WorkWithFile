package ru.vipksu;

import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import java.util.List;

public class SelenideFilesTest {
    private ClassLoader cl = SelenideFilesTest.class.getClassLoader();

    @Test
    void zipFilePdfTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("example.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("pdffile.pdf")) {
                    PDF pdf = new PDF(zis);
                    Assertions.assertEquals(pdf.numberOfPages, 1);
                    System.out.println(pdf.creator);
                }
            }
        }
    }
    @Test
    void zipFileXlsxTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("example.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("telefonnyy-spravochnik.xlsx")) {
                    XLS xls = new XLS(zis);
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(10).getCell(4).getStringCellValue(), "222-645-2235");
                    break;
                }
            }
        }
    }

    @Test
    void zipFileCsvTest() throws Exception {
        try (ZipInputStream zis = new ZipInputStream(
                cl.getResourceAsStream("example.zip"))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals("csvfile.csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> data = reader.readAll();
                    Assertions.assertEquals(2, data.size());
                    Assertions.assertArrayEquals(
                            new String[] {"Selenide", "https://selenide.org"},
                            data.get(0)
                    );
                    Assertions.assertArrayEquals(
                            new String[] {"JUnit 5","https://junit.org"},
                            data.get(1)
                    );
                }
            }
        }
    }
}
