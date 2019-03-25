import java.text.DecimalFormat;

public class BMI {

	private int weight;
	private int height;
	private int option;
	private double cBmi;
	
	//Getters
	public int getWeight(){
		return this.weight;
	}
	public int getHeight() {
		return this.height;	
	}
	public int getOption() {
		return this.option;	
	}
	
	//Setters
	public void setWeight(int wgh, int opt) {
			if (wgh > 0) 
				this.weight = wgh;
			if (wgh <= 0 && opt == 1) 
				this.weight = 70;
			if (wgh <= 0 && opt == 2) 
				this.weight = 154;			
	}
	
	public void setHeight(int hgt, int opt) {
		if (hgt > 0) 
			this.height = hgt;
		if (hgt <= 0 && opt == 1)            
			this.height = 170;
		if (hgt <= 0 && opt == 2) 
			this.height = 66;	
	}
	
	public void setOption(int opt) {
		this.option = opt;	
	}
	
	//Default constructor
	public BMI() {	
		weight = 70;
		height = 170;
		option = 1;
		BMIcalc(option);
	}
	
	//Overloaded Constructor
	public BMI(int wgh, int hgt, int opt) {
		this.setWeight(wgh, opt);
		this.setHeight(hgt, opt);
		this.setOption(opt);
		BMIcalc(opt);	
	}
	
	//BMI formula
	public double BMIcalc(int opt) {
		
		double mHeight;
		
		if (opt == 1) {
			mHeight = (double)height/100;
			cBmi = (double)this.weight/(mHeight * mHeight);
		}
		if (opt == 2) {
			cBmi = ((double)this.weight/(double)(this.height * this.height)) * 703;
		}	
		return cBmi;
	}
	
	public String toString() {
		String bmiLit = "";
		DecimalFormat df1 = new DecimalFormat("##.##");
		
		if (cBmi < 18.50) {
			bmiLit = "Underweight";
		}
			if (cBmi >= 18.50 && cBmi <= 24.99) {
				bmiLit = "Normal weight";
			}
				if (cBmi >= 25 && cBmi <= 29.99) {
					bmiLit = "Overweight";
				}
					if (cBmi >= 30 && cBmi <= 35) {
						bmiLit = "Obese";
					}
						if (cBmi > 35.10) {
							bmiLit = "Severly Obese";
						}
						
		String oBMI = df1.format(cBmi);
		String s = "Your BMI is " + oBMI + " and is considered " + bmiLit;
		
		return s;	
	}	
}