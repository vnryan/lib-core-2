package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.LessonDto;
import vn.ryan.entity.core.entities.Lesson;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {})
public abstract class LessonMapper implements EntityMapper<Lesson, LessonDto> {
    public static final LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);
}
