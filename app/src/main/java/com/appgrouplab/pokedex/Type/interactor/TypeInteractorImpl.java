package com.appgrouplab.pokedex.Type.interactor;

import com.appgrouplab.pokedex.Type.presenter.TypePresenter;
import com.appgrouplab.pokedex.Type.repository.TypeRepository;
import com.appgrouplab.pokedex.Type.repository.TypeRepositoryImpl;

public class TypeInteractorImpl implements  TypeInteractor {

    private TypePresenter typePresenter;  //Conecta al presenter
    private TypeRepository typeRepository;

    public TypeInteractorImpl(TypePresenter typePresenter) {
        this.typePresenter = typePresenter;
        typeRepository = new TypeRepositoryImpl(typePresenter);
    }

    @Override
    public void getDataType() {
        typeRepository.getDataType();
    }


}
