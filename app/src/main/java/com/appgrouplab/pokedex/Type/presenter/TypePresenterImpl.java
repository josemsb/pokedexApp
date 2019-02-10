package com.appgrouplab.pokedex.Type.presenter;

import com.appgrouplab.pokedex.Type.interactor.TypeInteractor;
import com.appgrouplab.pokedex.Type.interactor.TypeInteractorImpl;
import com.appgrouplab.pokedex.Type.view.TypeView;
import com.appgrouplab.pokedex.model.PokemonFeed;

public class TypePresenterImpl implements TypePresenter {


    private TypeView typeView;   //Conecta al presenter
    private TypeInteractor typeInteractor;   //Conecta al Interactor


    public TypePresenterImpl(TypeView typeView) {
        this.typeView = typeView;
        typeInteractor = new TypeInteractorImpl(this);
    }

    @Override
    public void getDataType() {
            typeInteractor.getDataType();
    }

    @Override
    public void showDataType(PokemonFeed pokemonFeed) {
        typeView.showDataType(pokemonFeed);
    }


}
