package vn.ryan.entity.core.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.QuestionDto;
import vn.ryan.entity.core.entities.Question;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public QuestionDto toDto(Question e) {
        if ( e == null ) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();

        questionDto.setId( e.getId() );
        questionDto.setName( e.getName() );
        questionDto.setTitle( e.getTitle() );
        questionDto.setShortDescription( e.getShortDescription() );
        questionDto.setThumbnail( e.getThumbnail() );
        questionDto.setTag( e.getTag() );
        questionDto.setQuestionContent( e.getQuestionContent() );
        questionDto.setAnswers( e.getAnswers() );
        questionDto.setMetaDataVersion( e.getMetaDataVersion() );
        questionDto.setResponseInteractionType( e.getResponseInteractionType() );
        questionDto.setPlatformId( e.getPlatformId() );
        questionDto.setIsActive( e.getIsActive() );
        questionDto.setCreatedBy( e.getCreatedBy() );
        if ( e.getCreatedAt() != null ) {
            questionDto.setCreatedAt( new Date( e.getCreatedAt().getTime() ) );
        }
        if ( e.getUpdatedAt() != null ) {
            questionDto.setUpdatedAt( new Date( e.getUpdatedAt().getTime() ) );
        }

        return questionDto;
    }

    @Override
    public Question toEntity(QuestionDto d) {
        if ( d == null ) {
            return null;
        }

        Question question = new Question();

        question.setId( d.getId() );
        question.setCreatedAt( d.getCreatedAt() );
        question.setUpdatedAt( d.getUpdatedAt() );
        question.setName( d.getName() );
        question.setTitle( d.getTitle() );
        question.setShortDescription( d.getShortDescription() );
        question.setThumbnail( d.getThumbnail() );
        question.setTag( d.getTag() );
        question.setQuestionContent( d.getQuestionContent() );
        question.setAnswers( d.getAnswers() );
        question.setMetaDataVersion( d.getMetaDataVersion() );
        question.setResponseInteractionType( d.getResponseInteractionType() );
        question.setPlatformId( d.getPlatformId() );
        question.setIsActive( d.getIsActive() );
        question.setCreatedBy( d.getCreatedBy() );

        return question;
    }

    @Override
    public List<Question> toListEntity(List<QuestionDto> d) {
        if ( d == null ) {
            return null;
        }

        List<Question> list = new ArrayList<Question>( d.size() );
        for ( QuestionDto questionDto : d ) {
            list.add( toEntity( questionDto ) );
        }

        return list;
    }

    @Override
    public List<QuestionDto> toListDto(List<Question> e) {
        if ( e == null ) {
            return null;
        }

        List<QuestionDto> list = new ArrayList<QuestionDto>( e.size() );
        for ( Question question : e ) {
            list.add( toDto( question ) );
        }

        return list;
    }
}
