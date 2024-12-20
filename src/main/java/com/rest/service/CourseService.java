package com.rest.service;

import com.rest.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Long courseId);
    List<CourseDTO> getCoursesByCategory(String category);
    List<CourseDTO> getCourses();
    CourseDTO updateCourse(Long courseId, CourseDTO courseDTO);
   // void updateCourseWithoutBody(Long id, CourseDTO courseDTO);
    void deleteCourseById(Long courseId);
    void deleteCourses();
}
