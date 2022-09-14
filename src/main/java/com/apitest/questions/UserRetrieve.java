package com.apitest.questions;


import com.apitest.models.Employee;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class UserRetrieve implements Question<Employee> {

    @Override
    public Employee answeredBy(Actor actor) {
        return lastResponse().body().as(Employee.class);
    }
}
