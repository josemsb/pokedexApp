package com.appgrouplab.pokedex.pokemonapi;
import com.appgrouplab.pokedex.model.PokemonFeed;
import com.appgrouplab.pokedex.model.PokemonFeedType;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface Service {


    @GET(Constans.URL_GET_POKEMON)
    Call<PokemonFeed> getdata(@Query("limit") int limit,@Query("offset") int limit1);


    @GET(Constans.URL_GET_TYPE)
    Call<PokemonFeed> getdataType();

    @GET()
    Call<PokemonFeedType> getdataListPokemon(@Url String url);

}
