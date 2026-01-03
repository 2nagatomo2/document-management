package com.example.docmanager.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.PostgresDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@Configuration
public class DomaConfig {

    @Bean
    public Dialect dialect() {
        return new PostgresDialect();
    }

    @Bean
    public Config config(DataSource dataSource) {
        return new Config() {
            @Override
            public Dialect getDialect() {
                return dialect();
            }

            @Override
            public DataSource getDataSource() {
                return new TransactionAwareDataSourceProxy(dataSource);
            }
        };
    }
}
