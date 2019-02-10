package com.appgrouplab.pokedex.ListPokemon.repository;

import android.util.Log;

import com.appgrouplab.pokedex.ListPokemon.presenter.List_PokemonPresenter;
import com.appgrouplab.pokedex.model.PokemonFeedType;
import com.appgrouplab.pokedex.pokemonapi.RestApiAdapter;
import com.appgrouplab.pokedex.pokemonapi.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class List_PokemonRepositoryImpl implements List_PokemonRepository {

    private List_PokemonPresenter list_pokemonPresenter;

    public List_PokemonRepositoryImpl(List_PokemonPresenter list_pokemonPresenter) {
        this.list_pokemonPresenter = list_pokemonPresenter;
    }

    @Override
    public void getDataList(String url_get) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<PokemonFeedType> call = service.getdataListPokemon(url_get);

        call.enqueue(new Callback<PokemonFeedType>() {
            @Override
            public void onResponse(Call<PokemonFeedType> call, Response<PokemonFeedType> response) {

                PokemonFeedType data  = response.body();
                list_pokemonPresenter.showDataList(data);
                //mAdapterListado.setDataset(data.getPokemon());

            }

            @Override
            public void onFailure(Call<PokemonFeedType> call, Throwable t) {
                Log.e("error", "umm" + t.toString());
            }
        });
    }

}
