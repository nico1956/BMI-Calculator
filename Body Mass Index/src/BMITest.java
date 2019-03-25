
public class BMITest {

	public static void main(String[] args) {
		
		BMI bmi1 = new BMI();                   //Default constructor initialization
		BMI bmi2 = new BMI(170,65,2);           //Metric constructor initialization
		BMI bmi3 = new BMI(90,240,1);           //Imperial constructor initialization
		
		//Print them out
		System.out.println("BMI Test: \n");
		System.out.println(bmi1.toString());
		System.out.println(bmi2.toString());
		System.out.println(bmi3.toString());
	}	
}
