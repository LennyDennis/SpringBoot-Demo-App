package com.example.demo.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
     public void addSchool(@RequestBody School school){
        schoolService.addSchool(school);
    }

    @DeleteMapping(path = "{schoolId}")
    public void deleteSchool(@PathVariable("schoolId") Integer schoolId){
        schoolService.deleteSchool(schoolId);
    }

    @PutMapping(path = "{schoolId}")
    public void updateSchool(@PathVariable("schoolId") Integer schoolId,@RequestParam(required = false) String name){
        schoolService.updateSchool(schoolId,name);
    }
}
