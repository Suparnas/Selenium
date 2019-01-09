package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class Util {
	
	   		public static final String FILE_PATH = "./src/main/resources/testData.xlsx"; // File Path
	   		public static final String SHEET_NAME = "Sheet1"; // Sheet name
	   		public static final String TABLE_NAME = "testData"; // Name of data table
	   		
	        private static XSSFSheet ExcelWSheet;
	        private static XSSFWorkbook ExcelWBook;
	        public static int RowN;
	        private static XSSFCell Cell;
	        private static XSSFRow Row;
	        private static MissingCellPolicy xRow;
	        
	        //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
	        public static void setExcelFile(String Path,String SheetName) throws Exception {
	    
	          try {
	              // Open the Excel file
	    
	    FileInputStream ExcelFile = new FileInputStream(Path);
	    
	    // Access the required test data sheet
	    ExcelWBook = new XSSFWorkbook(ExcelFile);
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);
	    RowN=  ExcelWSheet.getLastRowNum();

	    } catch (Exception e){
	    
	    throw (e);
	    
	    }
	    
	    }
	    
	        //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num
	       	    public static String getCellData(int RowNum, int ColNum) throws Exception{
	       	    	
	    
	          try{
	    
	              Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	              String CellData = Cell.getStringCellValue();
	              return CellData;
	              }catch (Exception e){
	    
	    return"";
	    
	              }
	    
	        }
	    
	        //This method is to write in the Excel cell, Row num and Col num are the parameters
	        public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception {
	    
	          try{
	    
	              Row  = ExcelWSheet.getRow(RowNum);
	    
	    Cell = Row.getCell(ColNum, xRow.RETURN_BLANK_AS_NULL);
	    if (Cell == null) {  
	    Cell = Row.createCell(ColNum);
	    Cell.setCellValue(Result);
	    
	    } else {
	    
	    Cell.setCellValue(Result);
	    
	    }
	    
	             // Constant variables Test Data path and Test Data file name
	              FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
	              ExcelWBook.write(fileOut);
	    
	              fileOut.flush();
	    
	    fileOut.close();
	    
	    }catch(Exception e){
	    
	    throw (e);
	    
	    }
	    
	    }
	    
	    }
