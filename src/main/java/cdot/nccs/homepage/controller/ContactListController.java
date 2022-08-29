package cdot.nccs.homepage.controller;
import cdot.nccs.homepage.dto.ContactListDto;
import cdot.nccs.homepage.dto.ContactListDtoWrap;
import cdot.nccs.homepage.repository.ContactListRepository;
import cdot.nccs.homepage.service.ContactListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/home/contactlist")
public class ContactListController {
    @Autowired
    ContactListService contactListService;
    private static String flag="login";
    private static String real_name="Undefined";
    private String oneO="<h5>National Centre for Communication Security</h5>\n" +
            "        <h6>Department of Telecommunications<br> Government of India</h6>";
    @GetMapping("/")
    public List<ContactListDto> showContactList() {
        return contactListService.findAll();
    }
    
    @PutMapping({"/update"})
    public String saveContacts(@ModelAttribute("contactWrap") ContactListDtoWrap ContactWrap) {
        contactListService.SaveAllContacts(ContactWrap.getContacts());
        return "redirect:/home/contactlist/1";
    }
    
    @PostMapping("/save")
	public String saveEmp(@ModelAttribute("newContact") ContactListDto dto){
    	contactListService.save(dto);
		return "redirect:/home/contactlist/1";
	}
	
	@GetMapping({"/create"})
	public String createRecord(Model model) {
		model.addAttribute("contactList",contactListService.findAll());
		ContactListDto contact=new ContactListDto();
		model.addAttribute("flag","logout");
		model.addAttribute("newContact",contact);
        model.addAttribute("contactList",contactListService.findAll());
        model.addAttribute("oneO","NCCS");
        model.addAttribute("real_name","C-DOT");
		return "addDirectory.html";
	}
	
	@GetMapping({"/crud"})
	public String editRecords(Model model) {
        List<ContactListDto> contacts= new ArrayList<>();
        contactListService.findAll().iterator().forEachRemaining(contacts::add);
        model.addAttribute("contactWrap", new ContactListDtoWrap(contacts));
        model.addAttribute("flag","logout");
        model.addAttribute("oneO","Hmm");
        model.addAttribute("real_name","Undefined");
        return "editDirectory.html";
	}
	/*Delete mapping not working through browser control*/
	/*@DeleteMapping({"/delete/{id}"})*/
    @GetMapping({"/delete/{id}"})
    public String deleteRecord(@PathVariable (value="id") long id) {
		contactListService.delete(id);
		return "redirect:/home/contactlist/crud";
	}

    @GetMapping({"/{pageNo}"})
    public String directoryHandler(@PathVariable(value="pageNo")int pageNo, Model model) {
        int pageSize=6;
        Page<ContactListDto> page = contactListService.findAllPaginated(pageNo, pageSize);
        List<ContactListDto> contactList=page.getContent();
        model.addAttribute("currPg", pageNo);
        model.addAttribute("contactList",contactList);
        model.addAttribute("totalPg", page.getTotalPages());
        model.addAttribute("totalItm",page.getTotalElements());
        model.addAttribute("flag",flag);
        model.addAttribute("oneO",oneO);
        model.addAttribute("real_name",real_name);
        return "directory.html";
    }
}
