package com.apitest.tasks;

import com.apitest.models.EmployeeEntity;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.apitest.utils.GlobalVariables.PATH_EMPLOYEE;

@AllArgsConstructor
@Data
public class UpdateEmployee implements Task {

    private final EmployeeEntity information;
    private final int id;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(
                        PATH_EMPLOYEE + "/{id}"
                ).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .pathParam("id", id)
                                .body(information)
                )
        );
    }

    public static UpdateEmployee withInformation(EmployeeEntity information, int id){
        return Tasks.instrumented(UpdateEmployee.class, information, id);
    }

}
