package cdot.nccs.homepage.controller;

import cdot.nccs.homepage.model.User;
import cdot.nccs.homepage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/*@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String showHomePage(){
        return "index.html";
    }
}*/

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	UserService us;
	private static String flag="login";
	private static String real_name="Undefined";
	private String oneO="<h5>National Centre for Communication Security</h5>\n" + 
			"        <h6>Department of Telecommunications<br> Government of India</h6>";
	
	@GetMapping({"/","/index","/index.html"})
	public String indexHandler(Model model) {
		String testLabNo="4";
		String certi="3";
		String version="3.050506";
		model.addAttribute("oneO",oneO);
		model.addAttribute("testLabNo",testLabNo);
		model.addAttribute("certi",certi);
		model.addAttribute("version",version);
		model.addAttribute("flag",flag);
		return "index.html";
	}
	
	@GetMapping({"/about.html"})
	public String itsarHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "about.html";
	}

	@GetMapping({"/SAS.html"})
	public String SASHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "SAS.html";
	}

	@GetMapping({"/SLR.html"})
	public String SLRHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "SLR.html";
	}

	@GetMapping({"/SC.html"})
	public String SCHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "SC.html";
	}

	@GetMapping({"/team.html"})
	public String teamHandler() {
		return "team";
	}
	
	@GetMapping({"/testimonials.html"})
	public String equipHandler() {
		return "testimonials";
	}
	
	@GetMapping({"/services.html"})
	public String servicesHandler() {
		return "services";
	}
	
	@GetMapping({"/portfolio.html"})
	public String portfolioHandler() {
		return "portfolio";
	}
	
	@GetMapping({"/gallery.html"})
	public String galleryHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "gallery.html";
	}
	
	@GetMapping({"/vacancy.html"})
	public String vacancyHandler(Model model) {
		model.addAttribute("flag",flag);
		model.addAttribute("oneO",oneO);
		return "vacancy.html";
	}

	@GetMapping({"/logout.html"})
	public String logout() {
		flag="login";
		real_name="Undefined";
		return "redirect:/home/login.html";
	}

	@PostMapping("/searchUser")
	public String searchUser(@ModelAttribute("user")User u) {
		User a = us.getUserById(u.getName());
		User b = us.getUserByMail(u.getName());
		if(a!=null) {
			if(a.getPassword().equals(u.getPassword())) {
				flag="logout";
				real_name=a.getReal_name();
				return "redirect:/home/";
			}
		}
		//Email check for login
		if(b!=null)
			if(b.getPassword().equals(u.getPassword())) {
				flag="logout";
				return "redirect:/home/";
			}
		return "redirect:/home/login.html";
	}

	@GetMapping({"/login.html"})
	public String loginHandler(Model m) {
		if(flag=="logout") {
			return "logout.html";
		}
		User u= new User();
		m.addAttribute(u);
		return "login.html";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user){
		us.saveUser(user);
		return "redirect:/home/login.html";
	}

	@GetMapping("/register.html")
	public String register(Model m) {
		User u = new User();
		m.addAttribute("user",u);
		return "register.html";
	}
}
