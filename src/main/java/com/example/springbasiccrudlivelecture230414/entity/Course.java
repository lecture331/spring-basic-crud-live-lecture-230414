package com.example.springbasiccrudlivelecture230414.entity;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Course extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String instructor;
    private double cost;

    public Course(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }

    public void update(CourseRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.instructor = requestDto.getInstructor();
        this.cost = requestDto.getCost();
    }
}
