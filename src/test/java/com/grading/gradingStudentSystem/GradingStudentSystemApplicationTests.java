package com.grading.gradingStudentSystem;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GradingStudentSystemApplication.class }, webEnvironment
		= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GradingStudentSystemApplicationTests {

	private static final String API_ROOT
			= "http://localhost:8080";


	private UserEntity createRandomUser() {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(randomAlphabetic(10));
		userEntity.setLastName(randomAlphabetic(10));
		userEntity.setMetric1(1);
		userEntity.setMetric2(1);
		userEntity.setMetric3(1);
		userEntity.setMetric4(1);
		userEntity.setMetric5(1);

		return userEntity;
	}

	private String createUserEntityAsUri(UserEntity userEntity) {
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(userEntity)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
	}

	@Test
	public void whenGetAllUser_thenOK() {
		Response response = RestAssured.get(API_ROOT + "/lists");

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetUserByID_thenOK() {
		UserEntity userEntity = createRandomUser();
		createUserEntityAsUri(userEntity);
		Response response = RestAssured.get(
				API_ROOT + "/get/" );

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
//		assertTrue(response.as(List.class)
//				.size() > 0);
	}

	@Test
	public void whenCreateNewUser_thenCreated() {
		UserEntity userEntity = createRandomUser();
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(userEntity)
				.post(API_ROOT + "/user");

		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	}
	@Test
	public void whenDeleteUser_thenDeleted() {
		UserEntity userEntity = createRandomUser();
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(userEntity)
				.get(API_ROOT + "/delete");

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

}
