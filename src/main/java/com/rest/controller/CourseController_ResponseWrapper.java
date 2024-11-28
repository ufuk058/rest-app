package com.rest.controller;

import com.rest.dto.CourseDTO;
import com.rest.dto.ResponseWrapper;
import com.rest.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3/course")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;

    }

    /// localhost:8080/api/v3/course/all --> return all courses
    /// I want to add 1 header and change status 200 Accepted
    /// and body includes --> Courses are Successfully retrieved, success = true, code=200
    @GetMapping("/all")
    public ResponseEntity<ResponseWrapper> getAllCourses(){

        ResponseWrapper responseWrapper=new ResponseWrapper("Courses are Successfully retrieved",
                courseService.getCourses());
        return ResponseEntity.status((HttpStatus.OK))
                .header("Version","v3")
                .body(responseWrapper);
    }

    /// localhost:8080/api/v3/course/:1 2 3
    /// Status code 200
    /// and body includes --> course id is retrieved, success= true, code=200
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable Long id){
        ResponseWrapper wrapper=new ResponseWrapper("Course "+id+" is retrieved successfully"
                ,courseService.getCourseById(id));

        return ResponseEntity.ok(wrapper);
    }

}
