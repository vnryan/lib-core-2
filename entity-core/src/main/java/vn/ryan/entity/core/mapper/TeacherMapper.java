package vn.ryan.entity.core.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.TeacherDto;
import vn.ryan.entity.core.entities.Teacher;

@Mapper
@Component
public abstract class TeacherMapper implements EntityMapper<Teacher, TeacherDto> {
    public static final TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @AfterMapping
    public void setRoleName(@MappingTarget TeacherDto teacherDto) {
        var rolName = "";
        if (teacherDto.getRole() == 1) {
            rolName = "Cố vấn nội dung";
        }
        if (teacherDto.getRole() == 2) {
            rolName = "Giáo viên giảng dạy";
        }
        teacherDto.setRoleName(rolName);
    }
}
