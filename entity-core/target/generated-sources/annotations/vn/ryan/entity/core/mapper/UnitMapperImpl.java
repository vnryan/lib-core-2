package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.ryan.entity.core.dto.UnitDto;
import vn.ryan.entity.core.entities.Unit;
import vn.ryan.entity.core.repository.LessonRepository;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UnitMapperImpl extends UnitMapper {

    @Override
    public UnitDto toDto(Unit e) {
        if ( e == null ) {
            return null;
        }

        UnitDto unitDto = new UnitDto();

        unitDto.setId( e.getId() );
        unitDto.setName( e.getName() );
        unitDto.setIsActive( e.getIsActive() );
        unitDto.setIsFree( e.getIsFree() );
        unitDto.setType( e.getType() );
        unitDto.setCourseId( e.getCourseId() );
        unitDto.setNum( e.getNum() );
        unitDto.setImage( e.getImage() );
        unitDto.setDescription( e.getDescription() );
        unitDto.setMonthTest( e.getMonthTest() );
        unitDto.setLevel( e.getLevel() );
        unitDto.setTypeProgram( e.getTypeProgram() );
        if ( e.getCreatedAt() != null ) {
            unitDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            unitDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return unitDto;
    }

    @Override
    public Unit toEntity(UnitDto d) {
        if ( d == null ) {
            return null;
        }

        Unit unit = new Unit();

        unit.setId( d.getId() );
        unit.setCreatedAt( d.getCreatedAt() );
        unit.setUpdatedAt( d.getUpdatedAt() );
        unit.setName( d.getName() );
        unit.setIsActive( d.getIsActive() );
        unit.setIsFree( d.getIsFree() );
        unit.setType( d.getType() );
        unit.setCourseId( d.getCourseId() );
        unit.setNum( d.getNum() );
        unit.setImage( d.getImage() );
        unit.setDescription( d.getDescription() );
        unit.setLevel( d.getLevel() );
        unit.setTypeProgram( d.getTypeProgram() );
        unit.setMonthTest( d.getMonthTest() );

        return unit;
    }

    @Override
    public List<Unit> toListEntity(List<UnitDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Unit> list = new ArrayList<Unit>( d.size() );
        for ( UnitDto unitDto : d ) {
            list.add( toEntity( unitDto ) );
        }

        return list;
    }

    @Override
    public List<UnitDto> toListDto(List<Unit> e) {
        if ( e == null ) {
            return null;
        }

        List<UnitDto> list = new ArrayList<UnitDto>( e.size() );
        for ( Unit unit : e ) {
            list.add( toDto( unit ) );
        }

        return list;
    }

    @Override
    public UnitDto toDto(Unit unit, LessonRepository lessonRepository) {
        if ( unit == null ) {
            return null;
        }

        UnitDto unitDto = new UnitDto();

        unitDto.setId( unit.getId() );
        unitDto.setName( unit.getName() );
        unitDto.setIsActive( unit.getIsActive() );
        unitDto.setIsFree( unit.getIsFree() );
        unitDto.setType( unit.getType() );
        unitDto.setCourseId( unit.getCourseId() );
        unitDto.setNum( unit.getNum() );
        unitDto.setImage( unit.getImage() );
        unitDto.setDescription( unit.getDescription() );
        unitDto.setMonthTest( unit.getMonthTest() );
        unitDto.setLevel( unit.getLevel() );
        unitDto.setTypeProgram( unit.getTypeProgram() );
        if ( unit.getCreatedAt() != null ) {
            unitDto.setCreatedAt( new Date( unit.getCreatedAt().getTime() ) );
        }
        if ( unit.getUpdatedAt() != null ) {
            unitDto.setUpdatedAt( new Date( unit.getUpdatedAt().getTime() ) );
        }

        unitDto.setLessons( LessonMapper.INSTANCE.toListDto(lessonRepository.findByUnitIdAndIsActive(unit.getId(), 1)) );

        return unitDto;
    }
}
