package com.apitest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    private String name;
    private String job;

    @JsonIgnore
    private String updatedAt;
}
