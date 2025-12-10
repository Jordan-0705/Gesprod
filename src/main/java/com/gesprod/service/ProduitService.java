package com.gesprod.service;

import java.util.List;

import com.gesprod.entity.Produit;

public interface ProduitService {
    int addProduit(Produit produit);
    List<Produit> getAll();
}
