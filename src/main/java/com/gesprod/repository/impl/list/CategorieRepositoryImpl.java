package com.gesprod.repository.impl.list;

import java.util.List;
import java.util.Optional;

import com.gesprod.entity.Categorie;
import com.gesprod.repository.CategorieRepository;

public class CategorieRepositoryImpl implements CategorieRepository {
    @Override
    public List<Categorie> selectAll() {
        // Implementation here
        return null;
    }
    @Override
    public Optional<Categorie> selectById(int id) {
        // Implementation here
        return Optional.empty();
    }
}
