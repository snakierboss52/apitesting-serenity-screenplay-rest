package stepdefinitions;

import com.apitest.exceptions.StatusCode;
import com.apitest.models.EmployeeEntity;
import com.apitest.questions.VerifyStatusCode;
import com.apitest.tasks.CreateEmployee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.apitest.utils.GlobalVariables.INCORRECT_STATUS_CODE;
import static com.apitest.utils.GlobalVariables.SUCCESS_STATUS_CODE_CREATE;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static stepdefinitions.Hook.user;

public class CreateEmployeeStepDefinition {

    @Given("^The director fill the information need it to register a new employee like (.*) and (.*)$")
    public void directorWantsToRegisterEmployeeInHisCompany(String name, String job){

        EmployeeEntity employee = new EmployeeEntity();
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
