package com.gesprod.repository;

import java.util.List;
import java.util.Optional;

import com.gesprod.entity.Produit;

public interface ProduitRepository {
    int insert(Produit produit);
    List<Produit> selectAll();
    public Optional<Produit> selectById(int id);
}
