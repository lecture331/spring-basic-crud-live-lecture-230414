package com.example.springbasiccrudlivelecture230414.controller;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230414.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public String createCourse(@RequestBody CourseRequestDto requestDto) {
        return courseService.createCourse(requestDto);
    }

    @GetMapping("/list")
    public List<CourseResponseDto> getCourseList() {
        return courseService.getCourseList();
    }

    @GetMapping("/{id}") // http://localhost:8080/course/3
    public CourseResponseDto getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PutMapping("/update/{id}")
    public CourseResponseDto updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        return courseService.updateCourse(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}
