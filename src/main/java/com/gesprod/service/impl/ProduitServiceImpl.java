package com.gesprod.service.impl;

import com.gesprod.repository.ProduitRepository;
import com.gesprod.service.ProduitService;

public class ProduitServiceImpl implements ProduitService {

    private static ProduitServiceImpl instance = null;

    public static ProduitServiceImpl getInstance(ProduitRepository produitRepository) {
        if (instance == null) {
            instance = new ProduitServiceImpl(produitRepository);
        }
        return instance;
    }

    private ProduitRepository produitRepository;


    private ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public int addProduit(com.gesprod.entity.Produit produit) {
        return produitRepository.insert(produit);
    }

    @Override
    public java.util.List<com.gesprod.entity.Produit> getAll() {
        return produitRepository.selectAll();
    }
    
}
