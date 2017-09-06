package com.phillips.oit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.phillips.oit.bean.OITBean;

public class OITResourseUtil {
	static final String DIR_PATH="d:/rid/"; 
	static final String FILE_NAME="/registrationId.txt";
	static final String EXCEL_FILE_NAME="/2017 Week12.xlsx";
public static File getRegFilePath(){
	File dir=new File(DIR_PATH);
	if(!dir.exists()){
		dir.mkdirs();
	}
	String filePath=dir.getAbsolutePath()+FILE_NAME;
	File file=new File(filePath);
	if(!file.exists()){
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return file;
}
public static String readExcelFile(String fileName, InputStream fileInputStream){
	Workbook workbook = null;
	try {
		workbook = WorkbookFactory.create( fileInputStream );
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt( 0 );

	    // Start constructing JSON.
	    JSONObject json = new JSONObject();

	    // Iterate through the rows.
	    JSONArray rows = new JSONArray();
	    for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
	    {
	    	OITBean oit=new OITBean();
	    	int cellCount = 0;
	        Row row = rowsIT.next();
	        JSONObject jRow = new JSONObject();
	        row.getCell(0).getCellTypeEnum().equals(CellType.NUMERIC);
	        // Iterate through the cells.
	        JSONArray cells = new JSONArray();
	        for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext() && cellCount < 20; )
	        {
	        	cellCount++;
	            Cell cell = cellsIT.next();
	            System.out.println(cell+" Cell type" +cell.getCellTypeEnum());
	            switch(cell.getCellTypeEnum()){
	            case STRING:
	            	cells.put( cell.getRichStringCellValue() );
	            	break;
	            case NUMERIC:
	            	cells.put( cell.getNumericCellValue() );
	            	break;
	            case BOOLEAN:
	            	cells.put(cell.getNumericCellValue());
	            	break;
					case FORMULA:
	            	switch(cell.getCachedFormulaResultTypeEnum()) {
	                case NUMERIC:
	                    System.out.println("Last evaluated as: " + cell.getNumericCellValue());
	                    cells.put( cell.getNumericCellValue() );
	                    break;
	                case STRING:
	                    System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
	                    cells.put( cell.getRichStringCellValue() );
	                    break;
					case BLANK:
						break;
					case BOOLEAN:
						break;
					case ERROR:
						break;
					case FORMULA:
						break;
					case _NONE:
						break;
					default:
						break;
	            }
	            	break;
	            case BLANK:
	            	cells.put("");
	            	break;
				default:
					break;
	            }
	            switch(cellCount){
	            case 0:
	            	oit.setsNo(sNo);
	            	break;
	            case 1:
	            break;
	            case 2:
		            break;
	            case 3:
		            break;
	            case 4:
		            break;
	            
	            }
	        }
	        jRow.put( "cell", cells );
	        rows.put( jRow );
	    }

	    // Create the JSON.
	    json.put( "rows", rows );

	// Get the JSON text.
	    System.out.println("JSON "+json.toString());
	} catch (EncryptedDocumentException | InvalidFormatException | IOException | JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "OK";
};

public OITBean populateBean(OITBean oit, Object o){
	
	return oit;
}
public static String getExcelData() throws JSONException{
	File dir=new File(DIR_PATH);
	if(!dir.exists()){
		dir.mkdirs();
	}
	String filePath=dir.getAbsolutePath()+EXCEL_FILE_NAME;
	File file=new File(filePath);
	if(!file.exists()){
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	FileInputStream inp = null;
	try {
		inp = new FileInputStream( file );
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Workbook workbook = null;
	try {
		workbook = WorkbookFactory.create( inp );
	} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// Get the first Sheet.
	org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt( 0 );

	    // Start constructing JSON.
	    JSONObject json = new JSONObject();

	    // Iterate through the rows.
	    JSONArray rows = new JSONArray();
	    for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
	    {
	        Row row = rowsIT.next();
	        JSONObject jRow = new JSONObject();
	        int cellCount = 0; 
	        // Iterate through the cells.
	        JSONArray cells = new JSONArray();
	        for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext() && cellCount < 19; )
	        {
	        	cellCount++;
	            Cell cell = cellsIT.next();
	            System.out.println(cell+" Cell type" +cell.getCellTypeEnum());
	            switch(cell.getCellTypeEnum()){
	            case STRING:
	            	cells.put( cell.getRichStringCellValue() );
	            	break;
	            case NUMERIC:
	            	cells.put( cell.getNumericCellValue());
	            	break;
	            case BOOLEAN:
	            	cells.put(cell.getNumericCellValue() );
	            	break;
	            case FORMULA:
	            	switch(cell.getCachedFormulaResultTypeEnum()) {
	                case NUMERIC:
	                    System.out.println("Last evaluated as: " + cell.getNumericCellValue());
	                    cells.put( cell.getNumericCellValue() );
	                    break;
	                case STRING:
	                    System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
	                    cells.put( cell.getRichStringCellValue() );
	                    break;
					default:
						break;
	            }
	            	break;
	            case BLANK:
	            	cells.put("");
	            	break;
				default:
					break;
	            }
	            
	        }
	        jRow.put( "cell", cells );
	        rows.put( jRow );
	    }

	    // Create the JSON.
	    json.put( "rows", rows );

	// Get the JSON text.
	    System.out.println("JSON "+json.toString());
	return json.toString();
}
public static void main(String[] args) throws JSONException {
	getExcelData();
}
}
