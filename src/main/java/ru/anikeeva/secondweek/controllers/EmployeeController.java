package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.dao.EmployeeDAO;
import ru.anikeeva.secondweek.models.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employee", employeeDAO.index());
        return "employees/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeDAO.show(id));
        return "employees/show";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/new";
    }

    @PostMapping
    public String create(@ModelAttribute("employee") Employee employee) {
        employeeDAO.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit( Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeDAO.show(id));
        return "employees/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id) {
        employeeDAO.update(id, employee);
        return "redirect:/employees";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        employeeDAO.delete(id);
        return "redirect:/employees";
    }
}
