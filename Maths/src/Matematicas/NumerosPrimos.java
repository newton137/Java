package Matematicas;
import java.lang.Long;
public class NumerosPrimos {
public NumerosPrimos(){
	long numero = 999999999;	//Se coloca un número impar
	for(long x = 7; x <= numero; x += 2){	//todo número par no es primo, exceptuando el 2
		if(x%5==0)	//cualquier número que lleve un cinco com ultima cifra no es primo
			continue;
		int auxiliar = 0;
		for(long y = 3; y <= x/2; y += 2){
			if(x%y==0){
				auxiliar++;
				y = x;
			}			
		}
		if(auxiliar == 0){
			System.out.println(x);
		}
	}
}
public static void main(String [] args){
	NumerosPrimos primos = new NumerosPrimos();
}
}
