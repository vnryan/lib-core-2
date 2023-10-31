package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.TagDto;
import vn.ryan.entity.core.entities.Tag;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDto toDto(Tag e) {
        if ( e == null ) {
            return null;
        }

        TagDto tagDto = new TagDto();

        tagDto.setId( e.getId() );
        tagDto.setName( e.getName() );
        tagDto.setDescription( e.getDescription() );
        tagDto.setIsActive( e.getIsActive() );
        if ( e.getCreatedAt() != null ) {
            tagDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            tagDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return tagDto;
    }

    @Override
    public Tag toEntity(TagDto d) {
        if ( d == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( d.getId() );
        tag.setCreatedAt( d.getCreatedAt() );
        tag.setUpdatedAt( d.getUpdatedAt() );
        tag.setName( d.getName() );
        tag.setDescription( d.getDescription() );
        tag.setIsActive( d.getIsActive() );

        return tag;
    }

    @Override
    public List<Tag> toListEntity(List<TagDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( d.size() );
        for ( TagDto tagDto : d ) {
            list.add( toEntity( tagDto ) );
        }

        return list;
    }

    @Override
    public List<TagDto> toListDto(List<Tag> e) {
        if ( e == null ) {
            return null;
        }

        List<TagDto> list = new ArrayList<TagDto>( e.size() );
        for ( Tag tag : e ) {
            list.add( toDto( tag ) );
        }

        return list;
    }
}
