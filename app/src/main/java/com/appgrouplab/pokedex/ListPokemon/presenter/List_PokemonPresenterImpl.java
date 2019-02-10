package com.appgrouplab.pokedex.ListPokemon.presenter;

import com.appgrouplab.pokedex.ListPokemon.interactor.List_PokemonInteractor;
import com.appgrouplab.pokedex.ListPokemon.interactor.List_PokemonInteractorImpl;
import com.appgrouplab.pokedex.ListPokemon.view.Listado_Pokemon_View;
import com.appgrouplab.pokedex.model.PokemonFeedType;

public class List_PokemonPresenterImpl implements  List_PokemonPresenter {

    private Listado_Pokemon_View listado_pokemon_view;
    private List_PokemonInteractor list_pokemonInteractor;



    public List_PokemonPresenterImpl(Listado_Pokemon_View listado_pokemon_view) {
        this.listado_pokemon_view = listado_pokemon_view;
        list_pokemonInteractor = new List_PokemonInteractorImpl(this);
    }

    @Override
    public void getDataList(String url_get) {
        list_pokemonInteractor.getDataList(url_get);
    }

    @Override
    public void showDataList(PokemonFeedType pokemonFeedType) {
        listado_pokemon_view.showDataList(pokemonFeedType);
    }
}
