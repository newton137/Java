package listas;
public class ArbolBinarioOrdenado {
public class Nodo{
	int dato;
	Nodo izquierdo, derecho;
}
private Nodo raiz;
public ArbolBinarioOrdenado(){
	raiz = null;
}
public void insertar(int informacion){
	Nodo nuevo = new Nodo();
	nuevo.dato = informacion;
	nuevo.izquierdo = null;
	nuevo.derecho = null;
	if(raiz == null){
		raiz = nuevo;
	}else{
		Nodo anterior = null, recorrer;
		recorrer = raiz;
		while(recorrer != null){
			anterior = recorrer;
			if(informacion < recorrer.dato){
				recorrer = recorrer.izquierdo;
			}else{
				recorrer = recorrer.derecho;
			}
		}
		if(informacion < anterior.dato){
			anterior.izquierdo = nuevo;
		}else{
			anterior.derecho = nuevo;
		}
	}
}
public void imprimirPre(Nodo recorrer){
	if(recorrer != null){
		System.out.println(recorrer.dato);
		imprimirPre(recorrer.izquierdo);
		imprimirPre(recorrer.derecho);
	}
}
public void imprimirPre(){
	imprimirPre(raiz);
	System.out.println();
}
public void imprimirEntre(Nodo recorrer){
	if(recorrer != null){
		imprimirEntre(recorrer.izquierdo);
		System.out.println(recorrer.dato);
		imprimirEntre(recorrer.derecho);
	}
}
public void imprimirEntre(){
	imprimirEntre(raiz);
	System.out.println();
}
public void imprimirPos(Nodo recorrer){
	if(recorrer != null){
		imprimirPos(recorrer.izquierdo);
		imprimirPos(recorrer.derecho);
		System.out.println(recorrer.dato);
	}
}
public void imprimirPos(){
	imprimirPos(raiz);
	System.out.println();
}
public static void main(String [] argumentos){
	ArbolBinarioOrdenado objeto = new ArbolBinarioOrdenado();
	objeto.insertar(10);
	objeto.insertar(5);
	objeto.insertar(3);
	objeto.insertar(7);
	objeto.insertar(15);
	objeto.insertar(13);
	objeto.insertar(17);
	objeto.imprimirPre();
	objeto.imprimirEntre();
	objeto.imprimirPos();
}
}
