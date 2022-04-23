package com.revature.service_layer;

import com.revature.data_layer.DummyWizardData;
import com.revature.data_layer.DummyWizardDataImpl;
import com.revature.models.Wizard;

public class WizardServiceImpl implements WizardService {

	private static DummyWizardData wizardData;
	
	public WizardServiceImpl() {
		wizardData = new DummyWizardDataImpl(); 
	}
	
	public WizardServiceImpl(DummyWizardDataImpl wD) {
		wizardData = wD;
	}
	
	@Override
	public void createNewWizard(Wizard w) {
		wizardData.add(w);
	}

	@Override
	public void deleteWizard(Wizard w) {
		wizardData.delete(w);
	}

	@Override
	public Wizard getWizard(int index) {
		return wizardData.get(index);
	}

}
