package com.example.customerservice.queries.controllers;

import com.example.communapi.dtos.CreateCustomerDTO;
import com.example.communapi.query.customer.GetAllCustomers;
import com.example.communapi.query.customer.GetCustomer;
import com.example.customerservice.queries.entities.Customer;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/query/customers")
public class CustomerQeuryController {
    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<List<Customer>> getCustomers() {
        return gateway.query(new GetAllCustomers(), ResponseTypes.multipleInstancesOf(Customer.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Customer> getCustomer(@PathVariable String id) {
        return gateway.query(new GetCustomer(id), ResponseTypes.instanceOf(Customer.class));
    }

}
