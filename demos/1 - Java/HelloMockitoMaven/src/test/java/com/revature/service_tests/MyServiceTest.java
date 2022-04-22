package com.revature.service_tests;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.data_layer.DummyWizardData;
import com.revature.data_layer.DummyWizardDataImpl;
import com.revature.models.Wizard;

public class MyServiceTest {
	
	@Mock
	private static DummyWizardDataImpl wizardData;
	
	private static Wizard w;

	@Before
	public void setUp() throws Exception {
		//make a mock of our data layer
		wizardData = new DummyWizardDataImpl();
		
		//make a wizard stub
		w = new Wizard(10, "Harry Potter", "Patronus");
		
		//TODO: need to tell Mockito what to do with the mock
		//when, do__ statement from Mockito
	}

	@Test
	public void addingWizard_positive_test() {
		//act
		wizardData.add(w);
		
		//assert
		verify(wizardData, times(1)).add(w);
	}

}
