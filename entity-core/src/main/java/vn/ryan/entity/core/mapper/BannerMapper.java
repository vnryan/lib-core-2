package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.BannerDto;
import vn.ryan.entity.core.entities.Banner;

@Mapper
public interface BannerMapper extends EntityMapper<Banner, BannerDto> {
    BannerMapper INSTANCE = Mappers.getMapper(BannerMapper.class);
}
