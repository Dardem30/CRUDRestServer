package by.controller;

import by.model.User;
import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Роман on 30.08.2017.
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView("index");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return modelAndView;
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registrationUser(Model model){
        model.addAttribute("userForm",new User());
        return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registrationUser(@ModelAttribute("userForm")User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
}
