package ru.anikeeva.secondweek.dao;

import ru.anikeeva.secondweek.models.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerDAO {
    public static int MANAGER_COUNT;
    private List<Manager> managers;

    {
        managers = new ArrayList<Manager>();
        managers.add(new Manager(++MANAGER_COUNT, "Grigoriy", "Ovechkin", 35, 10));
        managers.add(new Manager(++MANAGER_COUNT, "Mikhail", "Bolshakov", 39, 18));
        managers.add(new Manager(++MANAGER_COUNT, "Elena", "Rubleva", 32, 8));
    }

    public List<Manager> index(){
        return managers;
    }

    public Manager show(int id){
        return managers.stream().filter(manager -> manager.getId() == id).findAny().orElse(null);
    }

    public void save(Manager manager){
        manager.setId(++MANAGER_COUNT);
        managers.add(manager);
    }

    public void update(int id, Manager updatedmanager){
        Manager managerToUpdated = show(id);
        managerToUpdated.setName(updatedmanager.getName());
        managerToUpdated.setSurname(updatedmanager.getSurname());
        managerToUpdated.setAge(updatedmanager.getAge());
        managerToUpdated.setExperience(updatedmanager.getExperience());
    }

    public void delete(int id){
        managers.removeIf(m -> m.getId() == id);
    }
}
