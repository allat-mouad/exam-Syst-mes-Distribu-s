package com.example.customerservice.commands.aggregats;

import com.example.communapi.commands.customer.CreateCustomerCommand;
import com.example.communapi.commands.customer.UpadateCustomerCommand;
import com.example.communapi.events.customer.CustomerCreatedEvent;
import com.example.communapi.events.customer.CustomerUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate

public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public CustomerAggregate() {}

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerCreatedEvent(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.getPhone()
        ));

    }
    @CommandHandler
    public void on(UpadateCustomerCommand upadateCustomerCommand){
        AggregateLifecycle.apply(new CustomerUpdatedEvent(
                upadateCustomerCommand.getId(),
                upadateCustomerCommand.getName(),
                upadateCustomerCommand.getEmail(),
                upadateCustomerCommand.getAddress(),
                upadateCustomerCommand.getPhone()
        ));
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.address = event.getAddress();
        this.phone = event.getPhone();

    }
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        this.id = event.getId();
         this.name = event.getName();
            this.email = event.getEmail();
            this.address = event.getAddress();
            this.phone = event.getPhone();
    }

}
