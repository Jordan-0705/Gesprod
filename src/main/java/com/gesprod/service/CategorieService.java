package com.gesprod.service;

import java.util.List;
import java.util.Optional;

import com.gesprod.entity.Categorie;

public interface CategorieService {
    List<Categorie> getAll();
    Optional<Categorie> getById(int id);
}
