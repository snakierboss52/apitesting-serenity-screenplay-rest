package com.apitest.tasks;

import com.apitest.models.CreateEmployeeModel;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;
import java.util.Map;

import static com.apitest.utils.GlobalVariables.PATH_EMPLOYEE;

@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployee implements Task {

    private CreateEmployeeModel information;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(
                        PATH_EMPLOYEE
                ).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(information)
                )
        );
    }

    public static CreateEmployee withInformation(CreateEmployeeModel information){
        return Tasks.instrumented(CreateEmployee.class, information);
    }
}
