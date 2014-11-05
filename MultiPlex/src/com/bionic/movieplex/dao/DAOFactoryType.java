package com.bionic.movieplex.dao;

public enum DAOFactoryType {

    MYSQL("MYSQL"),
    ORACLE("ORACLE"),
    JPA("JPA");

    DAOFactoryType(String id) {
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }
}
