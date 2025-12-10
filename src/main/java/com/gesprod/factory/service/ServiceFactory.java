package com.gesprod.factory.service;

import com.gesprod.factory.repository.EntityName;
import com.gesprod.factory.repository.RepositoryFactory;
import com.gesprod.repository.CategorieRepository;
import com.gesprod.repository.ProduitRepository;
import com.gesprod.service.impl.CategorieServiceImpl;
import com.gesprod.service.impl.ProduitServiceImpl;

public final class ServiceFactory {

    private ServiceFactory() {
    }

    public static Object getInstance(EntityName entityName) {
        switch (entityName) {
            case Categorie:
                return CategorieServiceImpl.getInstance((CategorieRepository)RepositoryFactory.getInstance(EntityName.Categorie));
            case Produit:
                return ProduitServiceImpl.getInstance((ProduitRepository)RepositoryFactory.getInstance(EntityName.Produit));
            default:
                throw new IllegalArgumentException("Unknown Entity: " + entityName);
        }
    }


}
