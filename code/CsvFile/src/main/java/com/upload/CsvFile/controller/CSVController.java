package com.upload.CsvFile.controller;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.awt.PageAttributes.MediaType;
//import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload.CsvFile.helper.CSVHelper;
import com.upload.CsvFile.message.ResponseMessage;
import com.upload.CsvFile.model.Tutorial;
import com.upload.CsvFile.service.CSVService;

//import jakarta.annotation.Resource;

@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  CSVService fileService;

  @PostMapping("/uploadInDb")
  public ResponseEntity<ResponseMessage> uploadFileInDb(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (CSVHelper.hasCSVFormat(file)) {
      try {
        fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
  }

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials() {
    try {
      List<Tutorial> tutorials = fileService.getAllTutorials();

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @GetMapping("/downloadCsv")
  public ResponseEntity<InputStreamResource> getFile() throws Exception {
    String filename = "tutorials.csv";
    InputStreamResource file = new InputStreamResource(fileService.loadCsv());
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/csv"))
        .body(file);
  }
  
  @PostMapping("/uploadInCsv")
  public ResponseEntity<String> uploadDbInCsv()
  {
	  fileService.uploadInCsv();
	  return new ResponseEntity<>("Data Saved successfully", HttpStatus.OK);
	  
  }
  
  @GetMapping("/downloadExcel")
  public ResponseEntity<InputStreamResource> getFile1() {
    String filename = "tutorials.xlsx";
    InputStreamResource file = new InputStreamResource(fileService.loadExcel());

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
        .body(file);
  }

  @PostMapping("/uploadInExcel")
  public ResponseEntity<String> uploadDbInExcel()
  {
	  fileService.uploadInExcel();
	  return new ResponseEntity<>("Data Saved successfully", HttpStatus.OK);
	  
  }
}