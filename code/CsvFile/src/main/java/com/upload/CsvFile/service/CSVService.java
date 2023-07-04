package com.upload.CsvFile.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upload.CsvFile.helper.CSVHelper;
import com.upload.CsvFile.model.Tutorial;
import com.upload.CsvFile.repository.TutorialRepository;

@Service
public class CSVService {
  @Autowired
  TutorialRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
  
  public ByteArrayInputStream loadCsv() {
	    List<Tutorial> tutorials = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
	    return in;
	  }
  
  public void uploadInCsv()
  {
	  List<Tutorial> tutorials = repository.findAll();
	  CSVHelper.tutorialsToCSV1(tutorials);
  }
  
  public ByteArrayInputStream loadExcel() {
	    List<Tutorial> tutorials = repository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToExcel(tutorials);
	    return in;
	  }
  
  public void uploadInExcel() {
	    List<Tutorial> tutorials = repository.findAll();
	    CSVHelper.tutorialsToExcel1(tutorials);
	  }

}
