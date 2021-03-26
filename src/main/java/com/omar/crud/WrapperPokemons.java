package com.omar.crud;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class WrapperPokemons {
    private List<Pokemon> pokemons;
    public final static Random random = new Random();
    public static final String[] NAMES = {"Jordi", "Isabel", "Omar", "Sam", "Ilona", "Ivanildo", "Ozan", "Douwe", "Shani", "Stan", "Eyse", "Saphira"};

    public void addPokemone(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public WrapperPokemons() {
        pokemons = new ArrayList<>();
    }

    public Pokemon getRandom() {
        Pokemon temp = new Pokemon();
        temp.setHealth(random.nextInt(200) + 1);
        temp.setLevel(random.nextInt(20) + 1);
        temp.setStrength(random.nextInt(200) + 1);
        temp.setName(NAMES[random.nextInt(NAMES.length)]);

        return temp;
    }

}
