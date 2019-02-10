package com.appgrouplab.pokedex.ListPokemon.view;

import com.appgrouplab.pokedex.model.PokemonFeedType;

public interface Listado_Pokemon_View {

    void getDataList(String url_get);  //repository
    void showDataList(PokemonFeedType pokemonFeedType);  //view


}
