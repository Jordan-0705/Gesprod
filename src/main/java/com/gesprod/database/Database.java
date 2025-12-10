package com.gesprod.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Database {
    Connection getConnection();
    boolean isConnected();
    void closeConnection();
    <T> List<T> fetchAll(PreparedStatement ps, Convert<T> toEntity) throws SQLException;
    <T> Optional<T> fetch(PreparedStatement ps, Convert<T> toEntity) throws SQLException;
}
