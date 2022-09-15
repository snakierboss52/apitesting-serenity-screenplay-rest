package stepdefinitions;

import com.apitest.exceptions.StatusCode;
import com.apitest.models.EmployeeEntity;
import com.apitest.questions.VerifyStatusCode;
import com.apitest.tasks.UpdateEmployee;
import com.apitest.tasks.VerifyUpdateInformation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.apitest.utils.GlobalVariables.INCORRECT_STATUS_CODE;
import static com.apitest.utils.GlobalVariables.SUCCESS_STATUS_CODE;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static stepdefinitions.Hook.user;

public class UpdateEmployeeStepDefinition {

    @Given("^Update the new information for information of employee (.*) and (.*)$")
    public void UpdateNewInformationEmployee(String name, String job) {

        EmployeeEntity employee = new EmployeeEntity();
        employee.setJob(job);
        employee.setName(name);

        user.attemptsTo(
                UpdateEmployee.withInformation(employee, 3)
        );
    }

    @Then("^The employee is updated succesfully$")
    public void employeeWillBeUpdatedSuccessfully(){
            user.should(
                    seeThat(
                            VerifyStatusCode.ofApi(SUCCESS_STATUS_CODE)
                    ).orComplainWith(
                            StatusCode.class, INCORRECT_STATUS_CODE
                    )
            );
            user.attemptsTo(
                    VerifyUpdateInformation.inApp()
            );
    }

}
