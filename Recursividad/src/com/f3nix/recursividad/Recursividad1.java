package com.f3nix.recursividad;

public class Recursividad1 {
public void imprimir(int x){
	if(x > 0){
		System.out.println(x);
		imprimir(x-2);
	}
}
public int factorial(int f){
	if(f > 0){
		f *= factorial(f-1);
		return f;
	}else
		return 1;
	}

public static void main(String [] args){
	Recursividad1 objeto = new Recursividad1();
	objeto.imprimir(10);
	System.out.println(objeto.factorial(5));
}
}
