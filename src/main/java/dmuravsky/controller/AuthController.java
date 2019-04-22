package dmuravsky.controller;

import dmuravsky.dao.RoleDAO;
import dmuravsky.model.Role;
import dmuravsky.model.User;
import dmuravsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "/auth/signIn", method = RequestMethod.GET)
    public String SignIn() {
        return "/signIn";
    }


    @RequestMapping(value = "/user/accountInfo", method = RequestMethod.GET)
    public String accountInfo(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "/accountInfo";
    }

    @RequestMapping(value = "/auth/signUp", method = RequestMethod.GET)
    public String signUp() {
        return "/signUp";
    }

    @PostMapping(value = "/auth/signUp")
    public String signUp(@RequestParam("name") String name,
                         @RequestParam("login") String login,
                         @RequestParam("password") String password) {
        User user = new User(name, login, password);
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleByName("user"));
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/auth/signIn";
    }
}
