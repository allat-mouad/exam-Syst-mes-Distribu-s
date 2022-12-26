package com.example.customerservice.queries.services;

import com.example.communapi.dtos.CustomerDTO;
import com.example.communapi.events.customer.CustomerCreatedEvent;
import com.example.communapi.events.customer.CustomerDeletedEvent;
import com.example.communapi.events.customer.CustomerUpdatedEvent;
import com.example.communapi.query.customer.GetAllCustomers;
import com.example.communapi.query.customer.GetCustomer;
import com.example.customerservice.queries.entities.Customer;
import com.example.customerservice.queries.repos.CustomerRepository;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerQueryService {
    @Autowired
    private CustomerRepository customerRepository;
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event) {
        Customer customer = Customer.builder()
                .id(event.getId())
                .name(event.getName())
                .address(event.getAddress())
                .email(event.getEmail())
                .phone(event.getPhone())
                .build();
        customerRepository.save(customer);
    }
    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event) {
        Customer customer = customerRepository.findById(event.getId()).get();
        customer.setName(event.getName());
        customer.setAddress(event.getAddress());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customerRepository.save(customer);
    }
    @EventSourcingHandler
    public void on(CustomerDeletedEvent event) {
        customerRepository.deleteById(event.getId());
    }
    @QueryHandler
    public List<Customer> on(GetAllCustomers getAllCustomers){
        return customerRepository.findAll();
    }
    @QueryHandler
    public Customer getRadarById(GetCustomer request) {
        return customerRepository.findById((String) request.getId()).orElse(null);

    }
}
