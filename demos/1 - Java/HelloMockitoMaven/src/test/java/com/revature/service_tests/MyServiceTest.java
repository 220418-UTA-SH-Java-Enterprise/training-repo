package com.revature.service_tests;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.models.Wizard;
import com.revature.data_layer.DummyWizardDataImpl;
import com.revature.service_layer.WizardServiceImpl;

/* For more information about Mockito, please visit these resources:
 * 1. Stubbing & Mocking with Mockito and JUnit: https://semaphoreci.com/community/tutorials/stubbing-and-mocking-with-mockito-2-and-junit
 * 2. Troubleshooting Mockito (StackOverflow): https://stackoverflow.com/questions/64725199/mockito-unfinishedstubbingexception-thrown-on-a-junit-test-case-which-calls-a-vo?noredirect=1#comment114442210_64725199
 * 3. Mockito JUnit Tutorial (YouTube): https://youtu.be/HsQ9OwKA79s
 * */
public class MyServiceTest {
	//Class to be tested
	private WizardServiceImpl wizardService;
	
	//dependencies (will be mocked)
	private DummyWizardDataImpl wizardDataMock;
	
	//test data
	private Wizard w;

	@Before
	public void setUp() {
		/*Mockito setup*/
		//1. mock the depending classes
		wizardDataMock = Mockito.mock(DummyWizardDataImpl.class);
		
		//2. inject your service with mocked classes
		wizardService = new WizardServiceImpl(wizardDataMock);
		
		//3. provide a wizard stub to test with
		w = new Wizard();
		w.setId(1);
		w.setName("Harry Potter");
		w.setSpell("Patronus");
	}

	/**
	 * This would be a test for an application's service layer with Mockito
	 **/
	@Test
	public void addingWizard_mockito_positive_test() {
		//arrange
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(wizardDataMock.add(w)).thenReturn(true);
		
		//act
		//run targeted test method with service injector
		wizardService.createNewWizard(w);
		
		//assert
		//verify that the dao mock ran with injector
		verify(wizardDataMock, times(1)).add(w);
	}

}
