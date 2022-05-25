package com.revature.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Order;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Candy;
import com.revature.models.Shop;
import com.revature.repositories.CandyRepository;
import com.revature.services.CandyServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CandyServiceTests {
	
	@Mock
	private static CandyRepository mockdao;
	
	@InjectMocks
	private static CandyServiceImpl cserv;
	
	private static Candy c1, c2;
	static List<Candy> dummyDb;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//arrange your tests with needed dependencies
		/**
		  * We are declaring the dependency of the object within the class
		  * via the constructor injection we defined in the UserServiceImpl.java class
		  */
		
		/*Mockito setup*/
		//1. mock the depending classes
		mockdao = Mockito.mock(CandyRepository.class);
		
		//2. inject your service with mocked classes
		cserv = new CandyServiceImpl(mockdao);
		
		/*Dummy DB setup*/
		//we need to create a "fake database" of user objects
		c1 = new Candy(1, "Starbursts", 1.99, new Shop(1, "Willy Wonka's Factory", 100));
		c2 = new Candy(2, "M&Ms", 1.78, new Shop(2, "", 100));
		
		dummyDb = new ArrayList<Candy>();
		dummyDb.add(c1);
		dummyDb.add(c2);
	}
	
	@Test
	@Order(1)
	@DisplayName("1. Mock Validation Sanity Test")
	void checkMockInjection() {
		assertThat(mockdao).isNotNull();
		assertThat(cserv).isNotNull();
	}

	@Test
	@Order(2)
	@DisplayName("2. Create Candy Happy Path Test")
	void testCreateCandy() {
		//arrange step
		Candy c3 = new Candy("Jolly Ranchers", 1.50, new Shop(3, "Jolly Ranch Enterprise", 200));
		c3.setId(3);
		
		//here we will tell mockito what type of behavior to expect from calling certain methods from our dao
        when(mockdao.save(c3)).thenReturn(c3);
        
		//act + assert step
		assertEquals(true, cserv.createCandy(c3));
	}

	@Test
	@Order(3)
	@DisplayName("3. Get Candy by Id Happy Path Test")
	void testGetCandyById() {
		//arrange step already done in setup
		//here we will tell mockito what type of behavior to expect from calling certain methods from our dao
		when(cserv.getCandyById(1)).thenReturn(c1);
        
		//act + assert step
		assertEquals(c1, cserv.getCandyById(1));
	}

	@Test
	@Order(4)
	@DisplayName("4. Get all Candies Happy Path Test")
	void testGetAllCandies() {
		//arrange step already done in setup
		//here we will tell mockito what type of behavior to expect from calling certain methods from our dao
		when(cserv.getAllCandies()).thenReturn(dummyDb);
        
		//act + assert step
		assertEquals(dummyDb, cserv.getAllCandies());
	}

	@Test
	@Order(5)
	@DisplayName("5. Update Candy Happy Path Test")
	void testUpdateCandy() {
		c2.setName("Lollipop");
		c2.setPrice(0.79);
		
		when(cserv.getCandyById(2)).thenReturn(c2);
		when(mockdao.save(c2)).thenReturn(c2);
		
		assertEquals(true, cserv.updateCandy(c2));
	}

	@Test
	@Order(6)
	@DisplayName("6. Delete Candy Happy Path Test")
	void testDeleteCandy() {
        doNothing().when(mockdao).delete(c2);
		//act + assert step
		assertEquals(true, cserv.deleteCandy(c2));
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
