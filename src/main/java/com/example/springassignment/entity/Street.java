package com.example.springassignment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Street {
    private int id;
    private String name;
    private String ward;
    private int createdDate;
    private String description;
    private int status;
}
