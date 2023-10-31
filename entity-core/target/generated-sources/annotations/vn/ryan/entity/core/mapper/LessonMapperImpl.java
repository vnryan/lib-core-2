package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.ryan.entity.core.dto.LessonDto;
import vn.ryan.entity.core.entities.Lesson;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl extends LessonMapper {

    @Override
    public LessonDto toDto(Lesson e) {
        if ( e == null ) {
            return null;
        }

        LessonDto lessonDto = new LessonDto();

        lessonDto.setId( e.getId() );
        lessonDto.setName( e.getName() );
        lessonDto.setIsActive( e.getIsActive() );
        lessonDto.setIsFree( e.getIsFree() );
        lessonDto.setUnitId( e.getUnitId() );
        lessonDto.setCourseId( e.getCourseId() );
        lessonDto.setDescription( e.getDescription() );
        lessonDto.setPosition( e.getPosition() );
        if ( e.getCreatedAt() != null ) {
            lessonDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            lessonDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return lessonDto;
    }

    @Override
    public Lesson toEntity(LessonDto d) {
        if ( d == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( d.getId() );
        lesson.setCreatedAt( d.getCreatedAt() );
        lesson.setUpdatedAt( d.getUpdatedAt() );
        lesson.setName( d.getName() );
        lesson.setIsActive( d.getIsActive() );
        lesson.setIsFree( d.getIsFree() );
        lesson.setUnitId( d.getUnitId() );
        lesson.setCourseId( d.getCourseId() );
        lesson.setDescription( d.getDescription() );
        lesson.setPosition( d.getPosition() );

        return lesson;
    }

    @Override
    public List<Lesson> toListEntity(List<LessonDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Lesson> list = new ArrayList<Lesson>( d.size() );
        for ( LessonDto lessonDto : d ) {
            list.add( toEntity( lessonDto ) );
        }

        return list;
    }

    @Override
    public List<LessonDto> toListDto(List<Lesson> e) {
        if ( e == null ) {
            return null;
        }

        List<LessonDto> list = new ArrayList<LessonDto>( e.size() );
        for ( Lesson lesson : e ) {
            list.add( toDto( lesson ) );
        }

        return list;
    }
}
