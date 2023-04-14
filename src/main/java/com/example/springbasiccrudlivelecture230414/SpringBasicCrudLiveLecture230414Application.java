package com.example.springbasiccrudlivelecture230414;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicCrudLiveLecture230414Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBasicCrudLiveLecture230414Application.class, args);
    }

//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Bean
//    public ApplicationRunner applicationRunner() {
//        return args -> {
//            File json = ResourceUtils.getFile("classpath:CourseData.json");
//
//            List<CourseRequestDto> list = new ObjectMapper().readValue(json,new TypeReference<>(){});
//            List<Course> courses = list.stream().map(Course::new).collect(Collectors.toCollection(ArrayList::new));
//
//            courseRepository.saveAll(courses);
//        };
//    }

}
