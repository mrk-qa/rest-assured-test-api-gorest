package com.mycompany.app;

import org.junit.Test;
import static io.restassured.RestAssured.given;

public class DeleteMethod extends SetUp {

    @Test
    public void deleteUser() {

        int id = 4171;

        given().
            headers("Authorization", authToken).
            contentType("application/json").
        when().
            delete(url + "/users/" + id).
        then().
            statusCode(204).
            log().all();
    }
}
