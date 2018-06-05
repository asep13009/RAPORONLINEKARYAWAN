package com.example.cobajpa.controller.admin;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cobajpa.model.Karyawan;
import com.example.cobajpa.model.Login;
import com.example.cobajpa.service.admin.DepartemenService;
import com.example.cobajpa.service.admin.JabatanService;
import com.example.cobajpa.service.admin.KaryawanService;
		

@Controller
public class KaryawanController {
	@Autowired
	private KaryawanService karyawanService;
	@Autowired
	private DepartemenService departemenService;
	@Autowired
	private JabatanService jabatanService;
	
	
	
	@RequestMapping(value="karyawan.html",method=RequestMethod.GET)
	public ModelAndView goKaryawan(@ModelAttribute("karyawan") Karyawan karyawan) {
		return new ModelAndView("admin/karyawan","listkaryawan",karyawanService.getAllKaryawan());
		
	}
	
	@RequestMapping(value="insertkaryawan.html",method=RequestMethod.GET)
	public ModelAndView  goformInsert(@ModelAttribute("karyawan") Karyawan karyawan) {
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("listkaryawan", karyawanService.getAllKaryawan());
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("jabatanlist", jabatanService.getAllJabatan());
		modelAndView.setViewName("admin/insertkaryawan");
		
		return modelAndView;
	}
	
	
	private String saveDirectory = "C:/Users/ASEP/Documents/workspace-sts-3.9.4.RELEASE/cobaRO/src/main/resources/static/images/user/";
	@RequestMapping(value="insertkaryawan.html",method=RequestMethod.POST)
	private String goInsertKaryawan(@ModelAttribute("karyawan") Karyawan karyawan,@ModelAttribute("login") Login login,
	        @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(saveDirectory +file.getOriginalFilename());
			Files.write(path, bytes);
			karyawan.setPhotoUser(file.getOriginalFilename());
			karyawanService.SaveOrUpdateKaryawan(karyawan,login);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return "redirect:karyawan.html";
	}
	
	 	
	String saveDirectory1="images/user/";
	@RequestMapping(value ="updatekaryawan.html",method=RequestMethod.GET)
    public ModelAndView formUpdateKaryawan(@RequestParam("id") int id,MultipartFile file){
		Karyawan karyawan = karyawanService.getByIdKaryawan(id);
		String pathkaryawan = karyawan.getPhotoUser();
		Path path = Paths.get(saveDirectory1 + pathkaryawan);
		
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("karyawan",karyawan);
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("jabatanlist", jabatanService.getAllJabatan());
		modelAndView.addObject("sama", karyawan.getDepartemen().getId());
		modelAndView.addObject("samajab", karyawan.getJabatan().getId());
		modelAndView.addObject("foto", path);
		modelAndView.setViewName("admin/updatekaryawan");
        return modelAndView;
    }
	
	@RequestMapping(value ="updatekaryawan.html",method=RequestMethod.POST)
    public String procesUpdateKaryawan(@ModelAttribute("karyawan") Karyawan karyawan, @RequestParam("poto") MultipartFile file, RedirectAttributes redirectAttributes){
		try {
			if (file != null) {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(saveDirectory +file.getOriginalFilename());
				Files.write(path, bytes);
				karyawan.setPhotoUser(file.getOriginalFilename());
			}else {
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		karyawanService.SaveOrUpdateKaryawan1(karyawan);
        return "redirect:karyawan.html"; 	 	
    }
	
	@RequestMapping(value ="viewkaryawan.html",method=RequestMethod.GET)
    public ModelAndView formViewKaryawan(@RequestParam("id") int id){
		Karyawan karyawan= karyawanService.getByIdKaryawan(id);
//		String pathkaryawan = karyawan.getPhotoUser();
//		Path path = Paths.get(saveDirectory + pathkaryawan);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("karyawan", karyawan);
		modelAndView.addObject("departemenlist", karyawan.getDepartemen());
		modelAndView.addObject("jabatanlist", karyawan.getJabatan());/*
		modelAndView.addObject("departemenlist", departemenService.getAll());
		modelAndView.addObject("jabatanlist", jabatanService.getAllJabatan());*/
//		modelAndView.addObject("foto", path);
		modelAndView.setViewName("admin/viewkaryawan");
        return modelAndView;
    }
	

	@RequestMapping(value="deletekaryawan")
	public String deleteKary(@RequestParam("id") int id){
		karyawanService.deleteIDKaryawan(id);
		return "redirect:karyawan.html";
    }
	
	
}
