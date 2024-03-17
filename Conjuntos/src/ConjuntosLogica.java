
public class ConjuntosLogica {
	static int[] union(int arr1[],int arr2[], int arr3[]){
		for(int i = 0; i < arr1.length; i++){
			arr3[i] = arr1[i];
		}
		for(int i = arr1.length; i < arr3.length; i++){
			arr3[i] = arr2[i - arr1.length];
		}
		return arr3;
	}
	static void imprimir(int arr[]){
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args){
		int[] arreglo1 = {4,5,3,6};
		int[] arreglo2 = {9,2,5,1};
		int[] arreglo3 = new int[arreglo1.length + arreglo2.length];
		arreglo3 = union(arreglo1, arreglo2, arreglo3);
		imprimir(arreglo3);
	}
}
