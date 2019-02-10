package com.appgrouplab.pokedex.ListPokemon.interactor;

import com.appgrouplab.pokedex.ListPokemon.presenter.List_PokemonPresenter;
import com.appgrouplab.pokedex.ListPokemon.repository.List_PokemonRepository;
import com.appgrouplab.pokedex.ListPokemon.repository.List_PokemonRepositoryImpl;

public class List_PokemonInteractorImpl implements  List_PokemonInteractor {

    private List_PokemonPresenter list_pokemonPresenter;
    private List_PokemonRepository list_pokemonRepository;

    public List_PokemonInteractorImpl(List_PokemonPresenter list_pokemonPresenter) {
        this.list_pokemonPresenter = list_pokemonPresenter;
        list_pokemonRepository = new List_PokemonRepositoryImpl(list_pokemonPresenter);
    }

    @Override
    public void getDataList(String url_get) {
        list_pokemonRepository.getDataList(url_get);
    }
}
