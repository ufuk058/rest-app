package com.rest.controller;

import com.rest.dto.CourseDTO;
import com.rest.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /// localhost:8080/course/all  --> return all courses
    @GetMapping("/all")
    public List<CourseDTO> getAllCourses(){

        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long id){

        return courseService.getCourseById(id);
    }
}
