package com.revature.service_layer;

import com.revature.data_layer.DummyWizardData;
import com.revature.data_layer.DummyWizardDataImpl;
import com.revature.models.Wizard;

public class WizardServiceImpl implements WizardService {

	private static DummyWizardData wizardData = new DummyWizardDataImpl();
	
	@Override
	public void createNewWizard(Wizard w) {
		wizardData.add(w);
	}

	@Override
	public void deleteWizard(Wizard w) {
		wizardData.delete(w);
	}

}
