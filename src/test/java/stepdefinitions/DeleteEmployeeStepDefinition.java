package stepdefinitions;

import com.apitest.exceptions.StatusCode;
import com.apitest.questions.VerifyStatusCode;
import com.apitest.tasks.DeleteEmployee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.apitest.utils.GlobalVariables.ID_EMPLOYEE;
import static com.apitest.utils.GlobalVariables.INCORRECT_STATUS_CODE;
import static com.apitest.utils.GlobalVariables.SUCCESS_STATUS_CODE_DELETE;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static stepdefinitions.Hook.user;

public class DeleteEmployeeStepDefinition {

    @Given("^Director wants to delete a employee from his database$")
    public void directorWantsToDeleteAEmployeeFromHisDatabase(){
        user.attemptsTo(
                DeleteEmployee.withId(ID_EMPLOYEE)
        );
    }

    @Then("^The employee is deleted successfully$")
    public void employeeDeletedSuccessfully(){
        user.should(
                seeThat(
                        VerifyStatusCode.ofApi(SUCCESS_STATUS_CODE_DELETE)
                ).orComplainWith(
                        StatusCode.class, INCORRECT_STATUS_CODE
                )
        );
    }

}
