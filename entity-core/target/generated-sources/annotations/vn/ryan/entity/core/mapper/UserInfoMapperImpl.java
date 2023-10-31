package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.ryan.entity.core.dto.UserInfoDto;
import vn.ryan.entity.core.entities.UserInfo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class UserInfoMapperImpl extends UserInfoMapper {

    @Override
    public UserInfoDto toDto(UserInfo e) {
        if ( e == null ) {
            return null;
        }

        UserInfoDto userInfoDto = new UserInfoDto();

        userInfoDto.setId( e.getId() );
        userInfoDto.setUserId( e.getUserId() );
        userInfoDto.setGradeId( e.getGradeId() );
        userInfoDto.setLevelId( e.getLevelId() );
        userInfoDto.setName( e.getName() );
        userInfoDto.setGender( e.getGender() );
        userInfoDto.setDateBirth( e.getDateBirth() );
        userInfoDto.setEmail( e.getEmail() );
        userInfoDto.setPhone( e.getPhone() );
        userInfoDto.setUserName( e.getUserName() );
        userInfoDto.setIsActive( e.getIsActive() );
        userInfoDto.setNote( e.getNote() );
        userInfoDto.setParentName( e.getParentName() );
        userInfoDto.setDeviceId( e.getDeviceId() );
        userInfoDto.setDeviceType( e.getDeviceType() );
        userInfoDto.setVersion( e.getVersion() );
        userInfoDto.setAvatar( e.getAvatar() );
        userInfoDto.setActiveCode( e.getActiveCode() );
        userInfoDto.setPhoneZalo( e.getPhoneZalo() );
        if ( e.getCreatedAt() != null ) {
            userInfoDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            userInfoDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return userInfoDto;
    }

    @Override
    public UserInfo toEntity(UserInfoDto d) {
        if ( d == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setId( d.getId() );
        userInfo.setCreatedAt( d.getCreatedAt() );
        userInfo.setUpdatedAt( d.getUpdatedAt() );
        userInfo.setUserId( d.getUserId() );
        userInfo.setGradeId( d.getGradeId() );
        userInfo.setLevelId( d.getLevelId() );
        userInfo.setName( d.getName() );
        userInfo.setGender( d.getGender() );
        userInfo.setDateBirth( d.getDateBirth() );
        userInfo.setEmail( d.getEmail() );
        userInfo.setPhone( d.getPhone() );
        userInfo.setUserName( d.getUserName() );
        userInfo.setIsActive( d.getIsActive() );
        userInfo.setNote( d.getNote() );
        userInfo.setParentName( d.getParentName() );
        userInfo.setDeviceId( d.getDeviceId() );
        userInfo.setDeviceType( d.getDeviceType() );
        userInfo.setVersion( d.getVersion() );
        userInfo.setAvatar( d.getAvatar() );
        userInfo.setActiveCode( d.getActiveCode() );
        userInfo.setPhoneZalo( d.getPhoneZalo() );

        return userInfo;
    }

    @Override
    public List<UserInfo> toListEntity(List<UserInfoDto> d) {
        if ( d == null ) {
            return null;
        }

        List<UserInfo> list = new ArrayList<UserInfo>( d.size() );
        for ( UserInfoDto userInfoDto : d ) {
            list.add( toEntity( userInfoDto ) );
        }

        return list;
    }

    @Override
    public List<UserInfoDto> toListDto(List<UserInfo> e) {
        if ( e == null ) {
            return null;
        }

        List<UserInfoDto> list = new ArrayList<UserInfoDto>( e.size() );
        for ( UserInfo userInfo : e ) {
            list.add( toDto( userInfo ) );
        }

        return list;
    }
}
