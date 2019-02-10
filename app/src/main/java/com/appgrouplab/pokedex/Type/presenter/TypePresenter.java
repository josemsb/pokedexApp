package com.appgrouplab.pokedex.Type.presenter;

import com.appgrouplab.pokedex.model.PokemonFeed;

public interface TypePresenter {

    void getDataType();  //repository
    void showDataType(PokemonFeed pokemonFeed);  //view

}
