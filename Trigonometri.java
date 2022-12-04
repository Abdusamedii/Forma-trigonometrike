import java.util.Scanner;
import java.lang.Math;

public class Trigonometri{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Shkruani funksionin trigonometrik qe deshironi ta gjeni: ");
		String st1 = sc.next();
		String numberOnly= st1.replaceAll("[^0-9]", " ");
		String[] splitStr = numberOnly.split("\\s+");
		double x = Integer.valueOf(splitStr[1]);
		
		//double a = sc.nextFloat();
		//int b = (int)a;
		x = Math.toRadians(x);
		//a = Math.sin(a);
		//float z = (float)a;
		
		if(st1.contains("sin")){
			double z = Math.sin(x);
			System.out.print((float)z);
			if((float)z == 0.5){
				System.out.print(" ose 1/2");
			}
			if(numberOnly.contains("150")){
				System.out.print(" ose 1/2");
			}
			if(numberOnly.contains("45") || numberOnly.contains("135")){
				System.out.print(" ose sqr(2)/2");
			}
			if(numberOnly.contains("60") || numberOnly.contains("120")){
				System.out.print(" ose sqr(3)/2");
			}
			if(numberOnly.contains("210") || numberOnly.contains("330")){
				System.out.print(" ose -1/2");
			}
			if(numberOnly.contains("225") || numberOnly.contains("315")){
				System.out.print(" ose -sqr(2)/2");
			}
			if(numberOnly.contains("240") || numberOnly.contains("300")){
				System.out.print(" ose -sqr(3)/2");
			}
			
		}
		if(st1.contains("cos")){
			double z = Math.cos(x);
			System.out.print((float)z);
			if(z == 0.8660254037844387){
				System.out.print(" ose sqr(3)/2");
			}
			if(numberOnly.contains("330")){
			System.out.print(" ose sqr(3)/2");
			}
			if(numberOnly.contains("45") || numberOnly.contains("315")){
				System.out.print(" ose sqr(2)/2");
			}
			if(numberOnly.contains("60") || numberOnly.contains("300")){
				System.out.print(" ose 1/2");
			}
			if(numberOnly.contains("150") || numberOnly.contains("210")){
				System.out.print(" ose -sqr(3)/2");
			}
			if(numberOnly.contains("135") || numberOnly.contains("225")){
				System.out.print(" ose -sqr(2)/2");
			}
			if(numberOnly.contains("120") || numberOnly.contains("240")){
				System.out.print(" ose -1/2");
			}
			
		}
		if(st1.contains("tg") || st1.contains("tan")){
			double z = Math.tan(x);
			System.out.print((float)z);
			if(z == 0.5773502691896257){
				System.out.print(" ose sqr(3)/3");
			}
			if(numberOnly.contains("210")){
			System.out.print(" ose sqr(3)/3");
			}
			if(numberOnly.contains("60") || numberOnly.contains("240")){
				System.out.print(" ose sqr(3)");
			}
			if(numberOnly.contains("120") || numberOnly.contains("300")){
				System.out.print(" ose -sqr(3)");
			}
			if(numberOnly.contains("150") || numberOnly.contains("330")){
				System.out.print(" ose -sqr(3)/3");
			}
			
		}
		if(st1.contains("cg") || st1.contains("cot")){
			double z = Math.tan(x);
			double t = 1/z;
			System.out.print((float)t);
			if(t == 1.7320508075688774){
				System.out.print(" ose sqr(3)/2");
			}
			if(numberOnly.contains("330")){
			System.out.print(" ose sqr(3)/2");
			}
			if(numberOnly.contains("45") || numberOnly.contains("315")){
				System.out.print(" ose sqr(2)/2");
			}
			if(numberOnly.contains("60") || numberOnly.contains("300")){
				System.out.print(" ose 1/2");
			}
			if(numberOnly.contains("150") || numberOnly.contains("210")){
				System.out.print(" ose -sqr(3)/2");
			}
			if(numberOnly.contains("135") || numberOnly.contains("225")){
				System.out.print(" ose -sqr(2)/2");
			}
			if(numberOnly.contains("120") || numberOnly.contains("240")){
				System.out.print(" ose -1/2");
			}
			//Versioni 0.1
		}
	}
	
}
