package assignment4;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private Pokemon activatePokemon;

    public Trainer(String name, Pokemon... pokemons) {
        this.name = name;
        addPokemon(pokemons);
        this.activatePokemon = summon();
        summon(activatePokemon.getName());
    }

    public void addPokemon(Pokemon... poke) {
        for (Pokemon pokemon : poke) {
            this.pokemons.add(pokemon);
            for (int j = 0; j < this.pokemons.size() - 1; j++) {
                if (pokemon.getName().equals(this.pokemons.get(j).getName())) {
                    this.pokemons.remove(this.pokemons.size() - 1);
                }
            }
            if (this.pokemons.size() >= 6) {
                break;
            }
        }
    }

    public void removePokemon(String... name) {
        for (String s : name) {
            for (int j = 0; j < this.pokemons.size(); j++) {
                if (s.equals(this.pokemons.get(j).getName())) {
                    this.pokemons.remove(j);
                }
            }
        }
    }

    public boolean isAlive(String name) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getName().equals(name)) {
                return pokemon.getHP() > 0;
            }
        }
        return false;
    }

    public boolean isAlive(Pokemon poke) {
        return poke.getHP() > 0;
    }

    public Pokemon getPokemon(String name) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getName().equals(name)) {
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon summon() {
        for (Pokemon pokemon : this.pokemons) {
            if (isAlive(pokemon)) {
                this.activatePokemon = getPokemon(pokemon.getName());
                return getPokemon(pokemon.getName());
            }
        }
        return null;
    }

    public Pokemon summon(String name) {
        if (isAlive(name)) {
            this.activatePokemon = getPokemon(name);
            getPokemon(name);
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokemon getActivatePokemon() {
        return activatePokemon;
    }

    public void setActivatePokemon(Pokemon activatePokemon) {
        this.activatePokemon = activatePokemon;
    }
}
