package model;

import java.io.Serializable;
import java.util.ArrayList;

import debug.Debuggable;

public class Automobile implements Debuggable, Serializable {
	/////////////////////////////////////////
	// INSTANCE VARIABLES
//	private String name;
	private int numOfProperties;
	private int basePrice;
	
	// new:
	private String owner;
	private String make;
	private String model;
	private String year;
	private ArrayList<OptionSet> opset;
	private ArrayList<Option> choices;

	/////////////////////////////////////////
	// CONSTRUCTORS
	public Automobile() {
		choices = new ArrayList<Option>();
	}

	public Automobile(String[] name, ArrayList<OptionSet> opset, int basePrice) {
		if (DEBUG)
			System.out.println("Constructing Automobile");
		this.make = name[0];
		this.model = name[1];
		this.year = name[2];
		this.opset = opset;
		this.numOfProperties = this.opset.size();
		this.basePrice = basePrice;
		choices = new ArrayList<Option>();
	}

	/////////////////////////////////////////
	// GETTERS / SETTERS
	public String getMakeModelYear() {
		return this.make + " " + this.model + " " + this.year;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getNumOfProperties() {
		return numOfProperties;
	}

	public void setNumOfProperties(int numOfProperties) {
		this.numOfProperties = numOfProperties;
	}

	public ArrayList<OptionSet> getOpset() {
		return opset;
	}

	public void setOpset(ArrayList<OptionSet> opset) {
		this.opset = opset;
	}

	public ArrayList<Option> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<Option> choices) {
		this.choices = choices;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public String getOptionSetName(int n) {
		return this.opset.get(n).getOptionType();
	}

	public void setOptionSetName(String newName, int i) {
		this.opset.get(i).setOptionType(newName);
	}

	public String getOptionName(int i, int j) {
		return this.opset.get(i).getOptions().get(j).getOptionTitle();
	}

	public void setOptionName(String newName, int i, int j) {
		this.opset.get(i).getOptions().get(j).setOptionTitle(newName);
	}

	public ArrayList<Option> getOptionArrayList(int i) {
		return this.opset.get(i).getOptions();
	}

	public int getOptionChoicePrice(String optionSetName) {
		int p = 0;
		boolean found = false;
		
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getOptionType().equalsIgnoreCase(optionSetName)) {
				p = choices.get(i).getPrice();
				found = true;
			}
		}
		
		if (found)
			System.out.println("Choice was found");
		else
			System.out.println("Choice wasn't found");
		
		return p;
	}
	
	public int getOptionPrice(int i, int j) {
		return this.opset.get(i).getOptions().get(j).getPrice();
	}

	public void setOptionPrice(int i, int j, int newPrice) {
		this.opset.get(i).getOptions().get(j).setPrice(newPrice);
	}
	
	public void setOptionChoice(String optionSetName, String optionName) {
		boolean added = false;

		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getOptionType().equalsIgnoreCase(optionSetName)) {
				for (int j = 0; j < opset.get(i).getOptions().size(); j++) {
					if (opset.get(i).getOptions().get(j).getOptionTitle().equalsIgnoreCase(optionName)) {
						choices.add(opset.get(i).getOptions().get(j));
						added = true;	
					}
				}
			}
		}
		
		if (added)
			System.out.println("Choice successfully added");
		else
			System.out.println("Choice wasn't added");
	}
	
	public String getOptionChoice(String optionSetName) {
		String name = new String();
		boolean found = false;
		
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getOptionType().equalsIgnoreCase(optionSetName)) {
				name = choices.get(i).getOptionTitle();
				found = true;
			}
		}
		
		if (found)
			System.out.println("Choice was found");
		else
			System.out.println("Choice wasn't found");
		
		return name;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	/////////////////////////////////////////
	// METHODS
	public OptionSet createOptionSet() {
		return new OptionSet();
	}
	
	public int getChoicingPrice() {
		int total = 0;
		
		for (int i = 0; i < choices.size(); i++) {
			total += choices.get(i).getPrice();
		}
		
		return total;
	}

	public void addOpset() {
		// not writing until Collections can be used. For now changes will be made in
		// the .txt file
	}

	public void deleteOpset() {
		// not writing until Collections can be used.
	}

	public void addOption() {
		// not writing until Collections can be used.
	}

	public void deleteOption() {
		// not writing until Collections can be used.
	}

	public void print() {
		System.out.println("=========================================\n");
		System.out.println("\t" + make + " " + model + " " + year);
		System.out.println("");
		System.out.println("Base Price: $" + this.basePrice);
		System.out.println("Options   :  " + this.numOfProperties);
		System.out.println("");
		for (int i = 0; i < numOfProperties; i++)
			this.opset.get(i).print();
		System.out.println();
	}
	
	public void printChoices() {
		System.out.println("=========================================\n");
		System.out.println("\t" + owner + "'s " + make + " " + model + " " + year);
		System.out.println("");
		System.out.println("\t\t Chosen Options:");
		System.out.println("");
		for (int i = 0; i < choices.size(); i++) {
			choices.get(i).print();
		}
		System.out.println("");
		System.out.println("\t\tBASE PRICE: $" + this.getBasePrice());
		System.out.println("\t\tFEATURES  : $" + this.getChoicingPrice());
		System.out.println("\t\tTOTAL     : $" + (this.getBasePrice() + this.getChoicingPrice()));
		System.out.println("");
	}
	
	public void printInfo() {
		System.out.println(this.owner + " | " + this.getMakeModelYear() + " | $" + (this.getBasePrice() + this.getChoicingPrice()));
	}

}
