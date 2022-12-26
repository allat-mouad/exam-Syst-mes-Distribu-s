package com.example.communapi.query;

public class BaseQuery<T> {
    protected T id;

    public BaseQuery(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
