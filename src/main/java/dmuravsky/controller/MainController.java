package dmuravsky.controller;

import dmuravsky.dao.RoleDAO;
import dmuravsky.model.Role;
import dmuravsky.model.User;
import dmuravsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleDAO roleDAO;

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "/showUsers";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("login") String login,
                          @RequestParam("pass") String password,
                          @RequestParam("role") String role) {
        User user = new User(name, login, password);
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleByName(role));
        user.setRoles(roles);
        userService.addUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id, Model model) {
        User user = userService.getOneUserById(id);
        model.addAttribute("name", user.getName());
        model.addAttribute("id", user.getId());
        return "/delete";
    }

    @PostMapping(value = "/admin/delete/")
    public String deleteUser(@RequestParam("id") int id) {
        User user = userService.getOneUserById(id);
        userService.deleteUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getOneUserById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @PostMapping("/admin/edit/")
    public String editUser(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("role") String role) {
        User user = new User(name, login, password);
        user.setId(id);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getRoleByName(role));
        user.setRoles(roles);
        userService.updateUser(user);
        return "redirect:/admin/users";
    }
}
