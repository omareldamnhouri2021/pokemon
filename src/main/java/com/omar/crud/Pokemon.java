package com.omar.crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Name is mandatory")
    private String name;

  //  @NotBlank(message = "Level is mandatory")
    private int level;

   // @NotBlank(message = "Health is mandatory")
    private int health;

  //  @NotBlank(message = "Strength is mandatory")
    private int strength;

    public Pokemon() {}

    public Pokemon(String name, int level, int health, int strength) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.strength = strength;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }

    public int getStrength(){
        return strength;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", name=" + name + ", level=" + level + ", health=" + health + ",  strength=" + strength +'}';
    }
}