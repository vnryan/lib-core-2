package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.LiveClassDto;
import vn.ryan.entity.core.entities.LiveClass;

@Mapper
@Component
public interface LiveClassMapper extends EntityMapper<LiveClass, LiveClassDto> {
    LiveClassMapper INSTANCE = Mappers.getMapper(LiveClassMapper.class);
}
