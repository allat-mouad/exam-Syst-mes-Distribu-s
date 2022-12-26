package com.example.customerservice.commands.controllers;

import com.example.communapi.commands.customer.CreateCustomerCommand;
import com.example.communapi.commands.customer.DeleteCustomerCommand;
import com.example.communapi.commands.customer.UpadateCustomerCommand;
import com.example.communapi.dtos.CreateCustomerDTO;
//?import com.example.communapi.dtos.UpdateCustomerDTO;

import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/customers")
public class CustomerCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;



    @PostMapping(path = "/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerDTO command) {
        return commandGateway.send( new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.getPhone()
        ));
    }

    @PutMapping(path = "/update")
    public CompletableFuture<String> updateCustomer(@RequestBody UpadateCustomerCommand command) {
        return commandGateway.send(new UpadateCustomerCommand(
                command.getId(),
                command.getName(),
                command.getEmail(),
                command.getAddress(),
                command.getPhone()
        ));
    }

    @DeleteMapping(path = "/delete")
    public CompletableFuture<String> deleteCustomer(@RequestBody DeleteCustomerCommand command) {
        return commandGateway.send(command);
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore (@PathVariable String id){
        return eventStore.readEvents(id).asStream();

    }
}

