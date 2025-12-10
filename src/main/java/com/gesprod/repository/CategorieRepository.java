package com.gesprod.repository;

import java.util.List;
import java.util.Optional;

import com.gesprod.entity.Categorie;

public interface CategorieRepository {
    List<Categorie> selectAll();
    Optional<Categorie> selectById(int id);
} 

