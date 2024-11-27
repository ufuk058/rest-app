package com.rest.service.impl;

import com.rest.dto.CourseDTO;
import com.rest.entity.Course;
import com.rest.repository.CourseRepository;
import com.rest.service.CourseService;
import com.rest.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public CourseDTO createCourse(CourseDTO course) {

         courseRepository.save(mapperUtil.convert(course, new Course()));
         return course;
    }

    @Override
    public CourseDTO getCourseById(Long courseId) {
        Course course= courseRepository.findById(courseId).get();
        return mapperUtil.convert(course, new CourseDTO());
    }

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        List<Course> list= courseRepository.findAllByCategory(category);
        return list.stream().map(course ->  mapperUtil.convert(course,new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
        List<Course> courses=courseRepository.findAll();
        return courses.stream().map(course -> mapperUtil.convert(course, new CourseDTO())).collect(Collectors.toList());
    }

    @Override
    public CourseDTO updateCourse(Long courseId, CourseDTO courseDTO) {

        Course course= mapperUtil.convert(courseDTO, new Course());
        courseRepository.findById(courseId).ifPresent(dbCourse-> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setRating(course.getRating());
            dbCourse.setDescription(course.getDescription());

            courseRepository.save(dbCourse);
        });

        return mapperUtil.convert(course,new CourseDTO());
    }

//    @Override
//    public void updateCourseWithoutBody(Long id, CourseDTO courseDTO) {
//        Course course= mapperUtil.convert(courseDTO, new Course());
//        courseRepository.findById(id).ifPresent(dbCourse-> {
//            dbCourse.setName(course.getName());
//            dbCourse.setCategory(course.getCategory());
//            dbCourse.setRating(course.getRating());
//            dbCourse.setDescription(course.getDescription());
//
//            courseRepository.save(dbCourse);
//        });
//    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();

    }
}
