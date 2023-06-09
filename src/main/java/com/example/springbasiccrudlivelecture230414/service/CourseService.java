package com.example.springbasiccrudlivelecture230414.service;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import com.example.springbasiccrudlivelecture230414.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public String createCourse(CourseRequestDto requestDto) {
        // 브라우저에서 받아온 데이터를 저장하기 위해서 Course 객체로 변환
        Course course = new Course(requestDto);

        courseRepository.save(course);

        return "강의 저장에 성공했습니다.";
    }

    public List<CourseResponseDto> getCourseList() {
        // 테이블에 저장되어있는 모든 강의 목록을 조회
        return courseRepository.findAll().stream().map(CourseResponseDto::new).collect(Collectors.toList());
    }

    public CourseResponseDto getCourse(Long id) {
        // 조회하기 위해 받아온 course 의 id를 사용해서 해당 course 인스턴스가 테이블에 존재하는지 확인하고 가져옵니다.
        Course course = checkCourse(id);

        return new CourseResponseDto(course);
    }

    @Transactional
    public CourseResponseDto updateCourse(Long id, CourseRequestDto requestDto) {
        // 수정하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = checkCourse(id);

        course.update(requestDto);

        return new CourseResponseDto(course);
    }

    public String deleteCourse(Long id) {
        // 수정하기 위해 받아온 course 의 id를 사용하여 해당 course 인스턴스가 존재하는지 확인하고 가져옵니다.
        Course course = checkCourse(id);

        courseRepository.delete(course);

        return "강의 삭제에 성공했습니다.";
    }

    public CourseResponseDto getCourseByTitle(String title) {
        Course course = courseRepository.findByTitle(title).orElseThrow(
                () -> new NullPointerException("해당하는 제목의 강의가 없습니다.")
        );

        return new CourseResponseDto(course);
    }

    private Course checkCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new NullPointerException("선택한 강의가 존재하지 않습니다.")
        );
    }
}
