package vn.ryan.entity.core.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import vn.ryan.entity.core.dto.FileDto;
import vn.ryan.entity.core.entities.File;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-31T08:31:45+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class FileMapperImpl implements FileMapper {

    @Override
    public FileDto toDto(File e) {
        if ( e == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setId( e.getId() );
        fileDto.setName( e.getName() );
        fileDto.setDescription( e.getDescription() );
        fileDto.setType( e.getType() );
        fileDto.setPathFile( e.getPathFile() );
        fileDto.setIsActive( e.getIsActive() );
        fileDto.setCreatedAt( e.getCreatedAt() );
        fileDto.setUpdatedAt( e.getUpdatedAt() );

        return fileDto;
    }

    @Override
    public File toEntity(FileDto d) {
        if ( d == null ) {
            return null;
        }

        File file = new File();

        file.setId( d.getId() );
        file.setName( d.getName() );
        file.setDescription( d.getDescription() );
        file.setType( d.getType() );
        file.setPathFile( d.getPathFile() );
        file.setIsActive( d.getIsActive() );
        file.setCreatedAt( d.getCreatedAt() );
        file.setUpdatedAt( d.getUpdatedAt() );

        return file;
    }

    @Override
    public List<File> toListEntity(List<FileDto> d) {
        if ( d == null ) {
            return null;
        }

        List<File> list = new ArrayList<File>( d.size() );
        for ( FileDto fileDto : d ) {
            list.add( toEntity( fileDto ) );
        }

        return list;
    }

    @Override
    public List<FileDto> toListDto(List<File> e) {
        if ( e == null ) {
            return null;
        }

        List<FileDto> list = new ArrayList<FileDto>( e.size() );
        for ( File file : e ) {
            list.add( toDto( file ) );
        }

        return list;
    }
}
