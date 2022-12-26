package com.example.inventoryservice.queries.serices;

import com.example.communapi.events.enventory.ProductCreatedEvent;
import com.example.communapi.query.inventory.GetAllProducts;
import com.example.communapi.query.inventory.GetProduct;
import com.example.inventoryservice.queries.entites.Product;
import com.example.inventoryservice.queries.repositories.ProductRepository;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductQueryService {
    @Autowired
    private ProductRepository productRepository;

    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        Product product = Product.builder()
                .id(event.getId())
                .name(event.getName())
                .price(event.getPrice())
                .quantity(event.getQuantity()).build();
        productRepository.save(product);

    }

    @QueryHandler
    public Product getProductById(GetProduct request) {
  return productRepository.findById((String) request.getId()).orElse(null);
    }

    @QueryHandler
    public List<Product> getRadarList(GetAllProducts request) {
    return productRepository.findAll();

    }
}
