package com.example.portfoliotracker.config;

import org.hibernate.dialect.DatabaseVersion;
import org.hibernate.dialect.Dialect;
import org.hibernate.type.SqlTypes;

public class CustomSQLiteDialect extends Dialect {

    public CustomSQLiteDialect() {
        super(DatabaseVersion.make(3, 42)); // SQLite version 3.42.0
    }

    @Override
    protected void initializeTypeMappings(TypeNames typeNames, DatabaseVersion databaseVersion) {
        typeNames.put(SqlTypes.INTEGER, "integer");
        typeNames.put(SqlTypes.VARCHAR, "text");
        typeNames.put(SqlTypes.FLOAT, "float");
        typeNames.put(SqlTypes.DOUBLE, "double");
        typeNames.put(SqlTypes.BLOB, "blob");
    }

    @Override
    public boolean supportsSequences() {
        return false;
    }

    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, boolean hasOffset) {
        return sql + (hasOffset ? " limit ? offset ?" : " limit ?");
    }
}
