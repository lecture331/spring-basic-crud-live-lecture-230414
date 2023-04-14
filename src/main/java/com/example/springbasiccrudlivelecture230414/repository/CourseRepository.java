package com.example.springbasiccrudlivelecture230414.repository;

import com.example.springbasiccrudlivelecture230414.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230414.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    // 강의 등록
    @Transactional
    public void save(Course course) {
        //트랜잭션 시작
        em.persist(course);
        //트랜잭션 끝
    }

    // 강의 단일 조회
    @Transactional
    public Optional<Course> findById(Long id) {
        Course course = em.find(Course.class, id);
        return Optional.ofNullable(course);
    }

    // 강의 전체 조회
    @Transactional
    public List<Course> findAll() {
        return em.createQuery("select c from Course c", Course.class).getResultList();
    }

    // 강의 삭제
    @Transactional
    public void delete(Long id) {
        // 삭제할 강의 조회
        Course course = em.find(Course.class, id);

        em.remove(course);
    }

}
