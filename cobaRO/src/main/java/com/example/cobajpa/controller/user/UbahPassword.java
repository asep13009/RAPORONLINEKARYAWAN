package com.example.cobajpa.controller.user;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class UbahPassword {
	@RequestMapping(value="gantipass.html")
	public String goGantiPass() {
		return "user/gantipass";
	}
	
	/*@RequestMapping(value = "gantipass.html" , method = RequestMethod.POST)
	public @ResponseBody String principalchangepassword(Model uiModel, HttpServletRequest httpServletRequest){
	    Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    Principal me = Principal.findPrincipal(principal.getId());
	    me.setPassword(httpServletRequest.getParameter("password1"));
	    StandardStringDigester digester = new StandardStringDigester();
	    digester.setAlgorithm("SHA-256");   // optionally set the algorithm
	    digester.setStringOutputType("hexadecimal");
	    digester.setSaltSizeBytes(0);
	    digester.setIterations(1);
	    String digest = digester.digest(me.getPassword());
	    me.setPassword(digest.toLowerCase());
	    me.merge();
	    return "Password Updated successfully";
	}*/
}
