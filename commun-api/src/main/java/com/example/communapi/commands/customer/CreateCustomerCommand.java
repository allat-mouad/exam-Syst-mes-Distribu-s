package com.example.communapi.commands.customer;

import com.example.communapi.commands.BaseCommand;
import lombok.Data;

@Data
public class CreateCustomerCommand extends BaseCommand<String> {

    private String name;
    private String email;
    private String address;
    private String phone;

    public CreateCustomerCommand(String id, String name, String email, String address, String phone) {
        super(id);
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

}
