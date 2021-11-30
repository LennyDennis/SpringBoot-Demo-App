package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchool(){
        return schoolRepository.findAll();
    }

    public void addSchool(School school) {
        Optional<School> schoolExists = schoolRepository.getSchoolByName(school.getName());
        if(schoolExists.isPresent()){
            throw new IllegalStateException("School exists");
        }
        schoolRepository.save(school);
    }
}
