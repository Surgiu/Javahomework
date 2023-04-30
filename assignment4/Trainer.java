package assignment4;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private ArrayList<Pokemon> pokemons;
    private Pokemon activatePokemon;

    public Trainer(String name, Pokemon... pokemons) {
        this.name = name;
        this.pokemons.add(activatePokemon);
        addPokemon();
    }

    public void addPokemon(Pokemon... poke) {
        for (int i = 0; i < poke.length; i++) {
            this.pokemons.add(poke[i]);
            for (int j = 0; j < this.pokemons.size() - 1; j++) {
                if (poke[i].getName().equals(this.pokemons.get(j).getName())) {
                    this.pokemons.remove(i);
                }
            }
            if (this.pokemons.size() > 6) {
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

    private boolean isAlive(String name) {
        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getName().equals(name)) {
                return pokemon.getHP() > 0;
            }
        }
        return false;
    }

    private boolean isAlive(Pokemon poke) {
        return poke.getHP()>0;
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
        if(isAlive(this.pokemons.get(0))) {
            activatePokemon=getPokemon(this.pokemons.get(0).getName());
            getPokemon(this.pokemons.get(0).getName());
        }
        return null;
    }

    public Pokemon summon(String name) {
        if(isAlive(name)) {
            activatePokemon=getPokemon(name);
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
