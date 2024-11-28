package com.rest.controller;

import com.rest.dto.CourseDTO;
import com.rest.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/course")
public class CourseController_ResponseEntity {
    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    /// localhost:8080/api/v2/course/all
    /// I want to add 2 headers and change the status code 202 Accepted
    @GetMapping("/all")
    public ResponseEntity<List<CourseDTO>> getAllCourses(){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Version", "Rest v2")
                .header("Operation","Get List of Courses")
                .body(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(courseService.getCourseById(id));

    }

    /// Get Courses based on Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCategory(@PathVariable String category){

        return ResponseEntity
                .ok(courseService.getCoursesByCategory(category));

    }

    @PostMapping("/create")
    public ResponseEntity<CourseDTO> createNewCourse(@RequestBody CourseDTO course){

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(courseService.createCourse(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>  updateCourseById(@PathVariable Long id, @RequestBody CourseDTO course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }




}
