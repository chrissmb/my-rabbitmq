package com.example.myrabbitmq.schema;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    
    private Long id;

    private String name;

    private Date birthday;
}
