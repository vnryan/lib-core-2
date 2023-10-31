package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.BannerDto;
import vn.ryan.entity.core.entities.Banner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class BannerMapperImpl implements BannerMapper {

    @Override
    public BannerDto toDto(Banner e) {
        if ( e == null ) {
            return null;
        }

        BannerDto bannerDto = new BannerDto();

        bannerDto.setId( e.getId() );
        bannerDto.setName( e.getName() );
        bannerDto.setDescription( e.getDescription() );
        bannerDto.setChannel( e.getChannel() );
        bannerDto.setImage( e.getImage() );
        bannerDto.setImageMobile( e.getImageMobile() );
        bannerDto.setImageTablet( e.getImageTablet() );
        bannerDto.setLink( e.getLink() );
        bannerDto.setStatus( e.getStatus() );
        bannerDto.setType( e.getType() );
        bannerDto.setIsActive( e.getIsActive() );
        if ( e.getCreatedAt() != null ) {
            bannerDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            bannerDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return bannerDto;
    }

    @Override
    public Banner toEntity(BannerDto d) {
        if ( d == null ) {
            return null;
        }

        Banner banner = new Banner();

        banner.setCreatedAt( d.getCreatedAt() );
        banner.setUpdatedAt( d.getUpdatedAt() );
        banner.setId( d.getId() );
        banner.setName( d.getName() );
        banner.setDescription( d.getDescription() );
        banner.setChannel( d.getChannel() );
        banner.setImage( d.getImage() );
        banner.setImageMobile( d.getImageMobile() );
        banner.setImageTablet( d.getImageTablet() );
        banner.setLink( d.getLink() );
        banner.setStatus( d.getStatus() );
        banner.setType( d.getType() );
        banner.setIsActive( d.getIsActive() );

        return banner;
    }

    @Override
    public List<Banner> toListEntity(List<BannerDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Banner> list = new ArrayList<Banner>( d.size() );
        for ( BannerDto bannerDto : d ) {
            list.add( toEntity( bannerDto ) );
        }

        return list;
    }

    @Override
    public List<BannerDto> toListDto(List<Banner> e) {
        if ( e == null ) {
            return null;
        }

        List<BannerDto> list = new ArrayList<BannerDto>( e.size() );
        for ( Banner banner : e ) {
            list.add( toDto( banner ) );
        }

        return list;
    }
}
