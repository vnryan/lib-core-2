package vn.ryan.entity.core.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.UnitDto;
import vn.ryan.entity.core.entities.Unit;
import vn.ryan.entity.core.repository.LessonRepository;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {})
public abstract class UnitMapper implements EntityMapper<Unit, UnitDto> {
    public static final UnitMapper INSTANCE = Mappers.getMapper(UnitMapper.class);

    @Mapping(target="lessons", expression="java(LessonMapper.INSTANCE.toListDto(lessonRepository.findByUnitIdAndIsActive(unit.getId(), 1)))")
    public abstract UnitDto toDto(Unit unit, @Context LessonRepository lessonRepository);

    @AfterMapping
    protected void getLessonUnit(@MappingTarget UnitDto dto, LessonRepository lessonRepository) {
        dto.setLessons(LessonMapper.INSTANCE.toListDto(lessonRepository.findByUnitIdAndIsActive(dto.getId(), 1)));
    }


}
