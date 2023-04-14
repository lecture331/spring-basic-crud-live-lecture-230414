package com.example.springbasiccrudlivelecture230414.repository;

import com.example.springbasiccrudlivelecture230414.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static final Map<Long, Course> table = new HashMap<>();
    private static long ID;

    public String createCourse(Course course) {
        // ID 중복을 막기위해서 현재 테이블의 최대 ID + 1
        course.setId(++ID);

        // 테이블에 생성한 Course 인스턴스를 저장!
        table.put(ID, course);

        return "강의 저장에 성공했습니다.";
    }

    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어있는 모든 강의 목록을 조회
        return table.values().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }

    public Course getCourse(Long id) {
        return table.get(id);
    }

    public void deleteCourse(Long id) {
        table.remove(id);
    }
}
