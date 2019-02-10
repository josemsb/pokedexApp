package com.appgrouplab.pokedex.ListPokemon.presenter;
import com.appgrouplab.pokedex.model.PokemonFeedType;

public interface List_PokemonPresenter {

    void getDataList(String url_get);  //repository
    void showDataList(PokemonFeedType pokemonFeedType);  //view
}
