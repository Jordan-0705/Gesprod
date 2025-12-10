package com.gesprod.service.impl;

import java.util.List;
import java.util.Optional;

import com.gesprod.entity.Categorie;
import com.gesprod.repository.CategorieRepository;
import com.gesprod.service.CategorieService;

public class CategorieServiceImpl implements CategorieService {

    private static CategorieServiceImpl instance = null;

    public static CategorieServiceImpl getInstance(CategorieRepository categorieRepository) {
        if (instance == null) {
            instance = new CategorieServiceImpl(categorieRepository);
        }
        return instance;
    }

    private CategorieRepository categorieRepository;

    private CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<Categorie> getAll() {
        return categorieRepository.selectAll();
    }

    @Override
    public Optional<Categorie> getById(int id) {
        return categorieRepository.selectById(id);
    }
}
