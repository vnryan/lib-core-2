package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.TagDto;
import vn.ryan.entity.core.entities.Tag;

@Mapper
public interface TagMapper extends EntityMapper<Tag, TagDto> {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);
}
