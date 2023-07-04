package com.upload.CsvFile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upload.CsvFile.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> 
{

}
