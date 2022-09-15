package stepdefinitions;

import com.apitest.exceptions.StatusCode;

import com.apitest.questions.VerifyStatusCode;

import com.apitest.tasks.GetAllEmployee;

import com.apitest.tasks.GetEmployee;
import com.apitest.tasks.SeeInformationEmployee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.apitest.utils.GlobalVariables.ID_EMPLOYEE;
import static com.apitest.utils.GlobalVariables.INCORRECT_STATUS_CODE;
import static com.apitest.utils.GlobalVariables.SUCCESS_STATUS_CODE;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static stepdefinitions.Hook.user;

public class EmployeeStepDefinition {

    @Given("^The director wants to know all the employees$")
    public void directorWantsToListAllEmployees(){

        user.attemptsTo(
                GetAllEmployee.inApi()
        );
    }

    @Then("^The director should see the list of employees$")
    public void directorShouldSeeTheEmployees(){

        user.should(
                seeThat(
                        VerifyStatusCode.ofApi(SUCCESS_STATUS_CODE)
                ).orComplainWith(
                        StatusCode.class, INCORRECT_STATUS_CODE
                )
        );
    }

    @Given("^The director wants to get information about an especific user$")
    public void directorWantsToGetInformationAboutAnEspecificUser(){

        user.attemptsTo(
                GetEmployee.withId(ID_EMPLOYEE)
        );
    }

    @Then("^The director should see basic information of the employee$")
    public void directorSeeBasicInformationOfTheEmployee(){

        user.attemptsTo(
                SeeInformationEmployee.inApp()
        );
    }
}
