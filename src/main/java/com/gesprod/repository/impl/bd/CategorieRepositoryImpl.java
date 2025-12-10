package com.gesprod.repository.impl.bd;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.gesprod.database.Database;
import com.gesprod.entity.Categorie;
import com.gesprod.repository.CategorieRepository;

public class CategorieRepositoryImpl implements CategorieRepository {

    private static CategorieRepositoryImpl instance = null;
    
    public static CategorieRepositoryImpl getInstance(Database database) {
        if (instance == null) {
            instance = new CategorieRepositoryImpl(database);
        }
        return instance;
    }

    private Database database;

    private CategorieRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public List<Categorie> selectAll() {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from categorie");
            return database.<Categorie>fetchAll(ps,this::toEntity);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Categorie> selectById(int id) {
        Connection conn = database.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select * from categorie where id=?");
            ps.setInt(1, id);
            return database.<Categorie>fetch(ps,this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    private Categorie toEntity(ResultSet rs) throws SQLException {
        Categorie categorie = new Categorie();
        categorie.setId(rs.getInt("id"));
        categorie.setLibelle(rs.getString("libelle"));
        return categorie;
    }

}
