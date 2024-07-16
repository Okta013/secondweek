package ru.anikeeva.secondweek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.dao.EmployeeDAO;
import ru.anikeeva.secondweek.dao.ManagerDAO;
import ru.anikeeva.secondweek.models.Manager;

@Controller
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerDAO managerDAO;
    private final EmployeeDAO employeeDAO;

    @Autowired
    public ManagerController(ManagerDAO managerDAO, EmployeeDAO employeeDAO) {
        this.managerDAO = managerDAO;
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("manager", managerDAO.index());
        return "managers/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
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

    @GetMapping("/managers/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("manager", managerDAO.show(id));
        return "managers/edit";
    }

    @PatchMapping("/managers/{id}")
    public String update(@ModelAttribute("manager") Manager manager, @PathVariable("id") int id) {
        managerDAO.update(id, manager);
        return "redirect:/managers";
    }

    @DeleteMapping("/managers/{id}")
    public String delete(@PathVariable("id") int id){
        managerDAO.delete(id);
        return "redirect:/managers";
    }
}
