package Matematicas;
import java.util.Scanner;
public class MayorComunDivisor {
public MayorComunDivisor(){
	Scanner teclado = new Scanner(System.in);
	System.out.print("Introduzca 2 números a continuación:");
	long numero1 = teclado.nextLong();
	long numero2 = teclado.nextLong();
	System.out.println("El máximo común divisor es: " + comunDivisor(numero1, numero2));
}
public long comunDivisor(long num1, long num2){
	while(num1 != num2){
		if(num1 > num2)
			num1 -= num2;
		else
			num2 -= num1;
	}
	return num1;
}
public static void main(String[] args){
	MayorComunDivisor objeto = new MayorComunDivisor();
}
}
