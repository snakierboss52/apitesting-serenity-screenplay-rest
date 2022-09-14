package stepdefinitions;

import com.apitest.exceptions.StatusCode;
import com.apitest.models.CreateEmployeeModel;
import com.apitest.questions.VerifyStatusCode;
import com.apitest.tasks.CreateEmployee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static com.apitest.utils.GlobalVariables.*;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static stepdefinitions.Hook.user;

public class CreateEmployeeStepDefinition {

    @Given("^The director fill the information need it to register a new employee like (.*) and (.*)$")
    public void directorWantsToRegisterEmployeeInHisCompany(String job, String name){

        CreateEmployeeModel employee = new CreateEmployeeModel();
        employee.setJob(job);
        employee.setName(name);

        user.attemptsTo(
                CreateEmployee.withInformation(employee)
        );

    }

    @Then("^The employee is created succesfully$")
    public void employeeWillBeCreatedSuccesfully(){
        user.should(
                seeThat(
                        VerifyStatusCode.ofApi(SUCCESS_STATUS_CODE_CREATE)
                ).orComplainWith(
                        StatusCode.class, INCORRECT_STATUS_CODE
                )
        );
    }




}
