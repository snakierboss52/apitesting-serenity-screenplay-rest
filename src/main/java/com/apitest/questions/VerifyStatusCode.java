package com.apitest.questions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VerifyStatusCode implements Question<Boolean> {

    private int statusCodeExpected;

    public static VerifyStatusCode ofApi(int statusCodeExpected){
        return new VerifyStatusCode(statusCodeExpected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == statusCodeExpected;
    }
}
