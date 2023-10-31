package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.QuestionDto;
import vn.ryan.entity.core.entities.Question;

@Mapper
public interface QuestionMapper extends EntityMapper<Question, QuestionDto> {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);
}
