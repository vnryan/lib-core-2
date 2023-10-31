package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.LiveClassDto;
import vn.ryan.entity.core.entities.LiveClass;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class LiveClassMapperImpl implements LiveClassMapper {

    @Override
    public LiveClassDto toDto(LiveClass e) {
        if ( e == null ) {
            return null;
        }

        LiveClassDto liveClassDto = new LiveClassDto();

        liveClassDto.setId( e.getId() );
        liveClassDto.setGradeId( e.getGradeId() );
        liveClassDto.setName( e.getName() );
        liveClassDto.setDate( e.getDate() );
        liveClassDto.setTime( e.getTime() );
        liveClassDto.setSeedingTime( e.getSeedingTime() );
        liveClassDto.setLink( e.getLink() );
        liveClassDto.setVideoTime( e.getVideoTime() );
        liveClassDto.setTeacher( e.getTeacher() );
        liveClassDto.setImage( e.getImage() );
        liveClassDto.setStatus( e.getStatus() );
        liveClassDto.setFree( e.getFree() );
        liveClassDto.setCreatedUser( e.getCreatedUser() );
        liveClassDto.setUpdatedUser( e.getUpdatedUser() );
        liveClassDto.setUuid( e.getUuid() );
        liveClassDto.setIsActive( e.getIsActive() );
        liveClassDto.setExerciseId( e.getExerciseId() );
        liveClassDto.setStartTime( e.getStartTime() );
        if ( e.getCreatedAt() != null ) {
            liveClassDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            liveClassDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return liveClassDto;
    }

    @Override
    public LiveClass toEntity(LiveClassDto d) {
        if ( d == null ) {
            return null;
        }

        LiveClass liveClass = new LiveClass();

        liveClass.setId( d.getId() );
        liveClass.setCreatedAt( d.getCreatedAt() );
        liveClass.setUpdatedAt( d.getUpdatedAt() );
        liveClass.setGradeId( d.getGradeId() );
        liveClass.setName( d.getName() );
        liveClass.setDate( d.getDate() );
        liveClass.setTime( d.getTime() );
        liveClass.setSeedingTime( d.getSeedingTime() );
        liveClass.setStartTime( d.getStartTime() );
        liveClass.setLink( d.getLink() );
        liveClass.setVideoTime( d.getVideoTime() );
        liveClass.setTeacher( d.getTeacher() );
        liveClass.setImage( d.getImage() );
        liveClass.setStatus( d.getStatus() );
        liveClass.setFree( d.getFree() );
        liveClass.setCreatedUser( d.getCreatedUser() );
        liveClass.setUpdatedUser( d.getUpdatedUser() );
        liveClass.setUuid( d.getUuid() );
        liveClass.setIsActive( d.getIsActive() );
        liveClass.setExerciseId( d.getExerciseId() );

        return liveClass;
    }

    @Override
    public List<LiveClass> toListEntity(List<LiveClassDto> d) {
        if ( d == null ) {
            return null;
        }

        List<LiveClass> list = new ArrayList<LiveClass>( d.size() );
        for ( LiveClassDto liveClassDto : d ) {
            list.add( toEntity( liveClassDto ) );
        }

        return list;
    }

    @Override
    public List<LiveClassDto> toListDto(List<LiveClass> e) {
        if ( e == null ) {
            return null;
        }

        List<LiveClassDto> list = new ArrayList<LiveClassDto>( e.size() );
        for ( LiveClass liveClass : e ) {
            list.add( toDto( liveClass ) );
        }

        return list;
    }
}
