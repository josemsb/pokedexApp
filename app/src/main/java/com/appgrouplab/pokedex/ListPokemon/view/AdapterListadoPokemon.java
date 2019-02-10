package com.appgrouplab.pokedex.ListPokemon.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appgrouplab.pokedex.R;
import com.appgrouplab.pokedex.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterListadoPokemon extends RecyclerView.Adapter<AdapterListadoPokemon.ViewHolder> {

    private List<Pokemon> list;
    private Context context;

    public AdapterListadoPokemon(Context context) {
        list = new ArrayList<>();
        this.context=context;
    }

    public void setDataset(List<Pokemon> dataset)
    {
        list = dataset;
        notifyDataSetChanged();
    }

    @Override
    public AdapterListadoPokemon.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_listado_pokemon,null,false);

        return new AdapterListadoPokemon.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterListadoPokemon.ViewHolder holder, int position) {


        final Pokemon pokemonListado = list.get(position);


         String idPokemon = pokemonListado.getPokemon().getUrl().substring(34,pokemonListado.getPokemon().getUrl().length()-1);
        //Log.e("error", pokemonListado.getName());

        holder.txtListPokemon.setText(pokemonListado.getPokemon().getName());
        Picasso.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + idPokemon + ".png"  )
              .error(R.drawable.type)
               .fit()
               .into(holder.imgListPokemon);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtListPokemon;
        public ImageView imgListPokemon;
        private Context vcontext;

        public ViewHolder(View v){
            super(v);
            vcontext = v.getContext();
            txtListPokemon =  v.findViewById(R.id.txtListPokemon);
            imgListPokemon =  v.findViewById(R.id.imgListPokemon);
        }

    }
}
