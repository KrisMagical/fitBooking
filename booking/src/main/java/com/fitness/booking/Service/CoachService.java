package com.fitness.booking.Service;

import com.fitness.booking.Dto.CourseDTO;
import com.fitness.booking.Dto.CourseSessionDTO;
import com.fitness.booking.Mapper.CourseMapper;
import com.fitness.booking.Model.Course;
import com.fitness.booking.Model.CourseSession;
import com.fitness.booking.Repository.CourseRepository;
import com.fitness.booking.Repository.CourseSessionRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class CoachService {
    private final CourseRepository courseRepository;
    private final CourseSessionRepository courseSessionRepository;
    private CourseMapper courseMapper;

    @Transactional
    public CourseDTO createCourse(CourseDTO dto) {
        Course course = courseMapper.toEntity(dto);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Transactional
    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The fucking Course not exist"));
        courseMapper.update(course, dto);
        courseRepository.save(course);
        return courseMapper.toDto(course);
    }

    @Transactional
    public CourseSessionDTO createSession(CourseSessionDTO dto) {
        CourseSession session = courseMapper.toEntity(dto);
        courseSessionRepository.save(session);
        return courseMapper.toDto(session);
    }

    public List<CourseDTO> listCourses() {
        return courseRepository.findAll()
                .stream().map(courseMapper::toDto).collect(Collectors.toList());
    }

}
