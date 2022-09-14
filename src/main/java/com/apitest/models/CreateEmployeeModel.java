package com.apitest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateEmployeeModel {

    private String name;
    private String job;
}
