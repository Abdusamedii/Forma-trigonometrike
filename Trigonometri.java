import java.util.Scanner;
import java.lang.Math;

public class Trigonometri{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Shkruani ne shkalle: ");
		double a = sc.nextFloat();
		int b = (int)a;
		a = Math.toRadians(a);
		a = Math.sin(a);
		float x = (float)a;
		
		System.out.println("Sinusi i " + b + " shkalleve eshte " +  x);
		//Versioni 0.0.1
	}
	
}
