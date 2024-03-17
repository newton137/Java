package Matematicas;

/*
Este programa toma cuatro algoritmos de ordenamiento (insertion sort, merge sort, quick sort, and heap sort)
y aleatoriamente genera 10, 100, 1000, 2000, y 3000 números y los ordena usando los
cuatro algoritmos. Los números generados van de 0 a 99. Cada algoritmo, genera números que son distintos en cada set
de números y que además son distintos en cada algoritmo (Ejemplo: quick short generará 10 números distintos a heap short)
El tiempo de ejecución de cada algoritmo es colocado debajo del arreglo de números que será impreso. 

En caso que el maestro desee cambiar la cantidad de números a ser ordenados debera tener en cuenta que el tiempo de
ejecución de cada algoritmo es aproximadamente:

Insertion Sort: O(n^2)
Merge Sort: O(nlogn)
Quick Sort: O(nlogn)
Heap Sort: O(nlogn)

Por lo que una cantidad muy grande de números a ordenar como 10,000,000 podría tomarle horas en hacerlo.
*/

import java.util.*;
import java.util.Arrays;
import java.io.*;


public class Algorithm {
	public static void main(String[] args) {
		//Imprime 10 números aleatorios de 0 a 99
		
		//Llamada a las funciones de los 4 algoritmos (10 numeros)
		
		//Insertion Sort-10
		int[] IS10 = new int[10];
		for(int i =0; i < IS10.length; i++)
		{
			IS10[i] = (int)(Math.random() * 100);
		}
		long startTime1 = System.nanoTime();
		insertionSort(IS10);
		long duration1 = System.nanoTime() - startTime1;

		//Merge Sort-10
		int[] MS10 = new int[10];
		for(int i =0; i < MS10.length; i++)
		{
			MS10[i] = (int)(Math.random() * 100);
		}
		long startTime2 = System.nanoTime();
		sort(MS10);
		long duration2 = System.nanoTime() - startTime2;

		//Quick Sort-10
		int[] QS10 = new int[10];
		for(int i =0; i < QS10.length; i++)
		{
			QS10[i] = (int)(Math.random() * 100);
		}
		long startTime3 = System.nanoTime();
		quickSort(QS10);
		long duration3 = System.nanoTime() - startTime3;

		//Heap Sort-10
		int[] HS10 = new int[10];
		for(int i =0; i < HS10.length; i++)
		{
			HS10[i] = (int)(Math.random() * 100);
		}
		long startTime4 = System.nanoTime();
		heapSort(HS10);
		long duration4 = System.nanoTime() - startTime4;

		//Impresión de resultados
		System.out.println("10 números aleatorios ordenados por los siguientes algoritmos: ");
		System.out.println("Insertion Sort: \n" + Arrays.toString(IS10));
		System.out.println("Tiempo de ejecución: " + duration1 + " nanosegundos.");
		System.out.println("\nMerge Sort: \n" + Arrays.toString(MS10));
		System.out.println("Tiempo de ejecución: " + duration2 + " nanosegundos.");
		System.out.println("\nQuick Sort: \n" + Arrays.toString(QS10));
		System.out.println("Tiempo de ejecución: " + duration3 + " nanosegundos.");
		System.out.println("\nHeap Sort: \n" + Arrays.toString(HS10));
		System.out.println("Tiempo de ejecución: " + duration4 + " nanosegundos.");
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\n");


		//Imprime 100 números aleatorios que pueden ir de 0 a 99

		//LLamada a las funciones de los 4 algoritmos (100 números)
		
		//Insertion Sort-100
		int[] IS1000 = new int[100];
		for(int i =0; i < IS1000.length; i++)
		{
			IS1000[i] = (int)(Math.random() * 100);
		}
		long startTime5 = System.nanoTime();
		insertionSort(IS1000);
		long duration5 = System.nanoTime() - startTime5;

		//Merge Sort-100
		int[] MS1000 = new int[100];
		for(int i =0; i < MS1000.length; i++)
		{
			MS1000[i] = (int)(Math.random() * 100);
		}
		long startTime6 = System.nanoTime();
		sort(MS1000);
		long duration6 = System.nanoTime() - startTime6;

		//Quick Sort-100
		int[] QS1000 = new int[100];
		for(int i =0; i < QS1000.length; i++)
		{
			QS1000[i] = (int)(Math.random() * 100);
		}
		long startTime7 = System.nanoTime();
		quickSort(QS1000);
		long duration7 = System.nanoTime() - startTime7;

		//Heap Sort-100
		int[] HS1000 = new int[100];
		for(int i =0; i < HS1000.length; i++)
		{
			HS1000[i] = (int)(Math.random() * 100);
		}
		long startTime8 = System.nanoTime();
		heapSort(HS1000);
		long duration8 = System.nanoTime() - startTime8;

		//Imprime los resultados
		System.out.println("100 números aleatorios ordenados por los siguientes algoritmos: ");
		System.out.println("Insertion Sort: \n" + Arrays.toString(IS1000));
		System.out.println("Tiempo de ejecución: " + duration5 + " nanosegundos.");
		System.out.println("\nMerge Sort: \n" + Arrays.toString(MS1000));
		System.out.println("Tiempo de ejecución: " + duration6 + " nanosegundos.");
		System.out.println("\nQuick Sort: \n" + Arrays.toString(QS1000));
		System.out.println("Tiempo de ejecución: " + duration7 + " nanosegundos.");
		System.out.println("\nHeap Sort: \n" + Arrays.toString(HS1000));
		System.out.println("Tiempo de ejecución: " + duration8 + " nanosegundos.");
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\n");
		

		//Imprime 1000 números aleatorios que pueden ir de 0 a 99
		
		//Llamada a las funciones de cada algoritmo (1000 numeros)
		
		//Insertion Sort-1000
		int[] IS100000 = new int[1000];
		for(int i =0; i < IS100000.length; i++)
		{
			IS100000[i] = (int)(Math.random() * 100);
		}
		long startTime9 = System.nanoTime();
		insertionSort(IS100000);
		long duration9 = System.nanoTime() - startTime9;

		//Merge Sort-1000
		int[] MS100000 = new int[1000];
		for(int i =0; i < MS100000.length; i++)
		{
			MS100000[i] = (int)(Math.random() * 100);
		}
		long startTime10 = System.nanoTime();
		sort(MS100000);
		long duration10 = System.nanoTime() - startTime10;

		//Quick Sort-1000
		int[] QS100000 = new int[1000];
		for(int i =0; i < QS100000.length; i++)
		{
			QS100000[i] = (int)(Math.random() * 100);
		}
		long startTime11 = System.nanoTime();
		quickSort(QS100000);
		long duration11 = System.nanoTime() - startTime11;

		//Heap Sort-1000
		int[] HS100000 = new int[1000];
		for(int i =0; i < HS100000.length; i++)
		{
			HS100000[i] = (int)(Math.random() * 100);
		}
		long startTime12 = System.nanoTime();
		heapSort(HS100000);
		long duration12 = System.nanoTime() - startTime12;	

		//Resultados
		System.out.println("1000 números aleatorios ordenados por los siguientes algoritmos: ");
		System.out.println("Insertion Sort: \n" + Arrays.toString(IS100000));
		System.out.println("Tiempo de ejecución: " + duration9 + " nanosegundos.");
		System.out.println("Merge Sort: \n" + Arrays.toString(MS100000));
		System.out.println("Tiempo de ejecución: " + duration10 + " nanosegundos.");
		System.out.println("Quick Sort: \n" + Arrays.toString(QS100000));
		System.out.println("Tiempo de ejecución: " + duration11 + " nanosegundos.");
		System.out.println("Heap Sort: \n" + Arrays.toString(HS100000));
		System.out.println("Tiempo de ejecución: " + duration12 + " nanosegundos.");
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\n");

		//2000 números aleatorios que pueden ir de 0 s 99
		
		//LLamada a las funciones de cada algoritmo (2000 números)

		//Insertion Sort-2000
		int[] IS1000000 = new int[2000];
		for(int i =0; i < IS1000000.length; i++)
		{
			IS1000000[i] = (int)(Math.random() * 100);
		}
		long startTime13 = System.nanoTime();
		insertionSort(IS1000000);
		long duration13 = System.nanoTime() - startTime13;

		//Merge Sort-2000
		int[] MS1000000 = new int[2000];
		
		for(int i =0; i < MS1000000.length; i++)
		{
			MS1000000[i] = (int)(Math.random() * 100);
		}
		long startTime14 = System.nanoTime();
		sort(MS1000000);
		long duration14 = System.nanoTime() - startTime14;

		//Quick Sort-2000
		int[] QS1000000 = new int[2000];
		for(int i =0; i < QS1000000.length; i++)
		{
			QS1000000[i] = (int)(Math.random() * 100);
		}
		long startTime15 = System.nanoTime();
		quickSort(QS1000000, 0, QS1000000.length-1);
		long duration15 = System.nanoTime() - startTime15;

		//Heap Sort-2000
		int[] HS1000000 = new int[2000];
		for(int i =0; i < HS1000000.length; i++)
		{
			HS1000000[i] = (int)(Math.random() * 100);
		}
		long startTime16 = System.nanoTime();
		heapSort(HS1000000);
		long duration16 = System.nanoTime() - startTime16;
		
		//Resultados
		System.out.println("2000 números aleatorios son ordenados por los sigientes algoritmos: ");
		System.out.println("Insertion Sort: \n" + Arrays.toString(IS1000000));
		System.out.println("Tiempo de ejecución: " + duration13 + " nanosegundos.");
		System.out.println("Merge Sort: \n" + Arrays.toString(MS1000000));
		System.out.println("Tiempo de ejecución: " + duration14 + " nanosegundos.");
		System.out.println("Quick Sort: \n" + Arrays.toString(QS1000000));
		System.out.println("Tiempo de ejecución: " + duration15 + " nanosegundos.");
		System.out.println("Heap Sort: \n" + Arrays.toString(HS1000000));
		System.out.println("Tiempo de ejecución: " + duration16 + " nanosegundos.");
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\n");

		//3000 números aleatorios generados de 0 a 99

		//Llamando a las funciones de cada algoritmo (3000 números)
		
		//Insertion Sort-3000
		int[] IS10000000 = new int[3000];
		for(int i =0; i < IS10000000.length; i++)
		{
			IS10000000[i] = (int)(Math.random() * 100);
		}
		long startTime17 = System.nanoTime();
		insertionSort(IS10000000);
		long duration17 = System.nanoTime() - startTime17;

		//Merge Sort-3000
		int[] MS10000000 = new int[3000];
		for(int i =0; i < MS10000000.length; i++)
		{
			MS10000000[i] = (int)(Math.random() * 100);
		}
		long startTime18 = System.nanoTime();
		sort(MS10000000);
		long duration18 = System.nanoTime() - startTime18;

		//Quick Sort-3000
		int[] QS10000000 = new int[3000];
		for(int i =0; i < QS10000000.length; i++)
		{
			QS10000000[i] = (int)(Math.random() * 100);
		}
		long startTime19 = System.nanoTime();
		quickSort(QS10000000, 0, QS10000000.length-1);
		long duration19 = System.nanoTime() - startTime19;

		//Heap Sort-3000
		int[] HS10000000 = new int[3000];
		for(int i =0; i < HS10000000.length; i++)
		{
			HS10000000[i] = (int)(Math.random() * 100);
		}
		long startTime20 = System.nanoTime();
		heapSort(HS10000000);
		long duration20 = System.nanoTime() - startTime20;

		
		
		//Resultados
		System.out.println("3000 números aleatorios ordenados por los siguientes algoritmos: ");
		System.out.println("Insertion Sort: \n" + Arrays.toString(IS10000000));
		System.out.println("Tiempo de ejecución: " + duration17 + " nanosegundos.");
		System.out.println("Merge Sort: \n" + Arrays.toString(MS10000000));
		System.out.println("Tiempo de ejecución: " + duration18 + " nanosegundos.");
		System.out.println("Quick Sort: \n" + Arrays.toString(QS10000000));
		System.out.println("Tiempo de ejecución: " + duration19 + " nanosegundos.");
		System.out.println("Heap Sort: \n" + Arrays.toString(HS10000000));
		System.out.println("Tiempo de ejecución: " + duration20 + " nanosegundos.");
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------");
		System.out.println("\n");


	}

//Insertion Sort
private static void insertionSort(int[] insert) {
	for (int i = 0; i < insert.length; i++) {
		int value = insert[i];
		int j = i;
		while (j > 0 && insert[j - 1] > value) {
			insert[j] = insert[j - 1];
			j--;
		}
		insert[j] = value;
	}
}


//Merge Sort
private static int[] number;
private static int[] temp;
private static int numbers;

public static void sort(int[] values) {
	number = values;
    numbers = values.length;

    temp = new int[numbers];
    mergeSort(0, numbers - 1);
}

