package com.example.communapi.commands.inventory;

import com.example.communapi.commands.BaseCommand;
import lombok.Data;

@Data
public class CreateProductCommand extends BaseCommand<String> {
    private String name;
    private double price;
    private int quantity;
    private String catDescription;
    private String catName;


    public CreateProductCommand(String id, String name, double price, int quantity, String catDescription, String catName) {
        super(id);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.catDescription = catDescription;
        this.catName = catName;
    }


}
