package org.numismat.springboot.controller;

import org.numismat.springboot.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainWebController {

	@Autowired
    private CoinMapper mapper;
     
	@GetMapping(value = {"/","/index"})
    public String index(Model model) {
//		model.addAttribute("coins", mapper.getAllCoins());
        return "index";
    }

    /*@GetMapping("/login")
    public String login() {
        return "login";
    }*/
	
	@RequestMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
       /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("username", name);
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        model.addAttribute("username", name);*/
        return "login";
    }
}