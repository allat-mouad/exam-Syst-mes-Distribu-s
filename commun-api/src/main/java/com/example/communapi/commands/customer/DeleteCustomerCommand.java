package com.example.communapi.commands.customer;

import com.example.communapi.commands.BaseCommand;
import lombok.Data;

@Data
public class DeleteCustomerCommand extends BaseCommand<String> {


    public DeleteCustomerCommand(String id) {
        super(id);

    }

}
