package com.revature.data_layer;

import java.util.ArrayList;

import com.revature.models.Wizard;

public class DummyWizardDataImpl implements DummyWizardData {
	
	private ArrayList<Wizard> list = new ArrayList<>();
	private static int WIZARD_ID = 0;

	@Override
	public void add(Wizard w) {
		System.out.println("In data layer: adding new wizard...\n" + w);
		WIZARD_ID++;
		w.setId(WIZARD_ID);
		list.add(w);
	}

	@Override
	public void delete(Wizard w) {
		System.out.println("In data layer: removing wizard...\n" + w);
		list.remove(w);
	}

}
