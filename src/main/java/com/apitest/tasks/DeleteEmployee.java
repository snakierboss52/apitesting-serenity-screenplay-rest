package com.apitest.tasks;

import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static com.apitest.utils.GlobalVariables.PATH_EMPLOYEE;

@Data
public class DeleteEmployee implements Task {

    private int id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(
                        PATH_EMPLOYEE + "/{id}"
                ).with(
                        request -> request.pathParam("id", id)
                )
        );
    }

    public static DeleteEmployee withId(int id){
        return Tasks.instrumented(DeleteEmployee.class, id);
    }
}
