package com.tdm.tdm.util;

import com.tdm.tdm.model.TestData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface WhiteLabelCreation {
    static String createWhiteLabel(List<Optional<TestData>> testDataList) throws IOException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream("D:/Bond/Whitelabel/MCIWL.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        int NextRowNum = sheet.getPhysicalNumberOfRows();
        int colum = sheet.getRow(0).getPhysicalNumberOfCells();
        XSSFRow row = (XSSFRow) sheet.createRow(NextRowNum);
//            Row row = sheet.createRow(2);

        for (int col = 0; col < colum; col++) {
            row.createCell(col);
//                Cell cell = row.createCell(i);
        }
        String testSetId = testDataList.stream()
                .map(optionalTestData -> optionalTestData.map(TestData::getTestSetId).orElse(null))
                .collect(Collectors.toList()).toString().replaceAll("\\[|\\]", "");
        String scenario = testDataList.stream()
                .map(optionalTestData -> optionalTestData.map(TestData::getScenario).orElse(null))
                .collect(Collectors.toList()).toString().replaceAll("\\[|\\]", "");
        String assset = testDataList.stream()
                .map(optionalTestData -> optionalTestData.map(TestData::getAssset).orElse(null))
                .collect(Collectors.toList()).toString().replaceAll("\\[|\\]", "");
        String data_Source = testDataList.stream()
                .map(optionalTestData -> optionalTestData.map(TestData::getData_Source).orElse(null))
                .collect(Collectors.toList()).toString().replaceAll("\\[|\\]", "");

        row.getCell(0).setCellValue(testSetId);
        Thread.sleep(1000);
        row.getCell(1).setCellValue(scenario);
        Thread.sleep(1000);
        row.getCell(2).setCellValue(assset);
        Thread.sleep(1000);
        row.getCell(2).setCellValue(data_Source);
        Thread.sleep(1000);


        try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
            workbook.write(fileOut);

            System.out.println("Excel file with rows created successfully!");
            return "Excel file created successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Excel file not created successfully!";
        }


    }
}
