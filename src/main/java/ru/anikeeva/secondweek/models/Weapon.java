package ru.anikeeva.secondweek.models;

public class Weapon {
    private int id;
    private String name;
    private String type;
    private int magazineSize;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    public Weapon(int id, String name, String type, int magazineSize) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.magazineSize = magazineSize;
    }
}
