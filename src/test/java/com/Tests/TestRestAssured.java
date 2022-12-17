package com.Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class TestRestAssured {
    @Test
    public void api_test_01() {

        Response response = RestAssured.get("https://smalldataproject.com/dataset/api/nsw-covid-19-cases.json");

        String bodyStringValue = response.body().asString();
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());

        ValidatableResponse validate = response.then();
        
        assertTrue(bodyStringValue.contains("date"));
        assertTrue(bodyStringValue.contains("citation"));
        assertTrue(bodyStringValue.contains("overseas_acquired"));
        assertTrue(bodyStringValue.contains("under_investigation"));
        assertTrue(bodyStringValue.contains("currently_unknown"));
        assertTrue(bodyStringValue.contains("confirmed_cases"));
        assertTrue(bodyStringValue.contains("contact_of_a_confirmed_case"));
        assertTrue(bodyStringValue.contains("contact_of_a_confirmed_case"));
        assertTrue(bodyStringValue.contains("cases_under_investigation"));
        assertTrue(bodyStringValue.contains("cases_tested_and_excluded"));

        validate.statusCode(200);
        validate.contentType(ContentType.JSON);
        validate.time(Matchers.lessThanOrEqualTo(5000L));
    }
}
