package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.TopicDto;
import vn.ryan.entity.core.entities.Topic;

@Mapper
public interface TopicMapper extends EntityMapper<Topic, TopicDto> {
    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);
}
