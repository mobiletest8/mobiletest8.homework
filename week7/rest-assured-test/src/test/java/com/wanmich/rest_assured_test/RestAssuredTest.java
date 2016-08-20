package com.wanmich.rest_assured_test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ValidatableResponse;

public class RestAssuredTest {
	@BeforeClass
    public void before() {
        RestAssured.baseURI = "http://httpbin.org";
        //RestAssured.port = 80;
    }

    @Test
    //URL为http://httpbin.org/get
    //判断Json中的返回信息url
    public void testGet() {
        get("/get").then().body("url", equalTo("http://httpbin.org/get"));
    }

    @Test(dataProvider="dataprovider1",dataProviderClass=DataProviderMethod.class)
  //URL为http://httpbin.org/post
    public void testPost(String a, String b) {
    	ValidatableResponse resp = given().param("a", a).param("b", b).when().post("/post").then();
    	resp.body("form.a", equalTo(a), "form.b", equalTo(b));
    }
/*    public void testPost() {
    	ValidatableResponse resp = given().param("a", "homework2").param("b", "rest assured").when().post("/post").then();
    	resp.body("form.a", equalTo("homework2"), "form.b", equalTo("rest assured"));
    }*/

    @Test
    public void testJsonScheme() {
        given().headers("content-type","application/json").when().get("/get").then().assertThat().body(matchesJsonSchemaInClasspath("httpbin.json"));
    }

    @AfterClass
    public void after() {
    }
}
