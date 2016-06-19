package com.cmartin.learn.mybank.service;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cmartin on 19/06/16.
 */
public class ControllerTest {

    @Test
    public void testGetAccounts() {
        given()
                .standaloneSetup(new MyBankController()).
        when()
                .get("/accounts/").
        then().
                statusCode(200);
                //body("entity-1.entity-2", equalTo(3));
    }

    @Test
    public void testGetNotFound() {
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/").
                then().
                statusCode(404);
    }
}
