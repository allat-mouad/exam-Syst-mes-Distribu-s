package com.example.inventoryservice.commands.controllers;

import com.example.communapi.commands.customer.CreateCustomerCommand;
import com.example.communapi.commands.inventory.CreateProductCommand;
import com.example.communapi.dtos.CreateCustomerDTO;
import com.example.communapi.dtos.CreateProductDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/commands/products")
public class ProductCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping(path = "/create")
    public CompletableFuture<String> createProduct(@RequestBody CreateProductDTO command) {
        return commandGateway.send( new CreateProductCommand(
                UUID.randomUUID().toString(),
                command.getName(),
                command.getPrice(),
                command.getQuantity(),
                command.getCatName(),
                command.getCatDescription()

        ));
    }
    @GetMapping("/eventStore/{id}")
    public Stream eventStore (@PathVariable String id){
        return eventStore.readEvents(id).asStream();

    }
    @DeleteMapping(path = "/delete")
    public CompletableFuture<String> deleteRadar() {
        return null;
    }
    @PutMapping(path = "/update")
    public CompletableFuture<String> updateRadar() {
        return null;
       }

}
