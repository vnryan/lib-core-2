package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.NewsDto;
import vn.ryan.entity.core.entities.News;

@Mapper
public interface NewsMapper extends EntityMapper<News, NewsDto> {
    NewsMapper INSTANCE = Mappers.getMapper(NewsMapper.class);
}