 private static void mergeSort(int low, int high) {
	 if (low < high) {
		 int middle = low + (high - low) / 2;

         mergeSort(low, middle);

         mergeSort(middle + 1, high);

	     merge(low, middle, high);
     }
}

private static void merge(int low, int middle, int high) {
	for (int l = low; l <= high; l++) {
		temp[l] = number[l];
	}

	int l = low;
    int m = middle + 1;
    int k = low;

 	while (l <= middle && m <= high) {
		if (temp[l] <= temp[m]) {
			number[k] = temp[l];
            l++;
        }
        else {
			number[k] = temp[m];
            m++;
        }
        k++;
    }
    while (l <= middle) {
		number[k] = temp[l];
		k++;
		l++;
	}
}

//Quick Sort

public static void quickSort(int[] list) {
    quickSort(list, 0, list.length - 1);
  }

  private static void quickSort(int[] list, int first, int last) {
    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1);
      quickSort(list, pivotIndex + 1, last);
    }
  }

  /** Divide el arreglo[first..last] */
  private static int partition(int[] list, int first, int last) {
    int pivot = list[first]; // Se escoge el primer elemento como pivote
    int low = first + 1; // índice para la búsqueda hacia adelante
    int high = last; // Indice para la búsqueda hacia atrás

    while (high > low) {
      // Búsqueda hacia enfrente desde la izquierda
      while (low <= high && list[low] <= pivot)
        low++;

      // Búsqueda hacia atrás desde la derecha
      while (low <= high && list[high] > pivot)
        high--;

      // Intercambia 2 elementos en la lista
      if (high > low) {
        int temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high] >= pivot)
      high--;

    // Intercambia el elemento pivote en la lista
    if (pivot > list[high]) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }

//Heap Sort
private static int n;
private static int left;
private static int right;
private static int largest;
private static int[] a;
public static void buildHeap(int[] a) {
	n = a.length - 1;
    for (int i = n / 2; i >= 0; i--) {
		maxHeap(a, i);
    }
}

public static void maxHeap(int[] a, int i) {
	left = 2 * i;
    right = 2 * i + 1;
    if (left <= n && a[left] > a[i])
    {
    	largest = left;
    }
    else
    {
        largest = i;
    }

    if (right <= n && a[right] > a[largest])
    {
        largest = right;
    }
    if (largest != i)
    {
        exchange(i, largest);
        maxHeap(a, largest);
    }
}

public static void exchange(int i, int j) {
	int t = a[i];
    a[i] = a[j];
    a[j] = t;
}

public static void heapSort(int[] a0) {
	a = a0;
    buildHeap(a);

    for (int i = n; i > 0; i--)
    {
    	exchange(0, i);
        n = n - 1;
        maxHeap(a, 0);
    }
  }//Termina heapSort
}

/*Así, podemos concluir que:
 Insertion sort es el algoritmo de ordenamiento menos eficiente de los 4 algoritmos estudiados.
 Fin.
 */
