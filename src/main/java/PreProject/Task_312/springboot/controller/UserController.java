package PreProject.Task_312.springboot.controller;

import PreProject.Task_312.springboot.dao.UserDao;
import PreProject.Task_312.springboot.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserDao userDAO;

    @Autowired
    public UserController(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.listUsers());
        return "index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userDAO.getById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";

        userDAO.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@ModelAttribute("id") Long id, Model model) {
        model.addAttribute("user", userDAO.getById(id));
        return "edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User updateuser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "edit";

        userDAO.update(updateuser);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userDAO.removeById(id);
        return "redirect:/";
    }


}
