/* This program will calculate your BMI in metric or imperial units. It will use the public class BMI to create
 * new BMI objects, calculate and create the output of the results.
 * 
 * Nico Busatto 03/20/2019
 *
 */
import java.util.Scanner;

public class BMIProgram {
	static Scanner menuScanner;
	static BMI metricBMI = new BMI();   //Instantiate new object BMI for metric entries
	static BMI imperialBMI = new BMI();   //Instantiate new object BMI for imperial entries
	
	public static void main(String[] args) {
		boolean ok = true;
		boolean ok2 = true;
		boolean ok3 = true;
		char Again = ' ';
		
		init();
		do {
			input();        
			do {
				do {
					System.out.println("Do you want to calculate another BMI? Y or N ");        
					try {
						Again = menuScanner.next().trim().toUpperCase().charAt(0);               
						ok3 = true;
					} catch (Exception e) {                          //Try/catch for empty entry
						System.out.println("No option has been entered, please try again.");
						System.out.println(" ");
						ok3 = false;     //Y or N empty entry loop control
					}
				} while (ok3 == false);	
				if (Again == 'Y') {
					ok = false;
					ok2 = true;	          
				}
				else if (Again == 'N') {
					ok = true;
					ok2 = true;
				} else {
					System.out.println("Invalid entry, only Y or N allowed.");
					System.out.println(" ");
					ok = true;
					ok2 = false;
				}	
			} while (ok2 == false);	   //Y or N invalid entry loop control	
		} while (ok == false);      //Program loop control
		exit();
	}

	public static void init() {
		menuScanner = new Scanner(System.in);               //Init new menu scanner
    	menuScanner.useDelimiter(System.getProperty("line.separator"));		
	}
		
	public static void input() {		
		int iOption = 0;
    	boolean ok = true;   
  	
    	do {
    		try { 
    			System.out.format("%40s%25s%25s", " ", "BMI CALCULATOR", " ");    //Print heading
    			System.out.println("");
    			System.out.println("");
    			System.out.println("1 - Metric Calculator");			      //Print menu option 1
    			System.out.println("2 - Imperial Calculator");			      //Print menu option 2
    			System.out.println("3 - Exit");                                //Print menu option 3
    			System.out.println("");
    			iOption = Integer.parseInt(menuScanner.next());		
					if (iOption == 1) {    
						getMetricWeight(iOption);  //Call metric weigth method
						getMetricHeight(iOption);  //Call metric height method
						metricOutput();            //Call metric output
						ok = true;             
					}
					else if (iOption == 2) {
						getImperialWeight(iOption);  //Call imperial weigth method
						getImperialHeight(iOption); //Call imperial height method
						imperialOutput();           //Call imperial output
						ok = true;                            
					}
					else if (iOption == 3) {
						exit();				//Call exit if option 3 is prompted
					}
					else {           //Input check
						System.out.println("Option can only be 1, 2 or 3. Re-entry");
						ok = false;
					}
    		} catch (Exception e) {   //Catch illegal characters in main menu
    			System.out.println("Option can only be 1, 2 or 3. Re-entry");
    			ok = false;	
    		}
    	} while (!ok);     //main menu valid entry loop control
	}
	
	public static void getMetricWeight(int iOption) {	
		int weight = 0;
		boolean ok = true;
		
		do {
			try {
				System.out.println("");
				System.out.println("Please enter your weight in Kilograms: ");	
				weight = Integer.parseInt(menuScanner.next());      //Prompt for metric weight and parse value
				if (weight <= 0) {
					System.out.println("0 or less is not allowed. Weight defaulted to 70 Kgs.");
				}
				metricBMI.setWeight(weight, iOption);               //call setWeight method and set weight value for BMI object
				ok = true;                                          
			} catch (Exception e) {        
				System.out.println("Only numbers allowed. Please re-enter.");
				ok = false;
			}
		} while (!ok);                                              //Illegal entries loop controller
	}
	
	public static void getMetricHeight(int iOption) {	
		int height = 0;
		boolean ok = true;
		
		do {
			try {
				System.out.println("");
				System.out.println("Enter your height in Centimeters: ");	
				height = Integer.parseInt(menuScanner.next());	       //Prompt for metric height and parse value
				if (height <= 0) {
					System.out.println("0 or less is not allowed. Height defaulted to 170 Cms.");
				}
				metricBMI.setHeight(height, iOption);                  //Call setHeight method and set height value for BMI metric object
				metricBMI.BMIcalc(iOption);                            //Call BMIcalc method for final metric calculation 
				ok = true;                                             
			} catch (Exception e) {
				System.out.println("Only numbers allowed. Please re-enter.");
				ok = false;
			}
		} while (!ok);                                                 //Illegal entries loop controller
	}	
	
	public static void getImperialWeight(int iOption) {	
		int weight = 0;
		boolean ok = true;
		
		do {
			try {
				System.out.println("");
				System.out.println("Please enter your weight in Pounds: ");
				weight = Integer.parseInt(menuScanner.next());           //Prompt for imperial weight and parse value
				if (weight <= 0) {
					System.out.println("0 or less is not allowed. Weight defaulted to 154 Lbs.");
				}
				imperialBMI.setWeight(weight, iOption);                  //call setWeight method and set weight value for BMI imperial object
				ok = true;                                               //Illegal entries loop controller
			} catch (Exception e) {
				System.out.println("Only numbers allowed. Please re-enter.");
				ok = false;
			}
		} while (!ok);	                                                  //Illegal entries loop controller
	}
	
	public static void getImperialHeight(int iOption) {
		int height = 0;
		boolean ok = true;
		
		do {
			try {
				System.out.println("");
				System.out.println("Enter your height in Inches: ");
				height = Integer.parseInt(menuScanner.next());           //Prompt for imperial height and parse value
				if (height <= 0) {
					System.out.println("0 or less is not allowed. Height defaulted to 66 inches.");
				}
				imperialBMI.setHeight(height, iOption);                  //Call setHeight method and set height value for BMI imperial object
				imperialBMI.BMIcalc(iOption);                            //Call BMIcalc method for final metric calculation 
				ok = true;                                               
			} catch (Exception e) {
				System.out.println("Only numbers allowed. Please re-enter.");
				ok = false;
			} 
		} while (!ok);                                                   //Illegal entries loop controller
	}	
	
	public static void metricOutput() {
		System.out.println("");
		System.out.println(metricBMI.toString());                        //Call to string method and print metric BMI output.
		System.out.println("");
	}	
	
	public static void imperialOutput() {
		System.out.println("");
		System.out.println(imperialBMI.toString());                       //Call to string method and print imperial BMI output.
		System.out.println("");
	}
	
	public static void exit() {
		System.out.println("Program ending, have a great day!");               //Print closing message and terminate process.
    	System.exit(0);
	}
}