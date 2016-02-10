package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelFileReaderConfig {

    @DataProvider
    public static Iterator<Object[]> getExcelData(Method callingMethod) throws IOException {
        FileInputStream sourceFile = null;
        Workbook workbook = null;
        ExcelFileReaderConfig configKey = new ExcelFileReaderConfig();
        ClassLoader loader = configKey.getClass().getClassLoader();
        try {
            sourceFile = new FileInputStream( new File(loader.getResource("testData/TestData.xlsx").getFile()) );
            workbook = WorkbookFactory.create(sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(callingMethod.getName());
        List<Object[]> jParamObj = new ArrayList<>();
        List<String> configKeys = new ArrayList<String>();

        for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); ) {
            Row row = rowsIT.next();
            sheet.getRow(0);
            Iterator<Cell> headerIterator = row.cellIterator();

            // Config key extraction
            if ( row.getRowNum() == 0 ) {
                while ( headerIterator.hasNext() ) {
                    Cell headerCell = headerIterator.next();
                    configKeys.add((String) getCellValue(headerCell) );
                }
            } else {
                for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); ){
                    Map<String, String> JcellObj = new HashMap<>();
                    for (String getKey : configKeys) {
                        if (cellsIT.hasNext()){
                            Cell cell = cellsIT.next();
//                            if (String.valueOf(getCellValue(cell)).equalsIgnoreCase("TRUE")){
                        //    JcellObj.put( getKey, String.valueOf(getCellValue(cell)) );
                            	JcellObj.put( getKey, getCellValue(cell) );
//                            } else {
//                            	continue;
//                            }
                        }
                    }
                    jParamObj.add(new Object[] {JcellObj});
                }
            }
        }
        workbook.close();
        return jParamObj.iterator();
    }

    private static String getCellValue(Cell cell) {
    	DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
    	
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type
            case Cell.CELL_TYPE_BOOLEAN:
                return formatter.formatCellValue(cell);
            case Cell.CELL_TYPE_NUMERIC:
                return formatter.formatCellValue(cell);
            case Cell.CELL_TYPE_BLANK:
                return "";
            default:
                return "";

        }

    }
}
