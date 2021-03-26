package com.omar.crud;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class PokemonsDto {
    private List<Pokemon> pokemons;
    public final static Random random = new Random();
    public static final String[] NAMES = {"Jordi", "Isabel", "Omar", "Sam", "Ilona", "Ivanildo", "Ozan", "Douwe", "Shani", "Stan", "Eyse", "Saphira"};

    public void addPokemone(Pokemon pokemon) {
        pokemons.add(pokemon);
    }
    public PokemonsDto(){
        pokemons = new ArrayList<>();
    }
    public PokemonsDto getRandomList(int count) {
        PokemonsDto wrapperList = new PokemonsDto();
        for (int i = 0; i < count; i++) {
            Pokemon temp = new Pokemon();
            temp.setId(i+1);
            temp.setHealth(random.nextInt(200)+1);
            temp.setLevel(random.nextInt(20)+1);
            temp.setStrength(random.nextInt(200)+1);
            String randomName = NAMES[i];
            temp.setName(randomName);
            wrapperList.addPokemone(temp);
        }

        return wrapperList;
    }
}
