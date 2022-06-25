package com.mycompany.app;

import org.junit.Assert;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class PostMethod extends SetUp {
    
    @Test
    public void createUser() {

        JSONObject obj = new JSONObject();
        obj.put("name", "MarcosO");
        obj.put("gender", "male");
        obj.put("email", "mrkzitest1sO@gmail.com");
        obj.put("status", "active");

        String payload = obj.toString(1);

        given().
            headers("Authorization", authToken).
            contentType("application/json").
            body(payload).
        when().
            post(url + "/users").
        then().
            statusCode(201).
            log().all();
    }

    @Test
    public void authenticationFailed() {

        JSONObject obj = new JSONObject();
        obj.put("name", "Marcola");
        obj.put("gender", "male");
        obj.put("email", "mrkzitest1@gmail.com");
        obj.put("status", "active");

        String payload = obj.toString(1);

        String validation = given().
            contentType("application/json").
            body(payload).
        when().
            post(url + "/users").
        then().
            statusCode(401).
            log().all().
            extract().
            path("message");
        Assert.assertTrue(validation.equals("Authentication failed"));
    }
}
