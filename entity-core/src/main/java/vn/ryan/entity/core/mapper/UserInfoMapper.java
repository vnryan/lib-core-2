package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.UserInfoDto;
import vn.ryan.entity.core.entities.UserInfo;

@Component
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {})
public abstract class UserInfoMapper implements EntityMapper<UserInfo, UserInfoDto> {
    public static final UserInfoMapper INSTANCE = Mappers.getMapper(UserInfoMapper.class);
}
