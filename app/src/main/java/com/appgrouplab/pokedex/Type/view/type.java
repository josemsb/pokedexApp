package com.appgrouplab.pokedex.Type.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.appgrouplab.pokedex.R;
import com.appgrouplab.pokedex.Type.presenter.TypePresenter;
import com.appgrouplab.pokedex.Type.presenter.TypePresenterImpl;
import com.appgrouplab.pokedex.model.PokemonFeed;
import com.appgrouplab.pokedex.ListPokemon.view.listado_pokemon;
public class type extends AppCompatActivity implements TypeView {

    private RecyclerView recyclerView;
    private AdapterType mAdapterType;

    private TypePresenter typePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);


        typePresenter = new TypePresenterImpl(this);

        recyclerView = findViewById(R.id.rcvType);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapterType = new AdapterType(this);
        recyclerView.setAdapter(mAdapterType);

        mAdapterType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] parts = view.getTag().toString().split("&");
                String part1 = parts[0]; // 004
                String part2 = parts[1];

                Intent ventana = new Intent(getBaseContext(),listado_pokemon.class);
                ventana.putExtra("URL_GET",part1);
                ventana.putExtra("TITULO",part2);
                startActivity(ventana);
            }
        });


        getDataType();
    }

    @Override
    public void getDataType() {
        typePresenter.getDataType();
    }

    @Override
    public void showDataType(PokemonFeed pokemonFeed) {
        mAdapterType.setDataset(pokemonFeed.getResults());
    }


}


