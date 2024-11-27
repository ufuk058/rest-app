package com.rest.controller;

import com.rest.dto.CourseDTO;
import com.rest.entity.Course;
import com.rest.service.CourseService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public CourseDTO createCourse(@RequestBody CourseDTO course){

        return courseService.createCourse(course);
    }

//    @PutMapping("/{id}")
//    public void updateWithoutResponseBody( @PathVariable Long id, @RequestBody CourseDTO course){
//        courseService.updateCourseWithoutBody(id, course);
//    }


    @PutMapping("/{id}")
    public CourseDTO updateCourseById(@PathVariable Long id, @RequestBody CourseDTO course){

        return courseService.updateCourse(id, course);
        //It works with void, like no update return type required but rest will not return
        /// a response body after  update method like above method
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }
}
