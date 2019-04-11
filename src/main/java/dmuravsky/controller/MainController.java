package dmuravsky.controller;

import dmuravsky.model.User;
import dmuravsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "showUsers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping(value = "/addSave")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("login") String login,
                          @RequestParam("pass") String password) {
        User user = new User(name, login, password);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute("name", user.getName());
        model.addAttribute("id", user.getId());
        return "delete";
    }

    @PostMapping(value = "/deleteSave")
    public String deleteUserSave(@RequestParam("id") int id) {
        User user = userService.getOne(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getOne(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/editSave")
    public String editUserSave(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("login") String login,
                               @RequestParam("pass") String password) {
        User user = new User(name, login, password);
        user.setId(id);
        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/users";
    }
}
