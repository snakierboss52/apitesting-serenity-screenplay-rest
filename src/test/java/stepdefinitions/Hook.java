package stepdefinitions;

import io.cucumber.java.Before;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.apitest.utils.GlobalVariables.URL_BASE;

public class Hook {

    public static final Actor user = new Actor("user");

    @Before
    public void prepareStage() {
        user.whoCan(CallAnApi.at(URL_BASE));
    }

}
