package com.example.inventoryservice.commands.aggregates;

import com.example.communapi.commands.customer.CreateCustomerCommand;
import com.example.communapi.commands.inventory.CreateProductCommand;
import com.example.communapi.dtos.CreateProductDTO;
import com.example.communapi.events.customer.CustomerCreatedEvent;
import com.example.communapi.events.enventory.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate

public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String catDescription;
    private String catName;

    public ProductAggregate() {}

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        AggregateLifecycle.apply(new ProductCreatedEvent(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getCatDescription(),
                command.getCatName()

        ));


    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.catDescription = event.getCatDescription();
        this.catName = event.getCatName();
    }

}
