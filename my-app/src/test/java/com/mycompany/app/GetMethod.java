package com.mycompany.app;

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;


public class GetMethod extends SetUp{

    @Test
    public void searchAllUsers() {

        given().
            headers("Authorization", authToken).
            contentType("application/json").
        when().
            get(url + "/users").
        then().
            statusCode(200).
            log().all();
    }

    @Test
    public void searchUser() {

        int id = 4171;

        given().
            headers("Authorization", authToken).
            contentType("application/json").
        when().
            get(url + "/users/" + id).
        then().
            statusCode(200).
            log().all();
    }
}