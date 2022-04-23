package com.revature.data_layer;

import java.util.ArrayList;

import com.revature.models.Wizard;

public class DummyWizardDataImpl implements DummyWizardData {
	
	private ArrayList<Wizard> list = new ArrayList<>();
	private static int WIZARD_ID = 0;

	public DummyWizardDataImpl() {
		super();
	}

	public DummyWizardDataImpl(ArrayList<Wizard> list) {
		super();
		this.list = list;
	}

	public ArrayList<Wizard> getList() {
		return list;
	}

	public void setList(ArrayList<Wizard> list) {
		this.list = list;
	}

	public static int getWIZARD_ID() {
		return WIZARD_ID;
	}

	public static void setWIZARD_ID(int wIZARD_ID) {
		WIZARD_ID = wIZARD_ID;
	}

	@Override
	public void add(Wizard w) {
		WIZARD_ID++;
		w.setId(WIZARD_ID);
		System.out.println("In data layer: adding new wizard...\n" + w);
		list.add(w);
		System.out.println("In data layer: list size is now: " + list.size());
	}

	@Override
	public void delete(Wizard w) {
		System.out.println("In data layer: removing wizard...\n" + w);
		list.remove(w);
	}

	@Override
	public Wizard get(int index) {
		return list.get(index);
	}

}
