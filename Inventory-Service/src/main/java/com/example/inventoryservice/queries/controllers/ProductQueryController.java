package com.example.inventoryservice.queries.controllers;

import com.example.communapi.query.customer.GetAllCustomers;
import com.example.communapi.query.customer.GetCustomer;
import com.example.communapi.query.inventory.GetAllProducts;
import com.example.communapi.query.inventory.GetProduct;
import com.example.inventoryservice.queries.entites.Product;
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
@RequestMapping("/query/products")
public class ProductQueryController {
    private QueryGateway gateway;

    @GetMapping
    public CompletableFuture<List<Product>> getProducts() {
        return gateway.query(new GetAllProducts(), ResponseTypes.multipleInstancesOf(Product.class));
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> getCustomer(@PathVariable String id) {
        return gateway.query(new GetProduct(id), ResponseTypes.instanceOf(Product.class));
    }

}
