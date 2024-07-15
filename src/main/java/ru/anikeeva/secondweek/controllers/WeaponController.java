package ru.anikeeva.secondweek.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.anikeeva.secondweek.dao.WeaponDAO;

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
}
