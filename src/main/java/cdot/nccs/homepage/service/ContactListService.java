package cdot.nccs.homepage.service;
import cdot.nccs.homepage.dto.ContactListDto;
import cdot.nccs.homepage.model.ContactList;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ContactListService {
    public List<ContactListDto> findAll();
    Page<ContactListDto> findAllPaginated(int pageNo, int pageSize);
    void save(ContactListDto dto);
    ContactList getContactById(long id);
	void delete(long id);
    void SaveAllContacts(List<ContactListDto> contacts);
}
