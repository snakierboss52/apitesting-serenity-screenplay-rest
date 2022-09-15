package com.apitest.tasks;

import com.apitest.models.EmployeeEntity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.hamcrest.core.IsEqual;

import static com.apitest.utils.GlobalVariables.NAME_EMPLOYEE_UPDATED;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static org.hamcrest.core.IsNull.notNullValue;

public class VerifyUpdateInformation implements Task {

    EmployeeEntity  employeeUpdated = new EmployeeEntity();

    @Override
    public <T extends Actor> void performAs(T actor) {

        employeeUpdated = lastResponse().body().as(EmployeeEntity.class);

        actor.should(
                seeThat(
                        "Employee updated not null",  act -> employeeUpdated, notNullValue()
                ),
                seeThat(
                        "Employee updated name", act -> employeeUpdated.getName(), IsEqual.equalTo(NAME_EMPLOYEE_UPDATED)
                )
        );
    }

    public static VerifyUpdateInformation inApp(){
        return Tasks.instrumented(VerifyUpdateInformation.class);
    }
}
