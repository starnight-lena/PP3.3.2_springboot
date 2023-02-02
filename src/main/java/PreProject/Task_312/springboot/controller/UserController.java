package PreProject.Task_312.springboot.controller;

import PreProject.Task_312.springboot.model.User;
import PreProject.Task_312.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "show";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String getCreationUserForm(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String updateUser(@ModelAttribute("id") Long id, Model model) {
        model.addAttribute("user", userService.getOneUser(id));
        return "edit";
    }


    @PatchMapping("/{id}")
    public String getUpdateUserForm(@ModelAttribute("user") @Valid User updateuser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userService.updateUser(updateuser);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
