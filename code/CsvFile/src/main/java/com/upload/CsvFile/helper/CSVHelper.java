package com.upload.CsvFile.helper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.upload.CsvFile.model.Tutorial;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };
  public static String TYPE1 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String SHEET = "Tutorials";

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<Tutorial> csvToTutorials(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Tutorial> tutorials = new ArrayList<Tutorial>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        Tutorial tutorial = new Tutorial(
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("Title"),
              csvRecord.get("Description"),
              Boolean.parseBoolean(csvRecord.get("Published"))
            );

        tutorials.add(tutorial);
      }

      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToCSV(List<Tutorial> tutorials) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Tutorial tutorial : tutorials) {
	        List<String> data = Arrays.asList(
	              String.valueOf(tutorial.getId()),
	              tutorial.getTitle(),
	              tutorial.getDescription(),
	              String.valueOf(tutorial.isPublished())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
  
  public static void tutorialsToCSV1(List<Tutorial> tutorials) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    File f = new File("C:\\Users\\jagdi\\OneDrive\\Desktop\\mj\\mj.csv");
	    try (FileOutputStream out = new FileOutputStream(f);
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	    	List<String> header = new ArrayList<>();
	    	header.add("id");
	    	header.add("title");
	    	header.add("description");
	    	header.add("published");
	    	csvPrinter.printRecord(header);
	      for (Tutorial tutorial : tutorials) {
	        List<String> data = Arrays.asList(
	              String.valueOf(tutorial.getId()),
	              tutorial.getTitle(),
	              tutorial.getDescription(),
	              String.valueOf(tutorial.isPublished())
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
  
  public static ByteArrayInputStream tutorialsToExcel(List<Tutorial> tutorials) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (Tutorial tutorial : tutorials) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(tutorial.getId());
	        row.createCell(1).setCellValue(tutorial.getTitle());
	        row.createCell(2).setCellValue(tutorial.getDescription());
	        row.createCell(3).setCellValue(tutorial.isPublished());
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
  
  public static void tutorialsToExcel1(List<Tutorial> tutorials) {

	  	File f = new File("C:/Users/jagdi/OneDrive/Desktop/mj/tutorials.xls");
	    try (Workbook workbook = new XSSFWorkbook(); FileOutputStream out = new FileOutputStream(f);) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (Tutorial tutorial : tutorials) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(tutorial.getId());
	        row.createCell(1).setCellValue(tutorial.getTitle());
	        row.createCell(2).setCellValue(tutorial.getDescription());
	        row.createCell(3).setCellValue(tutorial.isPublished());
	      }
	      
	      workbook.write(out);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
}
