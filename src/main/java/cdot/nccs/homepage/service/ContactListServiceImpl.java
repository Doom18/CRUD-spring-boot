package cdot.nccs.homepage.service;
import cdot.nccs.homepage.dto.ContactListDto;
import cdot.nccs.homepage.dto.ContactListMapper;
import cdot.nccs.homepage.model.ContactList;
import cdot.nccs.homepage.repository.ContactListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactListServiceImpl implements ContactListService {
    @Autowired
    ContactListRepository contactListRepository;
    @Override
    public List<ContactListDto> findAll() {
        return contactListRepository.findAll().stream()
                .map(ContactListMapper.INSTANCE::directoryToDirectoryDto)
                .collect(Collectors.toList());
    }
    @Override
    public Page<ContactListDto> findAllPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return contactListRepository.findAll(pageable)
                .map(ContactListMapper.INSTANCE::directoryToDirectoryDto);
    }
	@Override
	public void save(ContactListDto dto) {
		contactListRepository.save(ContactListMapper.INSTANCE.directoryDtoToDirectory(dto));
	}
	@Override
	public ContactList getContactById(long id) {
		Optional<ContactList> optional=contactListRepository.findById(id);
		ContactList contact=null;
		if(optional.isPresent()) {
			contact=optional.get();
		}
		return contact;
	}
	@Override
	public void delete(long id) {
		this.contactListRepository.deleteById(id);
	}

	@Override
	public void SaveAllContacts(List<ContactListDto> contacts) {
		for(int i=0; i<contacts.size(); i++)
			contactListRepository.save(ContactListMapper.INSTANCE.directoryDtoToDirectory(contacts.get(i)));
	}

}
