package com.cmartin.learn.mybank.service;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static io.restassured.module.mockmvc.matcher.RestAssuredMockMvcMatchers.*;

import com.cmartin.learn.mybank.dto.DomainFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cmartin on 19/06/16.
 */
public class ControllerTest {

    @Test
    public void testGetAccountList() {
        given()
                .standaloneSetup(new MyBankController()).
        when()
                .get("/accounts/").
        then().
                statusCode(200);
                //body("entity-1.entity-2", equalTo(3));
    }

    @Test
    public void testGetAccountListWithPagination() {
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/?paginationSize=7").
                then().
                statusCode(200);
        //body("entity-1.entity-2", equalTo(3));
    }

    @Test
    public void testGetAccountListWithPaginationLimit() {
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/?paginationSize=20").
                then().
                statusCode(200);
        //body("entity-1.entity-2", equalTo(3));
    }

    @Test
    public void testGetAccount() {
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/AB1122223333441234567890").
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

    @Test
    public void testFactory() {
        new DomainFactory();
    }
}
