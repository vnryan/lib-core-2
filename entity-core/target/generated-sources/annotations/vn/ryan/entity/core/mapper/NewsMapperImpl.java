package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.NewsDto;
import vn.ryan.entity.core.entities.News;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto toDto(News e) {
        if ( e == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setId( e.getId() );
        newsDto.setName( e.getName() );
        newsDto.setSlug( e.getSlug() );
        newsDto.setTitle( e.getTitle() );
        newsDto.setPersonName( e.getPersonName() );
        newsDto.setJob( e.getJob() );
        newsDto.setDescription( e.getDescription() );
        newsDto.setContent( e.getContent() );
        newsDto.setImage( e.getImage() );
        newsDto.setLink( e.getLink() );
        newsDto.setNum( e.getNum() );
        newsDto.setCategoryId( e.getCategoryId() );
        newsDto.setIsHot( e.getIsHot() );
        newsDto.setHomePage( e.getHomePage() );
        newsDto.setStatus( e.getStatus() );
        newsDto.setType( e.getType() );
        newsDto.setCreatedUser( e.getCreatedUser() );
        if ( e.getCreatedAt() != null ) {
            newsDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            newsDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return newsDto;
    }

    @Override
    public News toEntity(NewsDto d) {
        if ( d == null ) {
            return null;
        }

        News news = new News();

        news.setId( d.getId() );
        news.setCreatedAt( d.getCreatedAt() );
        news.setUpdatedAt( d.getUpdatedAt() );
        news.setName( d.getName() );
        news.setSlug( d.getSlug() );
        news.setTitle( d.getTitle() );
        news.setPersonName( d.getPersonName() );
        news.setJob( d.getJob() );
        news.setDescription( d.getDescription() );
        news.setContent( d.getContent() );
        news.setImage( d.getImage() );
        news.setLink( d.getLink() );
        news.setNum( d.getNum() );
        news.setCategoryId( d.getCategoryId() );
        news.setIsHot( d.getIsHot() );
        news.setHomePage( d.getHomePage() );
        news.setStatus( d.getStatus() );
        news.setType( d.getType() );
        news.setCreatedUser( d.getCreatedUser() );

        return news;
    }

    @Override
    public List<News> toListEntity(List<NewsDto> d) {
        if ( d == null ) {
            return null;
        }

        List<News> list = new ArrayList<News>( d.size() );
        for ( NewsDto newsDto : d ) {
            list.add( toEntity( newsDto ) );
        }

        return list;
    }

    @Override
    public List<NewsDto> toListDto(List<News> e) {
        if ( e == null ) {
            return null;
        }

        List<NewsDto> list = new ArrayList<NewsDto>( e.size() );
        for ( News news : e ) {
            list.add( toDto( news ) );
        }

        return list;
    }
}
