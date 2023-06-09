package com.example.springbasiccrudlivelecture230414.dto;

import com.example.springbasiccrudlivelecture230414.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseResponseDto {
    private Long id;
    private String title;
    private String instructor;
    private double cost;

    public CourseResponseDto(Course course) {
        this.id = course.getId();
        this.title = course.getTitle();
        this.instructor = course.getInstructor();
        this.cost = course.getCost();
    }
}
