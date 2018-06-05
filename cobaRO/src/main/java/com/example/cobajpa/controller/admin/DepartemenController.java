package com.example.cobajpa.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.cobajpa.model.Departemen;
import com.example.cobajpa.service.admin.DepartemenService;

@Controller
public class DepartemenController {
	@Autowired
	public DepartemenService departemenService;


/*	    @ModelAttribute(value = "departemen.html")
	    public Departemen construct() {
	        return new Departemen();
	    }

	    @ResponseBody
	    @RequestMapping(value = "/departemen.html/{id}", method = RequestMethod.GET)
	    public Departemen loadEntity(@PathVariable("id") Long id) {
	        return departemenService.getById(id);
	    }

	    @ResponseBody
	    @RequestMapping(value = "/departemen.html")
	    public List<Departemen> loadSomethingTable() {
	        return departemenService.getAll();
	    }

	    @RequestMapping(value = "departemen.html", method = RequestMethod.GET)
	    public ModelAndView list() {
	        return new ModelAndView("admin/departemen", "somethings", departemenService.getAll());
	    }

	    @RequestMapping(value = "departemen.html", method = RequestMethod.GET)
	    public ModelAndView create() {
	        return new ModelAndView("admin/departemen");
	    }

	    @RequestMapping(value = "departemen.html", method = RequestMethod.POST)
	    public void create(@ModelAttribute(value = "something") Departemen something) {
	        departemenService.SaveOrUpdate(something);
	    }

	    @ResponseBody
	    @RequestMapping(value = "departemen.html", method = RequestMethod.POST)
	    public void update(@ModelAttribute("something") Departemen something) {
	    	departemenService.SaveOrUpdate(something);
	    }

	    @ResponseBody
	    @RequestMapping(value = "departemen.html/{id}", method = RequestMethod.POST)
	    public void delete(@PathVariable("id") Long id) {
	        departemenService.deleteID(id);
	    */

	 /*   @PostConstruct
	    public void initDataForTesting() {
	        String[] names = {
	          "Rob", "Jon", "Tom"
	        };
	        List<Departemen> somethingList = new ArrayList<>();
	        for (int i = 0; i < names.length; ++i) {
	            Departemen s = new Departemen();
	            s.setId((long) (i + 1));
	            s.setNamaDepartemen(names[i]);
	            somethingList.add(s);
	        }
	        departemenService.SaveOrUpdate(somethingList);
	    }*/
//	}
	
	@RequestMapping(value="/departemen.html/{id}")
	public String getID(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departemen", departemenService.getById(id));
		return "modal:departemen.html :: modalContents";
	}
	
	@RequestMapping(value="departemen.html",method=RequestMethod.GET)
	public ModelAndView goDepartemen(@ModelAttribute("departemen") Departemen departemen) {
		ModelAndView modelAndView = new  ModelAndView();
		modelAndView.addObject("listdepartemen",departemenService.getAll());
		modelAndView.setViewName("admin/departemen");
		return modelAndView;
	}
	@RequestMapping(value="departemen.html",method=RequestMethod.POST)
	public ModelAndView goAfterInsertDepartemen(@ModelAttribute("departemen") Departemen departemen) {
		return new ModelAndView("admin/departemen","listdepartemen",departemenService.getAll());
	}
	
	@RequestMapping(value ="updatedepartemen.html",method=RequestMethod.GET)
    public ModelAndView formUpdateDepartemen(@RequestParam("id") int id){
        return new ModelAndView("admin/departemen","listdepartemen",departemenService.getById(id));
    }
	@RequestMapping(value ="updatedepartemen.html",method=RequestMethod.POST)
    public String insertUpdateDepartemen(@ModelAttribute("departemen")Departemen departemen){
        departemenService.SaveOrUpdate(departemen);
        return "redirect:departemen.html";
    }
	@RequestMapping(value="deletedepartemen.html")
	public String deleteDepartemen(@RequestParam("id") int id){
		departemenService.deleteID(id);//delete nanti status. bukan delete
		return "redirect:departemen.html";
    }
	
	@RequestMapping(value ="insertdepartemen.html",method=RequestMethod.POST)
    public String insertDepartemen(@ModelAttribute("departemen")Departemen departemen){
		departemenService.SaveOrUpdate(departemen);
        return "redirect:departemen.html";
    }
}
