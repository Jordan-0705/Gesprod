package com.gesprod.factory.database;

import com.gesprod.database.Database;
import com.gesprod.database.DatabaseImpl;

public final class DatabaseFactory {

    private static final SgbdName sgbdName = SgbdName.POSTGRESQL;

    private DatabaseFactory() {
    }

    public static Database getInstance() {
        return DatabaseImpl.getIsntance(EntityManager.PersistenceUnit(sgbdName));
    }
}
