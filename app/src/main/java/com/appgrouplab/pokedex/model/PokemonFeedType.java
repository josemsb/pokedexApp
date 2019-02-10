
package com.appgrouplab.pokedex.model;

import java.util.ArrayList;
import java.util.List;

public class PokemonFeedType {

    private Integer id;
    private String name;
    private List<Pokemon> pokemon = new ArrayList<Pokemon>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

}
