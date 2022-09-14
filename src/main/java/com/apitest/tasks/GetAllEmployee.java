package com.apitest.tasks;

import com.apitest.interactions.Wait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.apitest.utils.GlobalVariables.GET_ALL_USERS;
import static com.apitest.utils.GlobalVariables.ONE_SECOND_WAIT;

public class GetAllEmployee implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Get.resource(GET_ALL_USERS),
                Wait.aSeconds(ONE_SECOND_WAIT)
        );
    }
    public static GetAllEmployee inApi() {
        return Tasks.instrumented(GetAllEmployee.class);
    }
}
