package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import debug.Debuggable;

public class Fleet implements Debuggable, Serializable {
	/////////////////////////////////////////
	// INSTANCE VARIABLES
	private LinkedHashMap<String, Automobile> lhm;
	
	
	/////////////////////////////////////////
	// CONSTRUCTORS
	public Fleet() {
		lhm = new LinkedHashMap<String, Automobile>();
	}
	
	
	/////////////////////////////////////////
	// GETTERS / SETTERS

	
	
	/////////////////////////////////////////
	// METHODS
	public void addAuto(String makeModelYear, Automobile auto) {
		lhm.put(makeModelYear, auto);
		if (DEBUG)
			System.out.println("Successfully added to Database");
	}
	
	public Automobile retrieveAuto(String makeModelYear) {
		return lhm.get(makeModelYear);
	}
	
	public void updateAuto(String makeModelYear, Automobile auto) {
		lhm.replace(makeModelYear, auto);
	}
	
	public void deleteAuto(String makeModelYear) {
		lhm.remove(makeModelYear);
	}
	
	/////////////////////////////////////////
	// PRINT
	public void print() {
		Set<String> keys = lhm.keySet();
		for (String k:keys) {
			lhm.get(k).print();
		}
	}
	
	public void printList() {
		Set<String> keys = lhm.keySet();
		for (String k:keys) {
			lhm.get(k).printInfo();
		}
	}
}
