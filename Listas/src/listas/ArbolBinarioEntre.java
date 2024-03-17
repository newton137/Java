package listas;
public class ArbolBinarioEntre {
class Nodo{
	int dato;
	Nodo izquierdo, derecho;
}
private Nodo raiz;
int cant;
int altura;
public ArbolBinarioEntre(){
	raiz = null;
}
public void insertar(int dato){
	if(!existe(dato)){
		Nodo nuevo = new Nodo();
		nuevo.dato = dato;
		nuevo.izquierdo = null;
		nuevo.derecho = null;
		if(raiz == null){
			raiz = nuevo;
		}else{
			Nodo anterior = null,recorrer;
			recorrer = raiz;
			while(recorrer != null){
				anterior = recorrer;
				if(dato < recorrer.dato){
					recorrer = recorrer.izquierdo;
				}else{
					recorrer = recorrer.derecho;
				}
			}
			if(dato < anterior.dato){
				anterior.izquierdo = nuevo;
			}else{
				anterior.derecho = nuevo;
			}
		}
	}
}
public boolean existe(int dato){
	Nodo reco = raiz;
	while(reco != null){
	if(reco.dato == dato){
		return true;
	}else{
		if(dato < reco.dato){
			reco = reco.izquierdo;
		}else{
			reco = reco.derecho;
		}
	}
	}
	return false;
}
private void imprimirEntre(Nodo recorrer){
	if(recorrer != null){
		imprimirEntre(recorrer.izquierdo);
		System.out.println(recorrer.dato);
		imprimirEntre(recorrer.derecho);
	}
}
private void imprimirEntre(){
	imprimirEntre(raiz);
	System.out.println();
}
private void cantidad(Nodo recorrer){
	if(recorrer != null){
		cant++;
		cantidad(recorrer.izquierdo);
		cantidad(recorrer.derecho);
	}
}
public int cantidad(){
	cant = 0;
	cantidad(raiz);
	return cant;
}
private void cantidadHojas(Nodo recorrer){
	if(recorrer != null){
		if(recorrer.izquierdo == null && recorrer.derecho == null){
			cant++;
		}
		cantidadHojas(recorrer.izquierdo);
		cantidadHojas(recorrer.derecho);
	}
}
public int cantidadHojas(){
	cant = 0;
	cantidadHojas(raiz);
	return cant;
}
public void imprimirEntreConNivel(Nodo recorrer, int nivel){
	if(recorrer != null){
		imprimirEntreConNivel(recorrer.izquierdo, nivel+1);
		System.out.println(recorrer.dato + " ( " + nivel + " ) ");
		imprimirEntreConNivel(recorrer.derecho, nivel+1);
	}
}
public void imprimirEntreConNivel(){
	imprimirEntreConNivel(raiz, 1);
	System.out.println();
}
private void retornarAltura(Nodo recorrer, int nivel){
	if(recorrer != null){
		retornarAltura(recorrer.izquierdo, altura+1);
		if(nivel > altura){
			altura = nivel;
		}
		retornarAltura(recorrer.derecho, altura+1);
	}
}
public int retornarAltura(){
	altura = 0;
	retornarAltura(raiz , 1);
	return altura;
}
public static void main(String [] argumentos){
	ArbolBinarioEntre objeto = new ArbolBinarioEntre();
	objeto.insertar(100);
	objeto.insertar(200);
	objeto.insertar(50);
	objeto.insertar(300);
	objeto.insertar(150);
	objeto.insertar(75);
	objeto.insertar(25);
	objeto.imprimirEntre();
	System.out.println(objeto.cantidad());
	System.out.println(objeto.cantidadHojas());
	System.out.println(objeto.retornarAltura());
	objeto.imprimirEntreConNivel();
	
}
}
