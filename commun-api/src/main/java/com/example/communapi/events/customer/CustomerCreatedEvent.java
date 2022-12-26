package com.example.communapi.events.customer;

import com.example.communapi.events.BaseEvent;
import lombok.Data;

@Data

public class CustomerCreatedEvent extends BaseEvent<String> {
    private String name;
    private String email;
    private String address;
    private String phone;

    public CustomerCreatedEvent(String id, String name, String email, String address, String phone) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    }
