package com.gesprod.factory.repository;

import com.gesprod.factory.database.DatabaseFactory;

public final class RepositoryFactory {
    
    private static final PersistanceName PERSISTENCE_NAME = PersistanceName.Database;

    private RepositoryFactory() {
    }

    public static Object getInstance(EntityName entityName) {
        switch (PERSISTENCE_NAME) {
            case Database:
                return getRepositoryDatabase(entityName);
            case Memory:
                return getRepositoryMemory(entityName);
            default:
                throw new IllegalArgumentException("Unknown Persistence: " + PERSISTENCE_NAME);
        }
    }


    private static Object getRepositoryDatabase(EntityName entityName) {
        switch (entityName) {
            case Categorie:
                return com.gesprod.repository.impl.bd.CategorieRepositoryImpl.getInstance(DatabaseFactory.getInstance());
            case Produit:
                return com.gesprod.repository.impl.bd.ProduitRepositoryImpl.getInstance(DatabaseFactory.getInstance());
            default:
                throw new IllegalArgumentException("Unknown Entity: " + entityName);
        }
    }

    private static Object getRepositoryMemory(EntityName entityName) {
        switch (entityName) {
            case Categorie:
                return new com.gesprod.repository.impl.list.CategorieRepositoryImpl();
            case Produit:
                return new com.gesprod.repository.impl.list.ProduitRepositoryImpl();
            default:
                throw new IllegalArgumentException("Unknown Entity: " + entityName);
        }
    }

}
