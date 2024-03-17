package com.fenix.InteligenciaArtificial;
import java.util.Random;
public class AlgoritmosGeneticos1 {
	int hijos[] = new int[2];
	int iteraciones = 10;
public void ag(int individuos[],int digitos){
	for(int z = 0; z < 10; z++){
		for(int w = 0; w < individuos.length; w++){
			for(int v = 0; v < individuos.length; v++){
				System.out.print(individuos[v]+", ");
			}
			System.out.println();
			Random aleatorio = new Random();
			int posicion1 = aleatorio.nextInt(individuos.length);
			int x = individuos[posicion1];
			int posicion2 = aleatorio.nextInt(individuos.length);
			int y = individuos[posicion2];
			System.out.println("Se reproducen: " + x + ", " + y);
			reproduccion(x,y);
			for(int hijo = 0; hijo < hijos.length;hijo++){
				String string = Integer.toString(hijos[hijo]);
				char[] partes = string.toCharArray();
				for(int parte = 0; parte < partes.length; parte++){
					if(aleatorio.nextInt(10) < 1){
						partes[parte] = (char)aleatorio.nextInt(10);
					}
				}
				string = String.valueOf(partes);
				hijos[hijo] = Integer.parseInt(string);
			}
			System.out.println("MUTACIÓN: " + hijos[0] + ", "+ hijos[1]);
			individuos[posicion1] = hijos[0];
			individuos[posicion2] = hijos[1];
		}
	}
}
public void reproduccion(int x, int y){
int longitud = Integer.toString(x).length();
Random Corte = new Random();
int posicionCorte = Corte.nextInt(longitud-1);
String unoUno = Integer.toString(x).substring(0, posicionCorte);
String unoDos = Integer.toString(x).substring(posicionCorte, longitud);
String dosUno = Integer.toString(y).substring(0, posicionCorte);
String dosDos = Integer.toString(y).substring(posicionCorte, longitud);
hijos[0] = Integer.parseInt(unoUno + dosDos);
hijos[1] = Integer.parseInt(dosUno + unoDos);
System.out.println("Obteniendo los hijos:" + hijos[0] + ", "+ hijos[1]);
}
public static void main(String []argumentos){
	AlgoritmosGeneticos1 algoritmo1 = new AlgoritmosGeneticos1();
	int arreglo[] = {4444,5555,6666,3333};
	algoritmo1.ag(arreglo, 4);
}
}
