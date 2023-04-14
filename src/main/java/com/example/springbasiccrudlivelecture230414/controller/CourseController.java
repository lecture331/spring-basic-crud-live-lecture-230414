package com.example.springbasiccrudlivelecture230414.controller;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/course")
public class CourseController {

    private static final Map<Long, Course> table = new HashMap<>();
    private static long ID;

    @PostMapping("/create")
    public String createCourse(@RequestBody CourseRequestDto requestDto) {
        // 브라우저에서 받아온 데이터를 저장하기 위해서 Course 객체로 변환
        Course course = new Course(requestDto);

        // ID 중복을 막기위해서 현재 테이블의 최대 ID + 1
        course.setId(++ID);

        // 테이블에 생성한 Course 인스턴스를 저장!
        table.put(ID, course);

        return "강의 저장에 성공했습니다.";
    }

    @GetMapping("/list")
    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어있는 모든 강의 목록을 조회
        return table.values().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}") // http://localhost:8080/course/3
    public CourseResponseDto getCourse(@PathVariable Long id) {
        // 조회하기 위해 받아온 course 의 id를 사용해서 해당 course 인스턴스가 테이블에 존재하는지 확인하고 가져옵니다.
        Course course = table.get(id);

        if(course != null) {
            return new CourseResponseDto(course);
        } else {
            return new CourseResponseDto();
        }
    }

    @PutMapping("/update/{id}")
    public CourseResponseDto updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {
        // 수정하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = table.get(id);

        if (course != null) {
            course.update(requestDto);

            return new CourseResponseDto(course);
        } else {
            return new CourseResponseDto();
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        // 삭제하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = table.get(id);

        if (course != null) {
            table.remove(id);

            return "강의 삭제에 성공했습니다.";
        } else {
            return "삭제할 강의가 없습니다.";
        }
    }
}
