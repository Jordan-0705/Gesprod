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
import com.gesprod.entity.Produit;
import com.gesprod.repository.ProduitRepository;

public class ProduitRepositoryImpl implements ProduitRepository {

    private static ProduitRepositoryImpl instance = null;

    public static ProduitRepositoryImpl getInstance(Database database) {
        if (instance == null) {
            instance = new ProduitRepositoryImpl(database);
        }
        return instance;
    }

    private Database database;

    private ProduitRepositoryImpl(Database database) {
        this.database = database;
    }

    @Override
    public int insert(Produit produit) {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO produit(libelle, prix, categorie_id) VALUES (?, ?, ?)"
            );
            ps.setString(1, produit.getLibelle());
            ps.setDouble(2, produit.getPrix());
            ps.setInt(3, produit.getCategorie().getId());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Produit> selectAll() {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT p.id, p.libelle, p.prix, p.categorie_id, " +
                "c.id AS cat_id, c.libelle AS cat_libelle " +
                "FROM produit p JOIN categorie c ON p.categorie_id = c.id"
            );
            return database.<Produit>fetchAll(ps,this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<Produit> selectById(int id) {
        try {
            Connection conn = database.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                "SELECT p.id, p.libelle, p.prix, p.categorie_id, " +
                "c.id AS cat_id, c.libelle AS cat_libelle " +
                "FROM produit p JOIN categorie c ON p.categorie_id = c.id " +
                "WHERE p.id = ?"
            );
            ps.setInt(1, id);
            return database.<Produit>fetch(ps,this::toEntity);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    // ----------------------------------
    // MÉTHODES INTERNES (même style que les images)
    // ----------------------------------

    private Produit toEntity(ResultSet rs) throws SQLException {
        Produit produit = new Produit();
        produit.setId(rs.getInt("id"));
        produit.setLibelle(rs.getString("libelle"));
        produit.setPrix(rs.getDouble("prix"));

        Categorie categorie = new Categorie();
        categorie.setId(rs.getInt("cat_id"));
        categorie.setLibelle(rs.getString("cat_libelle"));

        produit.setCategorie(categorie);

        return produit;
    }
}
