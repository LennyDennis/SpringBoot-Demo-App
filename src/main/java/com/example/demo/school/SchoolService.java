package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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

    public void deleteSchool(Integer schoolId) {
        boolean schoolExists = schoolRepository.existsById(schoolId);
        if(schoolExists){
            schoolRepository.deleteById(schoolId);
        }else{
            throw new IllegalStateException("School does not exist");
        }
    }

    @Transactional
    public void updateSchool(Integer schoolId, String name) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalArgumentException("School does not exits"));

        if(name != null && !Objects.equals(name,school.getName())){
            Optional<School> schoolExists = schoolRepository.getSchoolByName(name);
            if(schoolExists.isPresent()){
                throw new IllegalStateException("School exists");
            }
            school.setName(name);
        }

    }
}
