package com.atguigu.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    private String label = "1";

    public BookDao setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
