package com.example.springbasiccrudlivelecture230414.repository;

import com.example.springbasiccrudlivelecture230414.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
