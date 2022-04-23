package com.revature.service_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.models.Wizard;
import com.revature.data_layer.DummyWizardDataImpl;
import com.revature.service_layer.WizardServiceImpl;

public class MyServiceTest {
	
	private WizardServiceImpl realWizardService;
	
	@InjectMocks
	private WizardServiceImpl wizardService;
	
	@Mock
	private DummyWizardDataImpl wizardDataMock;

	@Before
	public void setUp() {
		wizardService = new WizardServiceImpl();
		
		realWizardService = new WizardServiceImpl();
		
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * This would be a test for an application's service layer with Mockito
	 * (which we do not have in this example).
	 **/
	@Test
	public void addingWizard_mockito_positive_test() {
		//arrange
		//test object declarations
		Wizard w = new Wizard(1, "Harry Potter", "Patronus");
		ArrayList<Wizard> list = new ArrayList<>();
		list.add(w);
		
		//here, we are telling Mockito what to do with our mock method calls 
		//and what to expect in return from that call
		when(wizardDataMock.getList()).thenReturn(list);
		when(wizardDataMock.get(0)).thenReturn(new Wizard(1, "Harry Potter", "Patronus"));
		
		//act
		//run targeted test method with service injector
		wizardService.createNewWizard(w);
		
		
		//assert
		//verify that the dao mock ran with injector
		verify(wizardDataMock, times(1)).get(0);
	}
	
	/**
	 * This would be a test for a real application's service layer without Mockito
	 * (currently being ignored)
	 **/
	@Test
	public void addingWizard_regular_positive_test() {
		Wizard w = new Wizard(0, "Ron Weasley", "Wingardium Leviosa");
		
		realWizardService.createNewWizard(w);
		
		assertEquals(1, realWizardService.getWizard(0).getId());
	}

}
