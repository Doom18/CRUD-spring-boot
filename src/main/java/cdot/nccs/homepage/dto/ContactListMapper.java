package cdot.nccs.homepage.dto;
import cdot.nccs.homepage.model.ContactList;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactListMapper {
    ContactListMapper INSTANCE = Mappers.getMapper(ContactListMapper.class);
    ContactListDto directoryToDirectoryDto(ContactList entity);
    ContactList directoryDtoToDirectory(ContactListDto dto);
}

