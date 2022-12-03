import java.util.Scanner;
import java.lang.Math;

public class mbledhjaTrig{
	public static void main(String [] args){
		// me bo
		//sin(a+b) = sina*cosb+cosa*sinb
		//sin(a-b) = sina*cosb-cosa*sinb
		//cos(a+b) = cosa*cosb-sina*sinb
		//cos(a-b) = cosa*cosb+sina*sinb
		Scanner sc = new Scanner(System.in);
		System.out.println("Shkruani funksionin e mbledhjes trigonometrike qe deshironi te beni: ");
		String st1 = sc.next();
		String numberOnly= st1.replaceAll("[^0-9]", " ");
		String[] splitStr = numberOnly.split("\\s+");
		double x = Integer.valueOf(splitStr[1]);
		double y = Integer.valueOf(splitStr[2]);
		x = Math.toRadians(x);
		float a = (float)x;
		y = Math.toRadians(y);
		float b = (float)y;		
		//System.out.println(numberOnly);
		if(st1.contains("sin") && st1.contains("+")){
			double zgjidhja = Math.sin(a)*Math.cos(b)+Math.cos(a)*Math.sin(b);
			System.out.println(zgjidhja);
		}
		//versioni 0.0.1 vetem mbledhjen sin(a+b) baza osht kry veq ka mbet mi zavendesu formulat
	}
}