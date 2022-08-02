package com.example.myrabbitmq.schema;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Person {
    
    private Long id;

    private String name;

    private Date birthday;
}
