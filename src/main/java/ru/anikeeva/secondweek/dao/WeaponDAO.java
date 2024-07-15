package ru.anikeeva.secondweek.dao;

import org.springframework.stereotype.Component;
import ru.anikeeva.secondweek.models.Weapon;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponDAO {
    public static int WEAPONS_COUNT;
    private List<Weapon> weapons;

    {
        weapons = new ArrayList<>();

        weapons.add(new Weapon(++WEAPONS_COUNT, "colt", "revolver", 6));
        weapons.add(new Weapon(++WEAPONS_COUNT, "barrett", "rifle", 2));
        weapons.add(new Weapon(++WEAPONS_COUNT, "HK GMG", "grenade launcher", 1));
        weapons.add(new Weapon(++WEAPONS_COUNT, "FN SCAR", "gun", 30));
        weapons.add(new Weapon(++WEAPONS_COUNT, "Benelli M4 Super 90", "shotgun", 4));

    }

    public List<Weapon> index(){
        return weapons;
    }

    public Weapon show(int id){
        return weapons.stream().filter(weapon -> weapon.getId() == id).findAny().orElse(null);
    }

    public void save(Weapon weapon){
        weapon.setId(++WEAPONS_COUNT);
        weapons.add(weapon);
    }

    public void update(int id, Weapon updatedWeapon){
        Weapon weaponToBeUpdated = show(id);

        weaponToBeUpdated.setName(updatedWeapon.getName());
        weaponToBeUpdated.setType(updatedWeapon.getType());
        weaponToBeUpdated.setMagazineSize(updatedWeapon.getMagazineSize());
    }

    public void delete(int id){
        weapons.removeIf(w -> w.getId() == id);
    }

}
