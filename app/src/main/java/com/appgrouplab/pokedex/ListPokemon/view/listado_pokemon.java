package com.appgrouplab.pokedex.ListPokemon.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.appgrouplab.pokedex.ListPokemon.presenter.List_PokemonPresenter;
import com.appgrouplab.pokedex.ListPokemon.presenter.List_PokemonPresenterImpl;
import com.appgrouplab.pokedex.R;
import com.appgrouplab.pokedex.Type.view.AdapterType;
import com.appgrouplab.pokedex.model.PokemonFeed;
import com.appgrouplab.pokedex.model.PokemonFeedType;
import com.appgrouplab.pokedex.pokemonapi.Constans;
import com.appgrouplab.pokedex.pokemonapi.RestApiAdapter;
import com.appgrouplab.pokedex.pokemonapi.Service;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class listado_pokemon extends AppCompatActivity implements Listado_Pokemon_View  {

    private RecyclerView recyclerView;
    private AdapterListadoPokemon mAdapterListado;
    private String url_get;
    private TextView txtTitle;

    private List_PokemonPresenter list_pokemonPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listado_pokemon);

        list_pokemonPresenter = new List_PokemonPresenterImpl(this);

        txtTitle = findViewById(R.id.txtListPokemon);
        recyclerView = findViewById(R.id.rcvListadoPokemon);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapterListado = new AdapterListadoPokemon(this);
        recyclerView.setAdapter(mAdapterListado);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            url_get = extras.getString("URL_GET");
            txtTitle.setText("Type " + extras.getString("TITULO"));
            Log.e("error", url_get);
        }


        getDataList(url_get);
    }

    @Override
    public void getDataList(String url_get) {
        list_pokemonPresenter.getDataList(url_get);
    }

    @Override
    public void showDataList(PokemonFeedType pokemonFeedType) {
        mAdapterListado.setDataset(pokemonFeedType.getPokemon());
    }

}
