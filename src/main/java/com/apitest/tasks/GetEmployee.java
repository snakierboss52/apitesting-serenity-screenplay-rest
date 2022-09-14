package com.apitest.tasks;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.apitest.utils.GlobalVariables.*;

@AllArgsConstructor
@NoArgsConstructor
public class GetEmployee implements Task {

    private int id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(
                        PATH_EMPLOYEE + "/{id}"
                ).with(
                        request -> request.pathParam("id", id)
                )
        );
    }

    public static GetEmployee withId(int id){
        return Tasks.instrumented(GetEmployee.class, id);
    }
}
