package practice;
import java.util.Scanner;

public class BodyMaxIndex {

  private static float getBMI(float weight, float height) {
	 return (weight / (float)Math.pow(height, 2));
  }
	
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter your weight in kilograms: ");
	float weight = input.nextFloat();
	System.out.print("Enter your height in meters: ");
	float height = input.nextFloat();
	System.out.print("\n");
	// TODO: Configure a dot separator for decimal output
	System.out.printf("Your BMI is %.2f.", getBMI(weight, height));
	input.close();
  }
	
}
