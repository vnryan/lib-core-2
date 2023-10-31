package vn.ryan.entity.core.mapper;

import org.mapstruct.Mapper;
import vn.ryan.core.mapper.EntityMapper;
import vn.ryan.entity.core.dto.FileDto;
import vn.ryan.entity.core.entities.File;

@Mapper
public interface FileMapper extends EntityMapper<File, FileDto> {
}
