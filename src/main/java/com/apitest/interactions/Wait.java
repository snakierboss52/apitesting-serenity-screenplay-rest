package com.apitest.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.apitest.utils.GlobalVariables.SECONDS_FOR_FLUENT_WAIT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction {

    private final int time;

    public static Wait aTime(int time) {
        return instrumented(Wait.class, time);
    }

    public static Wait aSeconds(int time){
        return instrumented(Wait.class, time * SECONDS_FOR_FLUENT_WAIT);
    }

    protected Wait(int time) {
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(time);
    }
}
