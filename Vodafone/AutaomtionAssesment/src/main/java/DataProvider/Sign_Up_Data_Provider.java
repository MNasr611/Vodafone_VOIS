package DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
public class Sign_Up_Data_Provider {

    static XSSFWorkbook excelWorkbook = null;
    static XSSFSheet excelSheet = null;
    static XSSFRow row = null;
    static XSSFCell cell = null;
    static File f;

    @DataProvider (name = "createNewUser")
    public static Object[][] driveData() throws IOException{
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\Register.xlsx"); // Your .xlsx file name along with path
        excelWorkbook = new XSSFWorkbook(fis);
        excelSheet = excelWorkbook.getSheet("Sheet1");
        System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
                + excelSheet.getLastRowNum());
        int rowCount = (excelSheet.getLastRowNum() - excelSheet.getFirstRowNum())+1;
        int colCount = excelSheet.getRow(0).getLastCellNum();
        System.out.println("Row Count is: " + rowCount
                + " *** Column count is: " + colCount);
        Object data[][] = new Object[rowCount-1][colCount];
        for (int rNum = 2; rNum <= rowCount; rNum++) {
            for (int cNum = 0; cNum < colCount; cNum++) {
                System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
                data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); //Your sheet name
            }
            System.out.println();
        }
        return data;
    }

    public static String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
            {return "";}
            int index = excelWorkbook.getSheetIndex(sheetName);
            if (index == -1)
            {return "";}
            excelSheet = excelWorkbook.getSheetAt(index);
            row = excelSheet.getRow(rowNum - 1);
            if (row == null)
            {return "";}
            cell = row.getCell(colNum);
            if (cell == null)
            {return "";}
            if (cell.getCellType() == Cell.CELL_TYPE_STRING)
            {return cell.getStringCellValue();}
            else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
                    || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
            {return "";}
            else
            {return String.valueOf(cell.getBooleanCellValue());}
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum
                    + " does not exist in xls";
        }
    }


}
