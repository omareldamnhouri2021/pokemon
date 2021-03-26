package com.omar.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class PokemonController {

    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/")
    public String showPokemonList(Model model) {
        model.addAttribute("pokemons", pokemonRepository.findAll());
        return "index";
    }


    @GetMapping("/signup")
    public String showSignUpForm(Pokemon pokemon) {
        return "add-pokemon";
    }

    @PostMapping("/addpokemon")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-pokemon";
        }

        pokemonRepository.save(pokemon);
        return "redirect:/";
    }

    @GetMapping("/hub")
    public String WildFight(Pokemon pokemon) {
        return "fight-wild";
    }


    @GetMapping("/center")
    public String pokemonCenter(Pokemon pokemon, Model model) {
        model.addAttribute("pokemons", pokemonRepository.findAll());
        return "pokemoncenter";
    }

    @GetMapping("/heal/{id}")
    public String healPokemon (@PathVariable("id") long id){
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        if (pokemon.getHealth() != 100) {
            pokemon.setHealth(100);
            pokemonRepository.save(pokemon);
            return "redirect:/center";
        }
        return "redirect:/center";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("pokemon", pokemon);

        return "update-pokemon";
    }

    @PostMapping("/update/{id}")
    public String updatePokemon(@PathVariable("id") long id, @Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            pokemon.setId(id);
            return "update-pokemon";
        }

        pokemonRepository.save(pokemon);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Pokemon Id:" + id));
        pokemonRepository.delete(pokemon);

        return "redirect:/";
    }

    @GetMapping("/createpokemon/{button}")
    public String createPokemon(@PathVariable("button") int button) {
        Pokemon pokemon = new Pokemon();
        switch(button) {
            case 1:
                pokemon.setName("Pikachu");
                pokemon.setHealth(100);
                pokemon.setLevel(1);
                pokemon.setStrength(10);
                pokemon.setId(301);
                pokemonRepository.save(pokemon);
                break;
            case 2:
                pokemon.setName("Charmander");
                pokemon.setHealth(100);
                pokemon.setLevel(1);
                pokemon.setStrength(10);
                pokemon.setId(301);
                pokemonRepository.save(pokemon);
                break;
            case 3:
                pokemon.setName("Squirtle");
                pokemon.setHealth(100);
                pokemon.setLevel(1);
                pokemon.setStrength(10);
                pokemon.setId(301);
                pokemonRepository.save(pokemon);
                break;
            case 4:
                pokemon.setName("Bulbasar");
                pokemon.setHealth(100);
                pokemon.setLevel(1);
                pokemon.setStrength(10);
                pokemon.setId(301);
                pokemonRepository.save(pokemon);
                break;
        }

        return "redirect:/hub";
    }
    @GetMapping("/wildbattle")
    public String startWild(Model model){
        Random ran = new Random();
        Pokemon pokemon = pokemonRepository.findAll().iterator().next();
        Pokemon opponent = new WrapperPokemons().getRandom();
        List<Pokemon> pokemons = Arrays.asList(pokemon, opponent);
        Pokemon winner = pokemon.getHealth() < opponent.getStrength() ? opponent : pokemon;
        model.addAttribute("pokemons", pokemons);
        model.addAttribute("winner", winner);
        return "wild-battle";
    }

}