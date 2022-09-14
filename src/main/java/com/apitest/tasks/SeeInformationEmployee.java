package com.apitest.tasks;

import com.apitest.exceptions.UserNotFound;

import com.apitest.models.Datum;

import com.apitest.questions.UserRetrieve;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static com.apitest.utils.GlobalVariables.EMPLOYEE_NOT_FOUND;
import static com.apitest.utils.GlobalVariables.NAME_EMPLOYEE;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

public class SeeInformationEmployee implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        Datum employee = new UserRetrieve().answeredBy(actor).getData();

        actor.should(
                seeThat(
                        "Employee found", act -> employee, notNullValue()
                ).orComplainWith(
                        UserNotFound.class, EMPLOYEE_NOT_FOUND
                )
        );
        actor.should(
                seeThat(
                        "Employee name", act -> employee.getFirstName(), equalTo(NAME_EMPLOYEE)
                ),
                seeThat(
                        "Employee lastname", act -> employee.getLastName(), notNullValue()
                )
        );
    }

    public static SeeInformationEmployee inApp(){
        return Tasks.instrumented(SeeInformationEmployee.class);
    }
}
