package org.hardcrystal.food.model;

/**
 * Created by Administrator on 26.12.2015.
 */

public class Dishes {

    private int id_dish;
    private String name;
    private int calories;
    private String list;
    private String process;

    public Dishes() {
    }

    public int getId_dish() {
        return id_dish;
    }

    public void setId_dish(int id_dish) {
        this.id_dish = id_dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id_dish=" + id_dish +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", list='" + list + '\'' +
                ", process='" + process + '\'' +
                '}';
    }


}
