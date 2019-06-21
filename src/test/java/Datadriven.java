import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Datadriven {
    public static WebDriver driver;

    public ArrayList<String> getData(String testcaseName) throws IOException {
        ArrayList <String> a = new ArrayList<String>(  );


        FileInputStream fis = new FileInputStream( "C:\\Users\\3579\\Documents\\Demo Data.xlsx" );
        XSSFWorkbook wb = new XSSFWorkbook( fis );
        //Identify Testcases column by scanning the entire 1st row
        int sheets = wb.getNumberOfSheets();
        for (int i = 0;i<sheets;i++)
        {
            if(wb.getSheetName( i ).equalsIgnoreCase( "TestData" )) {
                XSSFSheet sheet = wb.getSheetAt( i );
                Iterator<Row> rows =  sheet.iterator(); //sheet is collection or rows
                Row firstRow = rows.next();
                Iterator<Cell> cell = firstRow.cellIterator(); //row is collection of cells
                int k = 0;
                int column = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if(value.getStringCellValue().equalsIgnoreCase( "testcases" )) {
                        column = k;
                    }
                    k++;
                }
                System.out.println(column);
                while(rows.hasNext()) {
                    Row r = rows.next();
                    if(r.getCell( column ).getStringCellValue().equalsIgnoreCase( testcaseName )) {
                        Iterator<Cell> cv = r.cellIterator();
                        while(cv.hasNext()) {
                            Cell c = cv.next();
                            if(c.getCellTypeEnum()== CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add( NumberToTextConverter.toText( c.getNumericCellValue() ));

                            }

                        }

                    }

                }

            }
        }
        return a;

    }


}
