package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.TopicDto;
import vn.ryan.entity.core.entities.Topic;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class TopicMapperImpl implements TopicMapper {

    @Override
    public TopicDto toDto(Topic e) {
        if ( e == null ) {
            return null;
        }

        TopicDto topicDto = new TopicDto();

        topicDto.setId( e.getId() );
        topicDto.setName( e.getName() );
        topicDto.setSlug( e.getSlug() );
        topicDto.setIsActive( e.getIsActive() );
        topicDto.setDescription( e.getDescription() );
        topicDto.setGradeId( e.getGradeId() );
        if ( e.getCreatedAt() != null ) {
            topicDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            topicDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return topicDto;
    }

    @Override
    public Topic toEntity(TopicDto d) {
        if ( d == null ) {
            return null;
        }

        Topic topic = new Topic();

        topic.setId( d.getId() );
        topic.setCreatedAt( d.getCreatedAt() );
        topic.setUpdatedAt( d.getUpdatedAt() );
        topic.setName( d.getName() );
        topic.setSlug( d.getSlug() );
        topic.setIsActive( d.getIsActive() );
        topic.setDescription( d.getDescription() );
        topic.setGradeId( d.getGradeId() );

        return topic;
    }

    @Override
    public List<Topic> toListEntity(List<TopicDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Topic> list = new ArrayList<Topic>( d.size() );
        for ( TopicDto topicDto : d ) {
            list.add( toEntity( topicDto ) );
        }

        return list;
    }

    @Override
    public List<TopicDto> toListDto(List<Topic> e) {
        if ( e == null ) {
            return null;
        }

        List<TopicDto> list = new ArrayList<TopicDto>( e.size() );
        for ( Topic topic : e ) {
            list.add( toDto( topic ) );
        }

        return list;
    }
}
