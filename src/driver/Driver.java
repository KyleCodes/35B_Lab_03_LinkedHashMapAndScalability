package driver;

import adapter.*;

public class Driver {
	public static void main(String[] args) {		
		/*
		 * load car from file 
		 * 
		 * pick options into choices
		 * 
		 * display listed choices for given model
		 * 
		 * add choices to the LHM database
		 * 
		 */
		
		/////////////////////////////////////////
		// LOOKUP / CHANGE VARIABLES
		String modelName = "ford_focus_wgn_ztw_2010";
		String fileName = modelName + ".txt";
		String name = "Kyle Muldoon";
		String opset1 = "Color";
		String opset2 = "Transmission";
		String opset3 = "Brakes/Traction Control";
		String opset4 = "Side Impact Airbags";
		String opset5 = "Moonroof";
		String choice1 = "Grabber Green Clearcoat Metallic";
		String choice2 = "Manual";
		String choice3 = "ABS and Advance Trac";
		String choice4 = "present";
		String choice5 = "present";

		/////////////////////////////////////////
		// CREATEAUTO
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto(fileName);
		a1.printAuto(modelName);
		
		/////////////////////////////////////////
		// CHOOSEAUTO
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("\t\t SELECTING " + name.toUpperCase() + "'S CHOICES\n");
		ChooseAuto a2 = new BuildAuto();
		a2.setOwner(name);
		a2.setChoice(opset1, choice1);
		a2.setChoice(opset2, choice2);
		a2.setChoice(opset3, choice3);
		a2.setChoice(opset4, choice4);
		a2.setChoice(opset5, choice5);
		a2.printChoices();
		String MMY = a2.getMakeModelYear();
		
		/////////////////////////////////////////
		// DATABASEAUTO
		DataBaseAuto a3 = new BuildAuto();
		a3.addAuto(MMY, name);
		System.out.println("=========================================");
		System.out.println("");
		System.out.println("\t DATABASE LIST:");
		System.out.println("");
		a3.printList();
	}
}
