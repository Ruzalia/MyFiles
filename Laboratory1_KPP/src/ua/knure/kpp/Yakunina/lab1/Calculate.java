package ua.knure.kpp.Yakunina.lab1;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double Z, y;
		for(double a=3.0, n=-5.0; (a<=15.0)&(n<=1.0); a+=0.58, n+=0.5){
			Z=2*(1/(Math.sqrt(a)+Math.sqrt(a+1)))/(1+Math.sqrt((a+1)/(a-1)));
			y=(Math.pow(Z, 2.0)+n)/(Math.abs(Z*Z-n+1)+3)-((n*n-Z+2)/(Math.abs(n*n-Z-2)+2));
			System.out.printf("Z=%4.3f\t",Z);
			System.out.printf("y=%4.3f\n",y);
		}
	}
}

