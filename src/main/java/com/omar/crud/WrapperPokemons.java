package com.omar.crud;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class WrapperPokemons {
    private List<PokemonDto> pokemons;
    public final static Random random = new Random();
    public static final String[] NAMES = {"Jordi", "Isabel", "Omar", "Sam", "Ilona", "Ivanildo", "Ozan", "Douwe", "Shani", "Stan", "Eyse", "Saphira"};

    public void addPokemone(PokemonDto pokemonDto) {
        pokemons.add(pokemonDto);
    }
    public WrapperPokemons(){
        pokemons = new ArrayList<>();
    }
    public WrapperPokemons getRandomList(int count) {
        WrapperPokemons wrapperList = new WrapperPokemons();
        for (int i = 0; i < count; i++) {
            PokemonDto temp = new PokemonDto();
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
