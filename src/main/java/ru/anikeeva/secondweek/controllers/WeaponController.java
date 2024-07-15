package ru.anikeeva.secondweek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.dao.WeaponDAO;
import ru.anikeeva.secondweek.models.Weapon;

@Controller
@RequestMapping("/weapon")
public class WeaponController {

    private final WeaponDAO weaponDAO;

    public WeaponController(WeaponDAO weaponDAO) {
        this.weaponDAO = weaponDAO;
    }

    @GetMapping()
    public String index(Model model){
        //Получение оружия из дао и передача на представление
        model.addAttribute("weapons", weaponDAO.index());
        return ("weapon/index");
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        //Получаем 1 оружие по айди из дао и передаем на представление
        model.addAttribute("weapons", weaponDAO.show(id));
        return("weapon/show");
    }

    @GetMapping("/new")
    public String newWeapon(Model model){
        model.addAttribute("weapon", new Weapon());
        return "weapon/new";
    }

    @PostMapping
    public String create(@ModelAttribute("weapon") Weapon weapon){
        weaponDAO.save(weapon);
        return"redirect:/weapon";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("weapon", weaponDAO.show(id));
        return"weapon/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("weapon") Weapon weapon, @PathVariable("id") int id){
        weaponDAO.update(id, weapon);
        return"redirect:/weapon";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        weaponDAO.delete(id);
        return"redirect:/weapon";
    }

}
