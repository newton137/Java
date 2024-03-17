package Matematicas;
public class ProblemaMilReinas {
int reinas, contador, contador2;
int []posicionesIniciales;
Nodo recorrer;
public ProblemaMilReinas(){
	reinas = 8;
	contador = 1;
	posicionesIniciales = new int[reinas]; 
	for(int x : posicionesIniciales){
		x = 0;
	}
}
public class Nodo{
	int reina;
	Nodo anterior,siguiente;
}
private Nodo raiz = null;

public void insertar(int dato){
	if(dato > reinas){
		dato = 1;
	}
	if(comprobarPosicion(dato)){
		Nodo nuevaReina = new Nodo();
		nuevaReina.reina = dato;
		nuevaReina.anterior = raiz.anterior;
		raiz.anterior = nuevaReina;
		contador++;
		if(posicionesIniciales[contador] == 0){
			posicionesIniciales[contador] = dato;
		}
	}else{
		insertar(dato+1);
	}
	if(contador == reinas){
		imprimir();
		}
}
public boolean comprobarPosicion(int dato){
	Nodo recorrer = raiz.anterior;
	int positivo = dato+1;
	int negativo = dato-1;
	do{
		if(recorrer.reina != dato && recorrer.reina != positivo && recorrer.reina != negativo){
			recorrer = recorrer.anterior;
			positivo++;
			negativo--;
		}else{
			return false;
		}
	}while(recorrer != raiz.anterior);
	return true;
}
public void insertar1(int dato){
	Nodo nuevaReina = new Nodo();
	nuevaReina.reina = dato;
	raiz = nuevaReina;
	nuevaReina.anterior = nuevaReina;
	posicionesIniciales[0] = 1;
}
public void imprimir(){
	recorrer = raiz.anterior;
	contador2 = reinas;
	while(recorrer != raiz.anterior){
		System.out.print(contador2 + " , " + recorrer.reina + " - ");
		recorrer = recorrer.anterior;
		contador2--;
	}
	System.out.println();
}
public static void main(String [] argumentos){
	ProblemaMilReinas prueba = new ProblemaMilReinas();
	prueba.insertar1(1);
	prueba.insertar(3);
}
}
