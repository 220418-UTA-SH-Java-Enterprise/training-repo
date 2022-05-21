package com.revature.test.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.CandyController;
import com.revature.models.Candy;
import com.revature.models.Shop;
import com.revature.services.CandyService;
import com.revature.util.ClientMessageUtil;

/**
 * NOTE TO COHORT:
 * 
 * This set of controller testing are implementing integration testing.
 * I will discuss more about this and more testing with Spring Boot apps
 * on Monday after we talk about HTML & CSS.
 * 
 * Take advantage of this test suite and its code for your P2 server testing! :)
 * Please note that I had to modify the application.properties file along with adding
 * two new configuration classes for this Spring Boot app.
 * 
 * @author Azhya Knox
 **/
// Useful Resource for Unit/Integration Testing: https://softwaretestingfundamentals.com/

@ExtendWith(SpringExtension.class)
@WebMvcTest(CandyController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CandyControllerTests {

	private static Candy mockCandy1;
	private static Candy mockCandy2;
	private static Candy mockCandyCreation;
	private static Candy mockCandyModification;
	private static Candy mockCandyDeletion;
	private static List<Candy> dummyDb;

	ObjectMapper om = new ObjectMapper();

	@Autowired
	CandyController candyController;

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private CandyService service;

	/**
	 * This method was used during debugging my controller test to make sure that 
	 * the ObjectMapper was converting properly with my test objects
	 * <p>
	 * Note: <br>
	 * ObjectMapper.getJsonFactory().createJsonParser(json) - Since 2.2; now can use ObjectMapper.getFactory().createParser(json)
	 * </p>
	 * @param json (the string literal of any Candy or ClientMessage object)
	 * @return boolean (whether if valid JSON or not)
	 * @author Azhya Knox
	 **/
	@SuppressWarnings("deprecation")
	public boolean isValidJSON(final String json) {
		boolean valid = false;
		try {
			final JsonParser parser = new ObjectMapper().getJsonFactory().createJsonParser(json);
			while (parser.nextToken() != null) {
			}
			valid = true;
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return valid;
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass() :: building test objects...");
		mockCandy1 = new Candy(1, "Starbursts", 1.99, new Shop(1, "Willy Wonka's Factory", 100));
		mockCandy2 = new Candy(2, "M&Ms", 1.78, new Shop(2, "", 100));
		
		mockCandyCreation = new Candy("Jolly Ranchers", 1.50, new Shop(3, "Jolly Ranch Enterprise", 200));
		
		mockCandyModification = mockCandyCreation;
		mockCandyModification.setName("Jolly Munchers");
		mockCandyModification.setPrice(2.99);
		
		mockCandyDeletion = new Candy(4, "Dry Gum", 103.49, new Shop(4, "Not a Candy Shop", 50));

		dummyDb = new ArrayList<>();
		dummyDb.add(mockCandy1);
		dummyDb.add(mockCandy2);
	}

	/*
	 * Sanity Check - if this fails, application context is not loaded and all other
	 * tests should fail
	 */
	@Test
	@Order(1)
	@DisplayName("1. AppContext Sanity Test")
	public void contextLoads() throws Exception {
		assertThat(candyController).isNotNull();
	}

	@Test
	@Order(2)
	@DisplayName("2. Create Candy - Happy Path Scenerio Test")
	public void testCreateCandy() throws Exception {
		// id number of this creation should be 3
		mockCandyCreation.setId(3);
		when(service.createCandy(mockCandyCreation)).thenReturn(true);
		RequestBuilder request = MockMvcRequestBuilders.post("/api/candy")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(om.writeValueAsString(mockCandyCreation))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals(om.writeValueAsString(ClientMessageUtil.CREATION_SUCCESSFUL),
				result.getResponse().getContentAsString());
	}

	@Test
	@Order(3)
	@DisplayName("3. Get Candy by ID - Happy Path Scenerio Test")
	public void testGetById() throws Exception {
		when(service.getCandyById(1)).thenReturn(mockCandy1);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/candy?id=1");
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals(om.writeValueAsString(mockCandy1), result.getResponse().getContentAsString());
	}

	@Test
	@Order(4)
	@DisplayName("4. Get All Candies - Happy Path Scenerio Test")
	public void testGetAll() throws Exception {
		when(service.getAllCandies()).thenReturn(dummyDb);
		RequestBuilder request = MockMvcRequestBuilders.get("/api/candies");
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals(om.writeValueAsString(dummyDb), result.getResponse().getContentAsString());
	}

	@Test
	@Order(5)
	@DisplayName("5. Update an Existing Candy - Happy Path Scenerio Test")
	// @Disabled("Disabled until CreateCandyTest is up!")
	public void testUpdateCandy() throws Exception {
		when(service.updateCandy(mockCandyModification)).thenReturn(true);
		RequestBuilder request = MockMvcRequestBuilders.put("/api/candy")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(om.writeValueAsString(mockCandyModification))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals(om.writeValueAsString(ClientMessageUtil.UPDATE_SUCCESSFUL),
				result.getResponse().getContentAsString());
	}

	@Test
	@Order(6)
	@DisplayName("6. Delete Candy - Happy Path Scenerio Test")
	public void testDeleteCandy() throws Exception {
		when(service.deleteCandy(mockCandyDeletion)).thenReturn(true);
		RequestBuilder request = MockMvcRequestBuilders.delete("/api/candy")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(om.writeValueAsString(mockCandyDeletion))
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockmvc.perform(request).andReturn();
		assertEquals(om.writeValueAsString(ClientMessageUtil.DELETION_SUCCESSFUL),
				result.getResponse().getContentAsString());
	}
	
	@Test
	@Order(7)
	@DisplayName("7. Unneccessay/Unused Test")
	@Disabled("Disabled until CreateCandyTest is up!") 
	// @Disabled will allow you to ignore this test while debugging other tests
	public void unusedTest() {
		return;
	}
}
