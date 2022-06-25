package com.mycompany.app;

import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class PatchMethod extends SetUp {
    
    @Test
    public void modifyUser() {

        int id = 4132;
        
        JSONObject obj = new JSONObject();
        obj.put("name", "Deveshwar Nehru M");
        obj.put("email", "deveshwar_nehru_testM@corkery.biz");
        obj.put("gender", "female");
        obj.put("status", "active");

        String payload = obj.toString(1);

        given().
            headers("Authorization", authToken).
            contentType("application/json").
            body(payload).
        when().
            patch(url + "/users/" + id).
        then().
            statusCode(200).
            log().all();
    }
    
}
