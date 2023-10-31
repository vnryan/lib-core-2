package vn.ryan.entity.core.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.CourseDto;
import vn.ryan.entity.core.entities.Course;
import vn.ryan.entity.core.repository.UnitRepository;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {})
public abstract class CourseMapper implements EntityMapper<Course, CourseDto> {
    public static final CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    @Mapping(target="units", expression="java(UnitMapper.INSTANCE.toListDto(unitRepository.findByCourseIdAndIsActive(course.getId(), 1)))")
    public abstract CourseDto toDto(Course course, @Context UnitRepository unitRepository);

}
