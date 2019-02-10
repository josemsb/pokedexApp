package com.appgrouplab.pokedex.pokemonapi;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public Service getClientService(){

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constans.ROOT_URL + Constans.VERSION)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(Service.class);
    }

}
