package com.example.demo.school;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolService {

    public List<School> getSchool(){
        return Arrays.asList(new School(1,"Test School"));
    }
}
