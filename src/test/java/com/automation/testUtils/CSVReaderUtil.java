package com.automation.testUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.automation.utility.reportUtils.LogUtil;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;


public class CSVReaderUtil {

    public static Iterator<Object[]> getTestData(String filePath) throws CsvException {
        // list of iterator objects, row iterator objects
        List<Object[]> testData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> dataRows = reader.readAll();
            // removing the header/title cell values
            dataRows.remove(0);
            for (String[] row : dataRows) {
                String column1Cell = row[0];
                String column2Cell = row[1];
                String column3Cell = row[2];
//                Object[] dataRow = new Object[3];
//                dataRow[0] = column1Cell;
//                dataRow[1] = column2Cell;
//                dataRow[2] = column3Cell;
//                testData.add(dataRow);
                // Uncomment lines above OR write one single line below. Perform anonymous array initialization.
                testData.add(new Object[]{column1Cell, column2Cell, column3Cell}); // Extract 'id', 'name' and 'job'
            }
        } catch (IOException | CsvException e) {
            LogUtil.logInfo(e.getMessage());
        }
        return testData.iterator();
    }
}
