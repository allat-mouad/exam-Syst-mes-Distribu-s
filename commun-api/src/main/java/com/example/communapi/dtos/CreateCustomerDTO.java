package com.example.communapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder public class CreateCustomerDTO {
        private String name;
        private String email;
        private String address;
        private String phone;
    }
