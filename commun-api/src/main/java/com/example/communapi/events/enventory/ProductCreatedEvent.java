package com.example.communapi.events.enventory;

import com.example.communapi.commands.BaseCommand;
import lombok.Data;

@Data
public class ProductCreatedEvent extends BaseCommand<String>

    {
        private String name;
        private double price;
        private int quantity;
        private String catDescription;
        private String catName;


    public ProductCreatedEvent(String id, String name, double price, int quantity, String catDescription, String catName) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.catDescription = catDescription;
        this.catName = catName;
    }


    }

