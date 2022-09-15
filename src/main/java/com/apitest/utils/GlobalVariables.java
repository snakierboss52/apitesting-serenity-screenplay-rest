package com.apitest.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GlobalVariables {

    public static final String GET_ALL_USERS = "/api/users?page=2";
    public static final String PATH_EMPLOYEE = "/api/users";
    public static final int SECONDS_FOR_FLUENT_WAIT = 1000;
    public static final int ONE_SECOND_WAIT = 1;
    public static final int SUCCESS_STATUS_CODE = 200;
    public static final int SUCCESS_STATUS_CODE_DELETE = 204;
    public static final int SUCCESS_STATUS_CODE_CREATE = 201;
    public static final int ID_EMPLOYEE = 2;
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found or no exists";
    public static final String NAME_EMPLOYEE = "Janet";
    public static final String INCORRECT_STATUS_CODE = "The rest API doesn't answer as expected";
    public static final String URL_BASE = "https://reqres.in";
    public static final String NAME_EMPLOYEE_UPDATED = "Jorge Updated";

}
