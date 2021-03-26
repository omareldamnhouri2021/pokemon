package com.omar.crud;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
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

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", name=" + name + ", level=" + level + ", health=" + health + ",  strength=" + strength +'}';
    }
}