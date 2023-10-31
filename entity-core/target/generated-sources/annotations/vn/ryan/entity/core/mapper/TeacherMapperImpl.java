package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.TeacherDto;
import vn.ryan.entity.core.entities.Teacher;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class TeacherMapperImpl extends TeacherMapper {

    @Override
    public TeacherDto toDto(Teacher e) {
        if ( e == null ) {
            return null;
        }

        TeacherDto teacherDto = new TeacherDto();

        teacherDto.setId( e.getId() );
        teacherDto.setName( e.getName() );
        teacherDto.setSlug( e.getSlug() );
        teacherDto.setIsActive( e.getIsActive() );
        teacherDto.setIsHot( e.getIsHot() );
        teacherDto.setExperience( e.getExperience() );
        teacherDto.setNum( e.getNum() );
        teacherDto.setRole( e.getRole() );
        teacherDto.setJob( e.getJob() );
        teacherDto.setImage( e.getImage() );
        teacherDto.setImageApp( e.getImageApp() );
        teacherDto.setSignatureImage( e.getSignatureImage() );
        teacherDto.setDescription( e.getDescription() );
        if ( e.getCreatedAt() != null ) {
            teacherDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            teacherDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        setRoleName( teacherDto );

        return teacherDto;
    }

    @Override
    public Teacher toEntity(TeacherDto d) {
        if ( d == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( d.getId() );
        teacher.setCreatedAt( d.getCreatedAt() );
        teacher.setUpdatedAt( d.getUpdatedAt() );
        teacher.setName( d.getName() );
        teacher.setSlug( d.getSlug() );
        teacher.setIsActive( d.getIsActive() );
        teacher.setExperience( d.getExperience() );
        teacher.setNum( d.getNum() );
        teacher.setIsHot( d.getIsHot() );
        teacher.setRole( d.getRole() );
        teacher.setJob( d.getJob() );
        teacher.setImage( d.getImage() );
        teacher.setImageApp( d.getImageApp() );
        teacher.setSignatureImage( d.getSignatureImage() );
        teacher.setDescription( d.getDescription() );

        return teacher;
    }

    @Override
    public List<Teacher> toListEntity(List<TeacherDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Teacher> list = new ArrayList<Teacher>( d.size() );
        for ( TeacherDto teacherDto : d ) {
            list.add( toEntity( teacherDto ) );
        }

        return list;
    }

    @Override
    public List<TeacherDto> toListDto(List<Teacher> e) {
        if ( e == null ) {
            return null;
        }

        List<TeacherDto> list = new ArrayList<TeacherDto>( e.size() );
        for ( Teacher teacher : e ) {
            list.add( toDto( teacher ) );
        }

        return list;
    }
}
