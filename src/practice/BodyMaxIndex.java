package practice;
import java.util.Locale;
import java.util.Scanner;
import format.DecimalFormatter;

public class BodyMaxIndex {

  private static float getBMI(float weight, float height) {
	 
    return (weight / (float)Math.pow(height, 2));
  }
	
  public static void main(String[] args) {

	DecimalFormatter formater = new DecimalFormatter(2, '.');
	
	Scanner input = new Scanner(System.in).useLocale(Locale.US);
	
	System.out.print("Enter your weight in kilograms: ");
	
	float weight = input.nextFloat();
	
	System.out.print("Enter your height in meters: ");
	
	float height = input.nextFloat();
	
	System.out.print("\n");
	
	String result = formater.getFormated(getBMI(weight, height));

	System.out.println("Your BMI is " + result);
	
	input.close();
  }
	
}
