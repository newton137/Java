package listas;

public class ListasGenericasCirculares {
public class Nodo{
	int dato;
	Nodo siguiente,anterior;
}
private Nodo raiz;
public ListasGenericasCirculares(){
	raiz = null;
}
public void insertarInicio(int x){
	Nodo nuevo = new Nodo();
	nuevo.dato = x;
	if(raiz==null){
		nuevo.siguiente = nuevo;
		nuevo.anterior = nuevo;
		raiz = nuevo;
	}else{
		Nodo ultimo = raiz.anterior;
		raiz.anterior = nuevo;
		nuevo.siguiente = raiz;
		nuevo.anterior = ultimo;
		ultimo.siguiente = nuevo;
		raiz = nuevo;
		}
}
public void insertarFinal(int x){
	Nodo nuevo = new Nodo();
	nuevo.dato = x;
	if(raiz == null){
		nuevo.siguiente = nuevo;
		nuevo.anterior = nuevo;
		raiz = nuevo;
	}else{
		Nodo ultimo = raiz.anterior;
		ultimo.siguiente = nuevo;
		nuevo.anterior = ultimo;
		nuevo.siguiente = raiz;
		raiz.anterior = nuevo;
	}
}
public int cantidad(){
	int cantidad = 0;
	if(raiz!=null){
		Nodo recorrer = raiz;
		do{
		cantidad++;
		recorrer = recorrer.siguiente;
	}while(recorrer!=raiz);
	}
	return cantidad;
}
public void imprimir(){
	if(cantidad() != 0){
		Nodo recorrer = raiz;
		do{
			System.out.println(recorrer.dato);
			recorrer = recorrer.siguiente;
		}while(recorrer != raiz);
	}else{
		System.out.println("No hay datos que imprimir!");
	}
}
public void eliminar(int posicion){
	if(cantidad() > 0 && posicion <= cantidad()){
		if(posicion==1){
			if(cantidad() == 1){
				raiz = null;
			}else{
				Nodo ultimo = raiz.anterior;
				raiz = raiz.siguiente;
				raiz.anterior = ultimo;
				ultimo.siguiente = raiz;
			}
		}else{
			Nodo recorrer = raiz;
			for(int x = 1; x < posicion; x++){
				recorrer = recorrer.siguiente;
			}
			Nodo anterior = recorrer.anterior;
			recorrer = recorrer.siguiente;
			recorrer.anterior = anterior;
			anterior.siguiente = recorrer;
			}
		}
}
public static void main(String []args){
	ListasGenericasCirculares objeto = new ListasGenericasCirculares();
	objeto.insertarInicio(5);
	objeto.insertarInicio(10);
	objeto.insertarFinal(15);
	objeto.imprimir();
	objeto.eliminar(3);
	objeto.eliminar(1);
	objeto.imprimir();
}
}
