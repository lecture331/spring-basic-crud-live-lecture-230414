package com.example.springbasiccrudlivelecture230414;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import com.example.springbasiccrudlivelecture230414.repository.CourseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBasicCrudLiveLecture230414Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicCrudLiveLecture230414Application.class, args);
    }

    @Autowired
    private CourseRepository courseRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            File json = ResourceUtils.getFile("classpath:CourseData.json");

            List<CourseRequestDto> list = new ObjectMapper().readValue(json,new TypeReference<>(){});
            List<Course> courses = list.stream().map(Course::new).collect(Collectors.toCollection(ArrayList::new));

            courseRepository.saveAll(courses);
        };
    }

}
