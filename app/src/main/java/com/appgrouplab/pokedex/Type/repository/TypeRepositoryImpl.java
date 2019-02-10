package com.appgrouplab.pokedex.Type.repository;

import android.util.Log;

import com.appgrouplab.pokedex.Type.presenter.TypePresenter;
import com.appgrouplab.pokedex.model.PokemonFeed;
import com.appgrouplab.pokedex.pokemonapi.RestApiAdapter;
import com.appgrouplab.pokedex.pokemonapi.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypeRepositoryImpl implements TypeRepository {

    private TypePresenter typePresenter;

    public TypeRepositoryImpl(TypePresenter typePresenter) {
        this.typePresenter = typePresenter;
    }

    @Override
    public void getDataType() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService();
        Call<PokemonFeed> call = service.getdataType();

        call.enqueue(new Callback<PokemonFeed>() {
            @Override
            public void onResponse(Call<PokemonFeed> call, Response<PokemonFeed> response) {
                PokemonFeed data  = response.body();
                typePresenter.showDataType(data);
                //mAdapterType.setDataset(data.getResults());
            }

            @Override
            public void onFailure(Call<PokemonFeed> call, Throwable t) {
                Log.e("error", "umm" + t.toString());
            }
        });

    }
}
