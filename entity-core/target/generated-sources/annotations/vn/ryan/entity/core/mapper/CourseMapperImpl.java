package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.ryan.entity.core.dto.CourseDto;
import vn.ryan.entity.core.entities.Course;
import vn.ryan.entity.core.repository.UnitRepository;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl extends CourseMapper {

    @Override
    public CourseDto toDto(Course e) {
        if ( e == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( e.getId() );
        courseDto.setName( e.getName() );
        courseDto.setSlug( e.getSlug() );
        courseDto.setIsActive( e.getIsActive() );
        courseDto.setGradeId( e.getGradeId() );
        courseDto.setLevelId( e.getLevelId() );
        courseDto.setDescription( e.getDescription() );
        courseDto.setIntro( e.getIntro() );
        courseDto.setTeacherId( e.getTeacherId() );
        if ( e.getCreatedAt() != null ) {
            courseDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            courseDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return courseDto;
    }

    @Override
    public Course toEntity(CourseDto d) {
        if ( d == null ) {
            return null;
        }

        Course course = new Course();

        course.setId( d.getId() );
        course.setCreatedAt( d.getCreatedAt() );
        course.setUpdatedAt( d.getUpdatedAt() );
        course.setName( d.getName() );
        course.setSlug( d.getSlug() );
        course.setIsActive( d.getIsActive() );
        course.setGradeId( d.getGradeId() );
        course.setLevelId( d.getLevelId() );
        course.setTeacherId( d.getTeacherId() );
        course.setDescription( d.getDescription() );
        course.setIntro( d.getIntro() );

        return course;
    }

    @Override
    public List<Course> toListEntity(List<CourseDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Course> list = new ArrayList<Course>( d.size() );
        for ( CourseDto courseDto : d ) {
            list.add( toEntity( courseDto ) );
        }

        return list;
    }

    @Override
    public List<CourseDto> toListDto(List<Course> e) {
        if ( e == null ) {
            return null;
        }

        List<CourseDto> list = new ArrayList<CourseDto>( e.size() );
        for ( Course course : e ) {
            list.add( toDto( course ) );
        }

        return list;
    }

    @Override
    public CourseDto toDto(Course course, UnitRepository unitRepository) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setId( course.getId() );
        courseDto.setName( course.getName() );
        courseDto.setSlug( course.getSlug() );
        courseDto.setIsActive( course.getIsActive() );
        courseDto.setGradeId( course.getGradeId() );
        courseDto.setLevelId( course.getLevelId() );
        courseDto.setDescription( course.getDescription() );
        courseDto.setIntro( course.getIntro() );
        courseDto.setTeacherId( course.getTeacherId() );
        if ( course.getCreatedAt() != null ) {
            courseDto.setCreatedAt( new Date( course.getCreatedAt().getTime() ) );
        }
        if ( course.getUpdatedAt() != null ) {
            courseDto.setUpdatedAt( new Date( course.getUpdatedAt().getTime() ) );
        }

        courseDto.setUnits( UnitMapper.INSTANCE.toListDto(unitRepository.findByCourseIdAndIsActive(course.getId(), 1)) );

        return courseDto;
    }
}
