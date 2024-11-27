package com.rest.service.impl;

import com.rest.dto.CourseDTO;
import com.rest.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        return null;
    }

    @Override
    public CourseDTO getCourseById(Long courseId) {
        return null;
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        return List.of();
    }

    @Override
    public List<CourseDTO> getCourses() {
        return List.of();
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {

    }

    @Override
    public void deleteCourseById(Long courseId) {

    }

    @Override
    public void deleteCourses() {

    }
}
