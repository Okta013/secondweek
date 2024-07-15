package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.dao.ManagerDAO;
import ru.anikeeva.secondweek.models.Manager;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    public final ManagerDAO managerDAO;

    public ManagerController(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("manager", managerDAO.index());
        return "managers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("manager", managerDAO.show(id));
        return "managers/show";
    }

    @GetMapping("/new")
    public String newManager(Model model) {
        model.addAttribute("manager", new Manager());
        return "managers/new";
    }

    @PostMapping
    public String create(@ModelAttribute("manager") Manager manager) {
        managerDAO.save(manager);
        return "redirect:/managers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("manager", managerDAO.show(id));
        return "managers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("manager") Manager manager, @PathVariable("id") int id) {
        managerDAO.update(id, manager);
        return "redirect:/managers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        managerDAO.delete(id);
        return "redirect:/managers";
    }
}
