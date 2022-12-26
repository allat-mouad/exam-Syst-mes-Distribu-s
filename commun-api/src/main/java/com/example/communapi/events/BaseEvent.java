package com.example.communapi.events;

public class BaseEvent<T> {
    protected T id;

    public BaseEvent() {}
    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
