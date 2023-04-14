package com.example.springbasiccrudlivelecture230414.service;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import com.example.springbasiccrudlivelecture230414.repository.CourseRepository;

import java.util.List;

public class CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    public String createCourse(CourseRequestDto requestDto) {
        // 브라우저에서 받아온 데이터를 저장하기 위해서 Course 객체로 변환
        Course course = new Course(requestDto);

        return courseRepository.createCourse(course);
    }

    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어있는 모든 강의 목록을 조회
        return courseRepository.getCourseList();
    }

    public CourseResponseDto getCourse(Long id) {
        // 조회하기 위해 받아온 course 의 id를 사용해서 해당 course 인스턴스가 테이블에 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if(course != null) {
            return new CourseResponseDto(course);
        } else {
            return new CourseResponseDto();
        }
    }

    public CourseResponseDto updateCourse(Long id, CourseRequestDto requestDto) {
        // 수정하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if (course != null) {
            course.update(requestDto);

            return new CourseResponseDto(course);
        } else {
            return new CourseResponseDto();
        }
    }

    public String deleteCourse(Long id) {
        // 삭제하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = courseRepository.getCourse(id);

        if (course != null) {
            courseRepository.deleteCourse(id);

            return "강의 삭제에 성공했습니다.";
        } else {
            return "삭제할 강의가 없습니다.";
        }
    }
}
