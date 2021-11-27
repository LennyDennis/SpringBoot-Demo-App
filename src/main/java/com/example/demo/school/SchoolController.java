package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
     public List<School> getSchool(){
        return schoolService.getSchool();
    }
}
