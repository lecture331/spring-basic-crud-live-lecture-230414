package com.example.springbasiccrudlivelecture230414.repository;

import com.example.springbasiccrudlivelecture230414.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTitle(String title);
}
