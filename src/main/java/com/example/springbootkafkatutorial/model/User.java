package com.example.springbootkafkatutorial.model;

import lombok.Data;

@Data
public class User {
    private final int id;
    private final String firstName;
    private final String lastName;
}
