package com.example.portfoliotracker.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.DatabaseVersion;


public class CustomSQLiteDialect extends Dialect {

    // Constructor for custom SQLite dialect (updated for Hibernate 6.0)
    public CustomSQLiteDialect() {
        super(DatabaseVersion.make(3, 0, 0)); // Providing SQLite version (adjust if needed)
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }

    // Other custom methods can be added here as needed
}
